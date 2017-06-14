package kr.heartof.servlet.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.heartof.service.mapper.MemberMapper;
import kr.heartof.util.BringSqlSession;

@WebServlet("/ajax/duplicate.do")
public class DuplicateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = BringSqlSession.getSqlSessionInstance();
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		
		String id = request.getParameter("id");
		
		int result = mapper.duplicateCardNumber(id);
		
		response.setContentType("text/plain");
		response.getWriter().write("" + result);
	}
}
