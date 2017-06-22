package kr.co.mlec.board.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.oreilly.servlet.MultipartRequest;

import common.db.MyAppSqlConfig;
import kr.co.mlec.board.mapper.BoardMapper;
import kr.co.mlec.board.vo.BoardFileVO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.common.file.BitFileRenamePolicy;

@WebServlet("/board/write")
public class WriteServlet extends HttpServlet {
	
	private SqlSession session = null;
	private BoardMapper mapper = null;
	
	public WriteServlet() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(BoardMapper.class);
	}
	
	public void service(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		
		ServletContext context = request.getServletContext();
		String uploadPath = context.getRealPath("/upload");
		
		// upload 하위에 모듈별 날짜 형태의 디렉토리 생성후 저장
		SimpleDateFormat sdf = new SimpleDateFormat(
			"/yyyy/MM/dd"	
		);
		String datePath = sdf.format(new Date());
		
		uploadPath += datePath;
		
		File f = new File(uploadPath);
		if (!f.exists()) {
			f.mkdirs();
		}
		
		// 파일 처리를 위한 API 클래스 호출
		MultipartRequest mRequest = new MultipartRequest(
				request, 
				uploadPath, 
				1024 * 1024 * 10, 
				"UTF-8",
				new BitFileRenamePolicy()
		);
		
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle(mRequest.getParameter("title"));
		boardVO.setWriter(mRequest.getParameter("writer"));
		boardVO.setContent(mRequest.getParameter("content"));
		try {
			mapper.insertBoard(boardVO);

			File file = mRequest.getFile("attachFile");
			if (file != null) {
				String oriName = mRequest.getOriginalFileName("attachFile");
				String systemName = mRequest.getFilesystemName("attachFile");
				long fileSize = file.length();
				
				BoardFileVO boardFile = new BoardFileVO();
				boardFile.setNo(boardVO.getNo());
				boardFile.setOriName(oriName);
				boardFile.setSystemName(systemName);
				boardFile.setFilePath(datePath);
				boardFile.setFileSize(fileSize);
				
				mapper.insertBoardFile(boardFile);
			}
			
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		System.out.println("등록된 게시물 번호 : " + boardVO.getNo());
		
		// 화면 페이지 이동
		RequestDispatcher rd = 
				request.getRequestDispatcher(
					"/view/board/write.jsp"
		);
		rd.forward(request, response);
	}
}














