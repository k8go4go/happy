package kr.co.mlec.board.servlet;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.mlec.board.mapper.BoardMapper;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.webserver.HttpServlet;
import kr.co.mlec.webserver.HttpServletRequest;
import kr.co.mlec.webserver.HttpServletResponse;

public class ListServlet extends HttpServlet {
	private SqlSession session;
	private BoardMapper mapper;
	
	public ListServlet() {
		session = MyAppSqlConfig.getSqlSessionInstance();
		mapper = session.getMapper(BoardMapper.class);
	}
	
	public void service(
			HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		List<BoardVO> list = mapper.selectBoard();
		
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
