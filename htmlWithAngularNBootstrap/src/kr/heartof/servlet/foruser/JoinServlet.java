package kr.heartof.servlet.foruser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.service.mapper.MemberMapper;
import kr.heartof.util.BringSqlSession;

public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = -1754062269370502951L;
	
	private static MemberMapper mapper = BringSqlSession.getMapper(MemberMapper.class);
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("ADDRESS");
	}
	
}
