package kr.co.mlec.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.Controller;
import org.springframework.web.ModelAndView;

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
	
	public ModelAndView service(
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		List<BoardVO> list = mapper.selectBoard();
		
		ModelAndView mav = 
				new ModelAndView("/view/board/list.jsp");
		mav.addObject("list", list);
		
		return mav;
	}
}







