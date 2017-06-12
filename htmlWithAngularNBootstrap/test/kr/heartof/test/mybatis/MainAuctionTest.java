package kr.heartof.test.mybatis;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.heartof.service.mapper.AuctionMapper;
import kr.heartof.vo.auction.RegAucVO;
import kr.heartof.vo.foruser.PageVO;

public class MainAuctionTest {
	public static void main(String[] args) throws IOException {
		String resource = "common/config/sqlMapConfig.xml";
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
		SqlSession session = sqlSessionFactory.openSession();
		
		AuctionMapper mapper = session.getMapper(AuctionMapper.class);
		listProduct(mapper);
		session.commit();
		session.close();
	}
	
	public static void listProductForMain(AuctionMapper mapper) {
		List<RegAucVO> list = mapper.listProducting("4700");
		
		for(RegAucVO v : list) {
			System.out.println(v);
		}
	}
	
	public static void listProductThisMonthForMain(AuctionMapper mapper) {
		PageVO vo = new PageVO();
		vo.setSTART(1);
		vo.setEND(3);
		vo.setSearchWord("4700");
		List<RegAucVO> list = mapper.listProductThisMonthForMain(vo);
		
		for(RegAucVO v : list) {
			System.out.println(v);
		}
	}
	
	public static void listProductingForMain(AuctionMapper mapper) {
		PageVO vo = new PageVO();
		vo.setSTART(1);
		vo.setEND(3);
		vo.setSearchWord("4100");
		List<RegAucVO> list = mapper.listProductThisMonthForMain(vo);
		
		
		for(RegAucVO v : list)
			System.out.println(v.getTOT());
	}
	
	public static void listProduct(AuctionMapper mapper) {
		List<RegAucVO> list = mapper.listProduct("4100");
		
		for(RegAucVO v : list)
			System.out.println(v);
	}
}
