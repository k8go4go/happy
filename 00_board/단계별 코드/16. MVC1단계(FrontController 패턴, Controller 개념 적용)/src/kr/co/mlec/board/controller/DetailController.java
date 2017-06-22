package kr.co.mlec.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.Controller;

import common.db.MyAppSqlConfig;
import kr.co.mlec.board.mapper.BoardMapper;
import kr.co.mlec.board.vo.BoardCommentVO;
import kr.co.mlec.board.vo.BoardFileVO;
import kr.co.mlec.board.vo.BoardVO;

public class DetailController implements Controller {

	private SqlSession session = null;
	private BoardMapper mapper = null;
	public DetailController() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(BoardMapper.class);
	}
	
	@Override
	public void service(
			HttpServletRequest request, HttpServletResponse response) 
					throws Exception {
		response.setContentType("text/html; charset=utf-8"); 
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardVO board = mapper.selectBoardByNo(no);
		request.setAttribute("board", board);
		
		// 게시물과 연관된 파일 정보 추출
		BoardFileVO fileVO = mapper.selectBoardFileByNo(no);
		request.setAttribute("file", fileVO);
		
		// 게시물 댓글과 연관된 정보 추출
		// 댓글 수정폼 처리부분
		String commentNo = request.getParameter("commentNo");
		if (commentNo != null) {
			request.setAttribute("commentNo", commentNo);			
		}
		
		// 댓글 목록 정보 공유
		List<BoardCommentVO> commentList = mapper.selectBoardCommentByNo(no);
		request.setAttribute("commentList", commentList);
	
		// 공유
		// 화면 페이지 이동
		RequestDispatcher rd = 
				request.getRequestDispatcher(
					"/view/board/detail.jsp"
		);
		rd.forward(request, response);
	}
}