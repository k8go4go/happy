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

@WebServlet("/deleteQna.do")
public class QnaDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 2931563842735300771L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SqlSession sqlSession = BringSqlSession.getSqlSessionInstance();
		QnaMapper mapper = sqlSession.getMapper(QnaMapper.class);
		
		response.addHeader("Content-Type", "text/html;charset=UTF-8");
		
		int board_num = Integer.parseInt(request.getParameter("BOARD_NUM"));
		
		int result = 0;
		try{
			result = mapper.delete(board_num);
			sqlSession.commit();
		}catch(Exception e) {
			sqlSession.rollback();
			result = 0;
			e.printStackTrace();
		}
		
		String msg = null;
		if(result > 0) {
			msg = "삭제가 완료되었습니다.";
		} else {
			msg = "삭제가 실패하였습니다.";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("result", result);
		
		RequestDispatcher dispacher = request.getServletContext().getRequestDispatcher("/qna.do?result="+result + "&msg="+msg);
		dispacher.forward(request, response);
	}
}
