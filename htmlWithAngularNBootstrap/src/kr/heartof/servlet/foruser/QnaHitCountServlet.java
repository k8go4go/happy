package kr.heartof.servlet.foruser;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.service.mapper.QnaMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.vo.foruser.BoardVO;

@WebServlet("/hitCountQna.do")
public class QnaHitCountServlet extends HttpServlet {
	private static final long serialVersionUID = 2931563842735300771L;
	private static QnaMapper mapper = BringSqlSession.getMapper(QnaMapper.class); 

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.addHeader("Content-Type", "text/html;charset=UTF-8");
		
		int result = mapper.updateHitCount(Integer.parseInt(request.getParameter("BOARD_NUM")));
		BringSqlSession.getInstance().commit();
		
		RequestDispatcher dispacher = request.getServletContext().getRequestDispatcher("/qna.do");
		dispacher.forward(request, response);
	}
}
