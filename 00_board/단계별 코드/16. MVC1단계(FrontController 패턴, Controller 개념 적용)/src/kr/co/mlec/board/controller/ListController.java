package kr.co.mlec.board.controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.Controller;

import common.db.MyAppSqlConfig;
import kr.co.mlec.board.mapper.BoardMapper;
import kr.co.mlec.board.vo.BoardVO;

public class ListController implements Controller {
	private SqlSession session;
	private BoardMapper mapper;
	
	public ListController() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		this.mapper = session.getMapper(BoardMapper.class);
	}
	
	public void service(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws Exception {
		
		List<BoardVO> list = mapper.selectBoard();
		
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







