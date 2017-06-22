package kr.co.mlec.board.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.mlec.board.mapper.BoardMapper;
import kr.co.mlec.board.vo.BoardVO;

@WebServlet("/board/detail")
public class DetailServlet extends HttpServlet {

	private SqlSession session = null;
	private BoardMapper mapper = null;
	public DetailServlet() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(BoardMapper.class);
	}
	
	@Override
	public void service(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); 
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardVO board = null;
		try {
			board = mapper.selectBoardByNo(no);
		} catch (Exception e) {
			new ServletException(e);
		}
		
		// 공유
		request.setAttribute("board", board);
		// 화면 페이지 이동
		RequestDispatcher rd = 
				request.getRequestDispatcher(
					"/view/board/detail.jsp"
		);
		rd.forward(request, response);
	}
}