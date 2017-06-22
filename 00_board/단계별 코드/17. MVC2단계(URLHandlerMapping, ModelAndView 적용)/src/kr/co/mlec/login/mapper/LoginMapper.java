package kr.co.mlec.login.mapper;

import kr.co.mlec.login.vo.LoginVO;

/**
 * 게시물에 대한 데이터를 처리하는 DAO 클래스
 * @author Administrator
 */
public interface LoginMapper {
	public LoginVO selectLogin(LoginVO param) throws Exception;
}









