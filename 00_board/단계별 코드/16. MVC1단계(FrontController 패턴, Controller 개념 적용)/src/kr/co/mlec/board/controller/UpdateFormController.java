package kr.co.mlec.board.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.Controller;

import common.db.MyAppSqlConfig;
import kr.co.mlec.board.mapper.BoardMapper;
import kr.co.mlec.board.vo.BoardVO;

public class UpdateFormController implements Controller {
	
	private SqlSession session = null;
	private BoardMapper mapper = null;
	
	public UpdateFormController() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(BoardMapper.class);
	}
	
	public void service(
			HttpServletRequest request, HttpServletResponse response) 
					throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO board = mapper.selectBoardByNo(no);
		
		// 공유
		request.setAttribute("board", board);
		// 화면 페이지 이동
		RequestDispatcher rd = 
				request.getRequestDispatcher(
					"/view/board/updateForm.jsp"
		);
		rd.forward(request, response);
	}
}














