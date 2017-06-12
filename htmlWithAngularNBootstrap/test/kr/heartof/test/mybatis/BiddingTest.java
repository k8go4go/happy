package kr.heartof.test.mybatis;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.heartof.service.mapper.AuctionMapper;
import kr.heartof.vo.auction.BiddingVO;
import kr.heartof.vo.auction.RegAucVO;
import kr.heartof.vo.auction.RegBiddingVO;

public class BiddingTest {
	public static void main(String[] args) throws IOException {
		String resource = "common/config/sqlMapConfig.xml";
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
		SqlSession session = sqlSessionFactory.openSession();
		
		AuctionMapper mapper = session.getMapper(AuctionMapper.class);
		detail(mapper);
		session.commit();
		session.close();
	}
	
	public static void detail(AuctionMapper mapper) {
		List<RegAucVO> list = mapper.detail(7);
		for(RegAucVO vo : list) {
			System.out.println(vo.toString());
			
			for(BiddingVO bvo : vo.getBiddingList()) {
				System.out.println(bvo);
			}
			
			for(RegBiddingVO rbvo: vo.getBiddingRegList()) {
				System.out.println(rbvo);
			}
		}
	}
}
