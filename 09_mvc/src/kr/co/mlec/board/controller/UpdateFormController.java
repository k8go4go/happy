package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.Controller;
import org.springframework.web.ModelAndView;

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
	
	public ModelAndView service(
			HttpServletRequest request, HttpServletResponse response) 
					throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO board = mapper.selectBoardByNo(no);
		
		ModelAndView mav = new ModelAndView("/view/board/updateForm.jsp");
		mav.addObject("board", board);
		return mav;
	}
}














