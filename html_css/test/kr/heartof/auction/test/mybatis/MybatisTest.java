package kr.heartof.auction.test.mybatis;

import java.io.IOException;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.heartof.auction.constant.Code;
import kr.heartof.auction.service.mapper.MemberMapper;
import kr.heartof.auction.vo.member.UsrVO;

public class MybatisTest {
	public static void main(String[] args) throws IOException {
		String resource = "common/config/sqlMapConfig.xml";
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
		SqlSession session = sqlSessionFactory.openSession();
		
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		
		memberInfo(mapper);
	}
	
	public static void duplicateID(MemberMapper mapper) {
		System.out.println(mapper.duplicateID("2131"));
	}
	
	public static void memberInfo(MemberMapper mapper) {
		UsrVO vo = new UsrVO();
		
		vo.setMEMB_CD(Code.MEMBER_COM_CD.getKey());
		vo.setMEMB_NUM(10000);
		
		UsrVO map = mapper.memberInfo(vo);
		System.out.println(map.toString());
	}
}
