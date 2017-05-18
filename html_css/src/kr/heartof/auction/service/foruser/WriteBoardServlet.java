package kr.heartof.auction.service.foruser;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WriteBoardServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		throw new ServletException("Can't use Get method when you are using form and attached file");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Data Coming");
		
		RequestDispatcher dispacher = request.getServletContext().getRequestDispatcher("/service/foruser/qna.do");
		dispacher.forward(request, response);
	}

}
