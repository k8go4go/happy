package kr.heartof.test.mybatis;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.heartof.service.mapper.AuctionMapper;
import kr.heartof.util.DateUtil;
import kr.heartof.vo.auction.RegAucVO;

public class RegAuctionTest {
	public static void main(String[] args) throws IOException, ParseException {
		String resource = "common/config/sqlMapConfig.xml";
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
		SqlSession session = sqlSessionFactory.openSession();
		
		AuctionMapper mapper = session.getMapper(AuctionMapper.class);
		detail(mapper);
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
	
	public static void regAuction(AuctionMapper mapper) throws ParseException {
		RegAucVO aucVO = new RegAucVO();
		aucVO.setAUC_PROD_NM("이순형바보");
		aucVO.setSHORT_CONT("이순형바보");
		aucVO.setSTART_DTIME(DateUtil.converToDate("2017-06-09 15:25"));
		aucVO.setEND_DTIME(DateUtil.converToDate("2017-06-09 17:55"));
		aucVO.setSTART_PRICE(1000);
		aucVO.setQTY(1);
		aucVO.setMEMB_NUM(11643);
		aucVO.setAUC_TYPE_NUM("1804");
		aucVO.setPROD_CATE_NUM("2202");
		
		mapper.regAuction(aucVO);
	}
	
	public static void detail(AuctionMapper mapper) {
		List<RegAucVO> vo = mapper.detail(22);
		System.out.println(vo.toString());
	}
}
