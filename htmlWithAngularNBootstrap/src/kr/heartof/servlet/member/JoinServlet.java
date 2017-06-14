package kr.heartof.servlet.member;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import kr.heartof.constant.Code;
import kr.heartof.service.mapper.MemberMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.util.FileInfo;
import kr.heartof.util.FileUpload;
import kr.heartof.util.MemberShipCardGenerator;
import kr.heartof.vo.member.ComUsrVO;
import kr.heartof.vo.member.ElecWalletVO;
import kr.heartof.vo.member.MembershipVO;
import kr.heartof.vo.member.PriUsrVO;
import kr.heartof.vo.member.UsrFileVO;
import kr.heartof.vo.member.UsrVO;

@WebServlet("/joinMember.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public JoinServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlSession sqlSession = BringSqlSession.getSqlSessionInstance();
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		
		FileUpload uploadFile = null;
		Map<String, String> params = null;
		Map<String, FileInfo> fileParams = null;
		try {
			uploadFile = new FileUpload(request, repository);
			fileParams = uploadFile.uploadFiles();
			params = uploadFile.getParamMap();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		UsrVO user = null;
		if(params.get("MEMB_CD").equals(Code.MEMBER_PRI_CD.getKey())) {
			user = makePrivateUser(params);
		} else {
			user = makeCompanyUserVO(params);
		}
		
		int result = 0;
		try {
			if(user.getMEMB_CD().equals(Code.MEMBER_PRI_CD.getKey())) {
				result = mapper.newMember(user);
				result = mapper.newPriMember((PriUsrVO)user);
			} else {
				result = mapper.newMember(user);
				result = mapper.newComMember((ComUsrVO)user);
			}
			
			mapper.newElecWallet(makeElecWalletVO(user));
			mapper.newMemberShip(makeMembershipVO(user));
			
			if(fileParams != null) {
				List<UsrFileVO> insertFileList = makeUsrFileVO(user, fileParams);
				for(UsrFileVO fVo : insertFileList) 
					mapper.newProfile(fVo);
			}
			
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			result = 0;			
			e.printStackTrace();
		}
		
		String msg = result >= 4 ? "회원가입이 완료되었습니다." : "회원가입이 실패하였습니다.";
		
		request.setAttribute("MEMB_CD", params.get("MEMB_CD"));
		request.setAttribute("msg", msg);
		request.setAttribute("result", result);
		
		RequestDispatcher dispacher = request.getServletContext().getRequestDispatcher("/main.do?result="+result + "&msg="+msg);
		dispacher.forward(request, response);
	}
	
	private List<UsrFileVO> makeUsrFileVO(UsrVO vo, Map<String, FileInfo> fileParams) {
		List<UsrFileVO> fileList = new ArrayList<UsrFileVO>();
		
		Set<String> keys = fileParams.keySet();
		
		for(String key : keys) {
			FileInfo temp = fileParams.get(key);
			UsrFileVO usrFile = new UsrFileVO();
			usrFile.setMEMB_NUM(vo.getMEMB_NUM());
			usrFile.setREAL_NM(temp.getREAL_NM());
			usrFile.setFILE_NM(temp.getFILE_NM());
			usrFile.setFILE_SIZE(temp.getFILE_SIZE());
			usrFile.setFILE_PATH(temp.getFILE_PATH());
			fileList.add(usrFile);
		}
		return fileList;
	}
	
	private ElecWalletVO makeElecWalletVO(UsrVO vo) {
		ElecWalletVO wallet = new ElecWalletVO();
		wallet.setPOINT(10000);
		wallet.setMEMB_NUM(vo.getMEMB_NUM());
		return wallet;
	}
	
	private MembershipVO makeMembershipVO(UsrVO vo) {
		MembershipVO membershipvo = new MembershipVO();
		membershipvo.setISSUE_CNT(1);
		membershipvo.setDEG(Code.MEMBER_DEG_GENERAL_CD.getKey());
		membershipvo.setMSHIP_CARD_NUM(MemberShipCardGenerator.generate(16, 1).get(0));
		membershipvo.setPOINT(10000);
		membershipvo.setMEMB_NUM(vo.getMEMB_NUM());
		membershipvo.setNM("비트경매멤버쉽");
		return membershipvo;
	}
	
	private PriUsrVO makePrivateUser(Map<String, String> params) {
		PriUsrVO user = new PriUsrVO();
		user.setADDRESS(params.get("ADDRESS"));
		user.setDETA_ADDRESS(params.get("DETA_ADDRESS"));
		user.setCRE_DEG_CD("");
		user.setEMAIL(params.get("EMAIL"));
		user.setSEC_NUM(params.get("SEC_NUM"));
		user.setTEL_NUM(params.get("TEL_NUM"));
		user.setMOBIL_NUM(params.get("MOBIL_NUM"));
		user.setMEMB_CD(params.get("MEMB_CD"));
		user.setMEMB_ID(params.get("MEMB_ID"));
		user.setMAIL_CD(params.get("MAIL_CD"));
		user.setWITHDRAWAL_CD(Code.WITHDRAWAL_N_CD.getKey());
		user.setZIP_NUM(params.get("ZIP_NUM"));
		
		user.setNM(params.get("NM"));
		user.setSOC_REG_NUM(params.get("SOC_REG_NUM"));
		
		return user;
	}
	
	private ComUsrVO makeCompanyUserVO(Map<String, String> params) {
		ComUsrVO user = new ComUsrVO();
		user.setADDRESS(params.get("ADDRESS"));
		user.setDETA_ADDRESS(params.get("DETA_ADDRESS"));
		user.setCRE_DEG_CD(Code.MEMBER_CRED_DEG_OK_CD.getKey());
		user.setEMAIL(params.get("EMAIL"));
		user.setSEC_NUM(params.get("SEC_NUM"));
		user.setTEL_NUM(params.get("TEL_NUM"));
		user.setMOBIL_NUM(params.get("MOBIL_NUM"));
		user.setMEMB_CD(params.get("MEMB_CD"));
		user.setMAIL_CD(params.get("MAIL_CD"));
		user.setMEMB_ID(params.get("MEMB_ID"));
		user.setWITHDRAWAL_CD(Code.WITHDRAWAL_N_CD.getKey());
		user.setZIP_NUM(params.get("ZIP_NUM"));
		
		user.setCORP_NM(params.get("CORP_NM"));
		user.setCEO_NM(params.get("CEO_NM"));
		user.setCHGR_NM(params.get("CHGR_NM"));
		user.setBUS_NUM(params.get("BUS_NUM"));
		
		return user;
	}
}
