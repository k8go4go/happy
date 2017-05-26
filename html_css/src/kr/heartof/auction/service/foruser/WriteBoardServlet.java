package kr.heartof.auction.service.foruser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;

import kr.heartof.auction.constant.Code;
import kr.heartof.auction.service.mapper.QnaMapper;
import kr.heartof.auction.vo.foruser.AttacFileVO;
import kr.heartof.auction.vo.foruser.BoardVO;
import kr.heartof.auction.vo.member.ComUsrVO;
import kr.heartof.auction.vo.member.PriUsrVO;
import kr.heartof.auction.vo.member.UsrVO;

public class WriteBoardServlet extends HttpServlet {
	private static QnaMapper mapper = null; 
	static {
		String resource = "common/config/sqlMapConfig.xml";
		SqlSessionFactory sqlSessionFactory;
		try {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
			SqlSession session = sqlSessionFactory.openSession();
			mapper = session.getMapper(QnaMapper.class);
		} catch (IOException e) {
		}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.addHeader("Content-Type", "text/html;charset=UTF-8");

		BoardVO board = makeBoard(request);
		mapper.insert(board);

		RequestDispatcher dispacher = request.getServletContext().getRequestDispatcher("/service/foruser/qna.do");
		dispacher.forward(request, response);
	}

	public BoardVO makeBoard(HttpServletRequest request) throws ServletException, IOException {
		UsrVO vo = (UsrVO) request.getSession().getAttribute("user");
		
		if (vo == null)
			throw new ServletException("Session Destory");

		BoardVO board = new BoardVO();

		board.setMEMB_NUM(vo.getMEMB_NUM());
		if (vo.getMEMB_CD().equals(Code.MEMBER_PRI_CD.getKey())) {
			board.setWRITER_NM(((PriUsrVO) vo).getNM());
		} else {
			board.setWRITER_NM(((ComUsrVO) vo).getCHGR_NM());
		}

		board.setTITLE(request.getParameter("TITLE"));
		board.setCONT(request.getParameter("CONT"));

		if (request.getParameter("BOARD_NUM") != null) {
			board.setHIGH_BOARD_NUM(Integer.parseInt(request.getParameter("BOARD_NUM")));
		} else {
			board.setHIGH_BOARD_NUM(0);
		}

		board.setREVIEW_CNT(0);
		createFile(request, board);
		
		return board;
	}

	private void createFile(HttpServletRequest request, BoardVO board) throws IOException, ServletException {
		ByteArrayOutputStream out = null;
	    InputStream filecontent = request.getInputStream();
	    
		try {
//			request.getContextPath() + File.separator + "download" + File.separator + fileName
			out = new ByteArrayOutputStream(10 * 1024 * 1024);

			int read = 0;
			final byte[] bytes = new byte[1024];

			while ((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			
			byte[] readData = out.toByteArray();
			String fileName = getFileName(readData);
			
			AttacFileVO fileVO = new AttacFileVO();
		    fileVO.setREAL_NM(fileName);
		    board.setAttacFileVO(fileVO);			
		} catch (FileNotFoundException fne) {
			throw new ServletException("Can't not make uploaded your file");
		} finally {
			if (out != null) {
				out.close();
			}
			if (filecontent != null) {
				filecontent.close();
			}
		}
	}

	private String getTitle(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
	
	private String getFileName(byte[] readData) throws UnsupportedEncodingException {
		String content = new String(readData, "UTF-8");		
		String[] conts = content.split(";");		
		for(String data : conts) {
			if (data.trim().startsWith("filename")) {
				String[] interConts = data.trim().split("\\r\\n");
				for(String interData : interConts) {
					if(interData.trim().startsWith("filename")) {
						return interData.substring(interData.indexOf('=') + 1).trim().replaceAll("\"", "");
					}
				}
			}
		}
		return null;
	}
}
