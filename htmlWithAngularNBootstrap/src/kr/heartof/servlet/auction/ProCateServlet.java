package kr.heartof.servlet.auction;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;

import kr.heartof.service.mapper.ProductMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.vo.product.ProdCateVO;

@WebServlet("/ajax/procate.do")
public class ProCateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = BringSqlSession.getSqlSessionInstance();
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);

		response.setCharacterEncoding("UTF-8");
		String PROD_CATE_NUM = request.getParameter("PROD_CATE_NUM");
		
		List<ProdCateVO> list = mapper.partofProdCates(PROD_CATE_NUM);
		ProdCateVO root = new ProdCateVO();
		root.setLowerCateVO(list);
		
		Gson gson = new Gson();
		String strGson = gson.toJson(root);
		
		System.out.println(strGson);
		
		response.setContentType("application/json");
		response.getWriter().write(strGson);
	}
}
