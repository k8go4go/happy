package kr.co.mlec.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.Controller;
import org.springframework.web.ModelAndView;

import com.google.gson.Gson;

import common.db.MyAppSqlConfig;
import kr.co.mlec.board.mapper.BoardMapper;
import kr.co.mlec.board.vo.BoardCommentVO;

/**
 * 댓글 목록 Ajax 처리 클래스
 * @author Administrator
 */
public class CommentListController implements Controller {

	private SqlSession session = null;
	private BoardMapper mapper = null;
	public CommentListController() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(BoardMapper.class);
	}
	
	@Override
	public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int no = 
				Integer.parseInt(request.getParameter("no"));
		List<BoardCommentVO> commentList = 
				mapper.selectBoardCommentByNo(no);
		String result = new Gson().toJson(commentList);
		return new ModelAndView("ajax:" + result);
	}
	
}
















