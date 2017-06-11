package kr.heartof.test.mybatis.admin;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.heartof.admin.mapper.AdminAuctionMapper;
import kr.heartof.constant.Code;
import kr.heartof.vo.auction.RegAucVO;
import kr.heartof.vo.foruser.PageVO;

public class MainAuctionTest {
	public static void main(String[] args) throws IOException {
		String resource = "common/config/sqlMapConfig.xml";
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
		SqlSession session = sqlSessionFactory.openSession();
		
		AdminAuctionMapper mapper = session.getMapper(AdminAuctionMapper.class);
		updateApprCD(mapper);
		session.commit();
		session.close();
	}
	
	public static void needApprCD(AdminAuctionMapper mapper) {
		List<RegAucVO> list = mapper.needApprCD();
		
		for(RegAucVO v : list) {
			System.out.println(v);
		}
	}
	
	public static void doneApprCD(AdminAuctionMapper mapper) {
		List<RegAucVO> list = mapper.doneApprCD();
		
		for(RegAucVO v : list) {
			System.out.println(v);
		}
	}
	
	public static void updateApprCD(AdminAuctionMapper mapper) {
		RegAucVO  vo = new RegAucVO();
		vo.setAPPR_CD(Code.REG_AUC_APPROVAL_Y_CD.getKey());
		vo.setAUC_REG_NUM(15);
		int result = mapper.updateApprCD(vo);
		
		System.out.println("updateApprCD : " + result);
	}
}
