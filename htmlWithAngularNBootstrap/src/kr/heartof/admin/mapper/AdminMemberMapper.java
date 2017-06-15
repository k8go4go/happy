package kr.heartof.admin.mapper;

import java.util.List;

import kr.heartof.admin.vo.MgrVO;
import kr.heartof.admin.vo.StaticsVO;
import kr.heartof.vo.member.UsrVO;

public interface AdminMemberMapper {
	public MgrVO adminLogin(MgrVO vo);
	
	public List<UsrVO> allUsrList();
}
