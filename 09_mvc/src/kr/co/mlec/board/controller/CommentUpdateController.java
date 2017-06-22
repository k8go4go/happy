package kr.co.mlec.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.Controller;
import org.springframework.web.ModelAndView;
import org.springframework.web.WebUtil;

import com.google.gson.Gson;

import common.db.MyAppSqlConfig;
import kr.co.mlec.board.mapper.BoardMapper;
import kr.co.mlec.board.vo.BoardCommentVO;

public class CommentUpdateController implements Controller {

	private SqlSession session = null;
	private BoardMapper mapper = null;
	
	public CommentUpdateController() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(BoardMapper.class);
	}
	
	@Override
	public ModelAndView service(
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BoardCommentVO comment = 
				(BoardCommentVO)WebUtil.toVO(
						request, BoardCommentVO.class);
		
		mapper.updateBoardComment(comment);
		session.commit();
		
		List<BoardCommentVO> commentList = 
				mapper.selectBoardCommentByNo(comment.getNo());
		String result = new Gson().toJson(commentList);
		return new ModelAndView("ajax:" + result);
	}
}











