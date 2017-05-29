package kr.heartof.starter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import kr.heartof.service.mapper.ProductMapper;
import kr.heartof.util.BringSqlSession;

public class Starter implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		context.setAttribute("menu", "");
		
		ProductMapper mapper = BringSqlSession.getInstance().getMapper(ProductMapper.class);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		context.removeAttribute("menu");
		
		BringSqlSession.sessionClose();
	}
}
