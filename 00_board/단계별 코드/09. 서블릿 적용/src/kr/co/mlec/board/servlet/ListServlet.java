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

@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private SqlSession session;
	private BoardMapper mapper;
	
	public ListServlet() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		this.mapper = session.getMapper(BoardMapper.class);
	}
	
	public void service(
			HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		List<BoardVO> list = null;
		try {
			list = mapper.selectBoard();
		} catch (Exception e) {
			new ServletException(e);
		}
		
		out.println("<html>");
		out.println("  <head>");
		out.println("    <title>게시판</title>");
		out.println("  </head>");
		out.println("  <body>");
		out.println("  	 <table>");
		out.println("  	   <tr>");
		out.println("		 <th>번호</th>");
		out.println("		 <th>제목</th>");
		out.println("		 <th>글쓴이</th>");
		out.println("		 <th>등록일자</th>");
		out.println("  	   </tr>");
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd"
		);
		for (BoardVO b : list) {
			out.println("<tr>");
			out.printf ("  <td>%d</td>", b.getNo());
			out.printf ("  <td><a href='detail?no=%d'>%s</a></td>", b.getNo(), b.getTitle());
			out.printf ("  <td>%s</td>", b.getWriter());
			out.printf ("  <td>%s</td>", 
						sdf.format(b.getRegDate())
			);
			out.println("</tr>");
		}
		if (list.size() == 0) {
			out.println("<tr>");
			out.println("  <td colspan='4'>게시물이 존재하지 않습니다.</td>");
			out.println("</tr>");
		}
		out.println("    </table>");		
		out.println("    <a href='writeForm'>글쓰기</a>");
		out.println("  </body>");
		out.println("</html>");
	}
}
