package kr.heartof.test.mybatis;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.google.gson.Gson;

import kr.heartof.service.mapper.ProductMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.vo.product.ProdCateVO;

public class BoardTest {
	public static void main(String[] args) throws IOException {
		SqlSession sqlSession = BringSqlSession.getSqlSessionInstance();
		ProductMapper mapper = sqlSession.getMapper(ProductMapper.class);
		highestCate(mapper);
		
		sqlSession.commit();
		sqlSession.close();
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
