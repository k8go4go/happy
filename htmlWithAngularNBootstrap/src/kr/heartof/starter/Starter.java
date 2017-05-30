package kr.heartof.starter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import kr.heartof.admin.mapper.AdminMapper;
import kr.heartof.admin.mapper.PathVO;
import kr.heartof.service.mapper.ProductMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.vo.product.ProdCateVO;

public class Starter implements ServletContextListener{
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		
		ProductMapper mapper = BringSqlSession.getInstance().getMapper(ProductMapper.class);
		AdminMapper pathMapper = BringSqlSession.getInstance().getMapper(AdminMapper.class);
		List<ProdCateVO> temp = mapper.getProdCates(null);
		List<ProdCateVO> height = makeHighestMenu(temp);
		makeSecondMenu(height, temp);
		
		context.setAttribute("menu", height);
		context.setAttribute("path", changePathListToMap(pathMapper.path()));
	}
	
	private Map<Integer, PathVO> changePathListToMap(List<PathVO> list) {
		Map<Integer, PathVO> map = new HashMap<Integer, PathVO>();
		
		for(PathVO v : list) {
			map.put(v.getPATH_NUM(), v);
		}
		
		return map;
	}
	
	private List<ProdCateVO> makeHighestMenu(List<ProdCateVO> temp) {
		List<ProdCateVO> highestMenu = new ArrayList<ProdCateVO>();
		for(ProdCateVO t : temp) {
			if(t.getHIGH_PROD_CATE_NUM() == null)
			highestMenu.add(t);
		}
		return highestMenu;
	}
	
	private void makeSecondMenu(List<ProdCateVO> highestMenu, List<ProdCateVO> temp) {
		List<ProdCateVO> second = new ArrayList<ProdCateVO>();
		for(ProdCateVO t : temp) {
			if(t.getPARENT_HIGH_PROD_CATE_NUM() == null)
				second.add(t);
		}
		
		for(ProdCateVO h :highestMenu) {
			List<ProdCateVO> moveTemp = new ArrayList<ProdCateVO>();
			boolean isAdd = false;
			for(ProdCateVO s : second) {
				if(h.getPROD_CATE_NUM().equals(s.getHIGH_PROD_CATE_NUM())) {
					moveTemp.add(s);
					isAdd = true;
				}
			}
			if(isAdd) {
				h.setLowerCateVO(moveTemp);
			}
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		context.removeAttribute("menu");
		
		BringSqlSession.sessionClose();
	}
}
