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

@WebServlet("/hitCountQna.do")
public class QnaHitCountServlet extends HttpServlet {
	private static final long serialVersionUID = 2931563842735300771L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.addHeader("Content-Type", "text/html;charset=UTF-8");
		SqlSession sqlSession = BringSqlSession.getSqlSessionInstance();
		QnaMapper mapper = sqlSession.getMapper(QnaMapper.class);
		
		
		int result = 0;
		try {
			result = mapper.updateHitCount(Integer.parseInt(request.getParameter("BOARD_NUM")));
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			result = 0;
			e.printStackTrace();
		}
		
		RequestDispatcher dispacher = request.getServletContext().getRequestDispatcher("/qna.do");
		dispacher.forward(request, response);
	}
}
