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

@WebServlet("/deleteQna.do")
public class QnaDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 2931563842735300771L;
	private static QnaMapper mapper = BringSqlSession.getMapper(QnaMapper.class); 

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.addHeader("Content-Type", "text/html;charset=UTF-8");
		
		int board_num = Integer.parseInt(request.getParameter("BOARD_NUM"));
		System.out.println(board_num);
		
		int result = mapper.delete(board_num);
		BringSqlSession.getInstance().commit();
		
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
