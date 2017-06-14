package kr.heartof.servlet.foruser;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.heartof.service.mapper.QnaMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.vo.foruser.BoardVO;

@WebServlet("/insertQna.do")
public class QnaWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 2931563842735300771L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.addHeader("Content-Type", "text/html;charset=UTF-8");
		SqlSession sqlSession = BringSqlSession.getSqlSessionInstance();
		QnaMapper mapper = sqlSession.getMapper(QnaMapper.class);
		
		
		BoardVO vo = new BoardVO();
		vo.setTITLE(request.getParameter("TITLE"));
		vo.setCONT(request.getParameter("CONT"));
		vo.setMEMB_NUM(Integer.parseInt(request.getParameter("MEMB_NUM")));
		vo.setWRITER_NM(request.getParameter("WRITER_NM"));
		if(request.getParameter("HIGH_BOARD_NUM") != null)
			vo.setHIGH_BOARD_NUM(Integer.parseInt(request.getParameter("HIGH_BOARD_NUM")));
		
		
		int result = 0;
		try {
			result = mapper.insert(vo);
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			result = 0;
			e.printStackTrace();
		}
		
		
		String msg = null;
		if(result > 0) {
			msg = "글쓰기가 완료되었습니다.";
		} else {
			msg = "글쓰기가  실패하였습니다.";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("result", result);
		
		RequestDispatcher dispacher = request.getServletContext().getRequestDispatcher("/qna.do?result="+result + "&msg="+msg);
		dispacher.forward(request, response);
	}
}
