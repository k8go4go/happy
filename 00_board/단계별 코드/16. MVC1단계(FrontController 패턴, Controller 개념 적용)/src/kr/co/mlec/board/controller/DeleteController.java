package kr.co.mlec.board.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.Controller;

import common.db.MyAppSqlConfig;
import kr.co.mlec.board.mapper.BoardMapper;

public class DeleteController implements Controller {
	
	private SqlSession session = null;
	private BoardMapper mapper = null;
	
	public DeleteController() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(BoardMapper.class);
	}
	
	public void service(
			HttpServletRequest request, HttpServletResponse response) 
					throws Exception {
		int no = Integer.parseInt(request.getParameter("no"));
		mapper.deleteBoard(no);
		session.commit();
		
		// 화면 페이지 이동
		RequestDispatcher rd = 
				request.getRequestDispatcher(
					"/view/board/delete.jsp"
		);
		rd.forward(request, response);
	}
}
