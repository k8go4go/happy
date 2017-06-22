package kr.co.mlec.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.Controller;
import org.springframework.web.ModelAndView;
import org.springframework.web.WebUtil;

import common.db.MyAppSqlConfig;
import kr.co.mlec.board.mapper.BoardMapper;
import kr.co.mlec.board.vo.BoardVO;

public class UpdateController implements Controller {
	
	private SqlSession session = null;
	private BoardMapper mapper = null;
	
	public UpdateController() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(BoardMapper.class);
	}
	
	public ModelAndView service(
			HttpServletRequest request, HttpServletResponse response) 
					throws Exception {
		BoardVO boardVO = 
				(BoardVO)WebUtil.toVO(request, BoardVO.class);

		mapper.updateBoard(boardVO);
		session.commit();
		
		return new ModelAndView("/view/board/update.jsp");
	}
}







