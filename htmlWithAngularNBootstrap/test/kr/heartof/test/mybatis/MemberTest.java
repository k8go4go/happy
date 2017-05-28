package kr.heartof.test.mybatis;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.heartof.constant.Code;
import kr.heartof.service.mapper.MemberMapper;
import kr.heartof.vo.member.ComUsrVO;
import kr.heartof.vo.member.PriUsrVO;
import kr.heartof.vo.member.UsrFileVO;
import kr.heartof.vo.member.UsrVO;

public class MemberTest {
	public static void main(String[] args) throws IOException {
		String resource = "common/config/sqlMapConfig.xml";
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
		SqlSession session = sqlSessionFactory.openSession();
		
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		
		updateComMemberInfo(mapper);
		session.commit();
		session.close();
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
	
	public static void memberInfoFile(MemberMapper mapper) {
		UsrFileVO file = mapper.memberInfoFile(1);
		System.out.println(file);
	}
	
	public static void updateBasicMemberInfo(MemberMapper mapper) {
		UsrVO vo = new UsrVO();
		
		vo.setMEMB_NUM(1);
		vo.setMEMB_CD(Code.MEMBER_COM_CD.getKey());
		vo.setCRE_DEG_CD(Code.MEMBER_CRED_DEG_OK_CD.getKey());
		vo.setTEL_NUM("010-123-1231");
		vo.setMOBIL_NUM("010-123-1231");
		vo.setEMAIL("8go4go");
		
		int result = mapper.updateBasicMemberInfo(vo);
		System.out.println(result);
	}
	
	public static void updatePriMemberInfo(MemberMapper mapper) {
		PriUsrVO vo = new PriUsrVO();
		
		vo.setMEMB_NUM(1);
		vo.setSOC_REG_NUM("7605214545541");
		vo.setNM("김용재바보");
		
		int result = mapper.updatePriMemberInfo(vo);
		System.out.println(result);
	}
	
	public static void updateComMemberInfo(MemberMapper mapper) {
		ComUsrVO vo = new ComUsrVO();
		
		vo.setMEMB_NUM(10000);
		vo.setCORP_NM("비트학원");
		vo.setBUS_NUM("1111123211");
		vo.setCHGR_NM("김용재바보");
		vo.setCEO_NM("김용재바보");
		
		int result = mapper.updateComMemberInfo(vo);
		System.out.println(result);
	}
}
