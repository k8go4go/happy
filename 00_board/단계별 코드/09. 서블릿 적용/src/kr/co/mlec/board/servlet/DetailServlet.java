package kr.co.mlec.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.mlec.board.mapper.BoardMapper;
import kr.co.mlec.board.vo.BoardVO;

@WebServlet("/board/detail")
public class DetailServlet extends HttpServlet {

	private SqlSession session = null;
	private BoardMapper mapper = null;
	public DetailServlet() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(BoardMapper.class);
	}
	
	@Override
	public void service(
			HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); 
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardVO boardVO = null;
		try {
			boardVO = mapper.selectBoardByNo(no);
		} catch (Exception e) {
			new ServletException(e);
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>게시판</title></head>");
		out.println("<body>");		
		out.println("<table>");		
		out.println("<tr>");		
		out.println("  <td>번호<td>");
		out.printf ("  <td>%d<td>", no);
		out.println("</tr>");		
		out.println("<tr>");		
		out.println("  <td>제목<td>");
		out.printf ("  <td>%s<td>", boardVO.getTitle());
		out.println("</tr>");		
		out.println("<tr>");		
		out.println("  <td>글쓴이<td>");
		out.printf ("  <td>%s<td>", boardVO.getWriter());
		out.println("</tr>");		
		out.println("<tr>");		
		out.println("  <td>내용<td>");
		out.printf ("  <td>%s<td>", boardVO.getContent());
		out.println("</tr>");		
		out.println("<tr>");		
		out.println("  <td>등록일<td>");
		out.printf ("  <td>%s<td>", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(boardVO.getRegDate()));
		out.println("</tr>");		
		out.println("</table>");		
		out.println("<a href='updateForm?no=" + no + "'>수정</a>");
		out.println("<a href='delete?no=" + no + "'>삭제</a>");
		out.println("<a href='list'>목록</a>");
		out.println("</body>");
		out.println("</html>");
	}
}