package kr.heartof.test.mybatis;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.google.gson.Gson;

import kr.heartof.service.mapper.ProductMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.vo.product.ProdCateVO;

public class BoardTest {
	public static void main(String[] args) throws IOException {
		String resource = "common/config/sqlMapConfig.xml";
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
		SqlSession session = sqlSessionFactory.openSession();
		
		ProductMapper mapper = BringSqlSession.getInstance().getMapper(ProductMapper.class);
		highestCate(mapper);
		
		session.commit();
		session.close();
	}
	
	public static void highestCate(ProductMapper mapper) {
		// ProductCate cate가 널일 경우 최상위
		List<ProdCateVO> list = mapper.partofProdCates(null);
		for(ProdCateVO vo : list) {
			System.out.println(vo);
		}
		
		Gson gson = new Gson();
		String strGson = gson.toJson(list);
		System.out.println(strGson);
	}
}
