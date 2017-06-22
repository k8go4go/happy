package kr.co.mlec.board.servlet;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private SqlSession session;
	private BoardMapper mapper;
	
	public ListServlet() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		this.mapper = session.getMapper(BoardMapper.class);
	}
	
	public void service(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		List<BoardVO> list = null;
		try {
			list = mapper.selectBoard();
		} catch (Exception e) {
			throw new ServletException(e);
		}
		// 공유
		request.setAttribute("list", list);
		// 화면 페이지 이동
		RequestDispatcher rd = 
				request.getRequestDispatcher(
					"/view/board/list.jsp"
		);
		rd.forward(request, response);
	}
}







