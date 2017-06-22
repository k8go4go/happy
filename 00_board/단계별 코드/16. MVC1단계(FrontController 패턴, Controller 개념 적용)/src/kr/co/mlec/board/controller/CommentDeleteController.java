package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.Controller;

import common.db.MyAppSqlConfig;
import kr.co.mlec.board.mapper.BoardMapper;

public class CommentDeleteController implements Controller {

	private SqlSession session = null;
	private BoardMapper mapper = null;
	
	public CommentDeleteController() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(BoardMapper.class);
	}
	
	public void service(
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		int no = Integer.parseInt(request.getParameter("no"));
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		
		mapper.deleteBoardComment(commentNo);
		session.commit();
		
		response.sendRedirect("detail.do?no=" + no);
	
	}
}











