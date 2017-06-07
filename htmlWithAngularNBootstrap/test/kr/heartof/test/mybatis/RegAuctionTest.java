package kr.heartof.test.mybatis;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.heartof.service.mapper.AuctionMapper;
import kr.heartof.vo.auction.RegAucVO;

public class RegAuctionTest {
	public static void main(String[] args) throws IOException {
		String resource = "common/config/sqlMapConfig.xml";
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
		SqlSession session = sqlSessionFactory.openSession();
		
		AuctionMapper mapper = session.getMapper(AuctionMapper.class);
		aucListForMember(mapper);
		session.commit();
		session.close();
	}
	
	public static void allProgressing(AuctionMapper mapper) {
		List<RegAucVO> list = mapper.allProgressing();
		
		for(RegAucVO vo : list) {
			System.out.println(vo.toString());
		}
	}
	
	public static void aucListForMember(AuctionMapper mapper) {
		List<RegAucVO> list = mapper.aucListForMember(11627);
		
		for(RegAucVO vo : list) {
			System.out.println(vo.toString());
		}
	}
}
