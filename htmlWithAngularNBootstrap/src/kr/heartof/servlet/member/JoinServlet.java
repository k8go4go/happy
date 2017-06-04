package kr.heartof.servlet.member;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.constant.Code;
import kr.heartof.service.mapper.MemberMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.util.FileUpload;
import kr.heartof.vo.member.ComUsrVO;
import kr.heartof.vo.member.PriUsrVO;
import kr.heartof.vo.member.UsrFileVO;
import kr.heartof.vo.member.UsrVO;

@WebServlet("/joinMember.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static MemberMapper mapper = BringSqlSession.getMapper(MemberMapper.class);   
    public JoinServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.addHeader("Content-Type", "text/html;charset=UTF-8");
		String profileRoot = getServletContext().getInitParameter("profile_upload");
		FileUpload uploadFile = null;
		try {
			uploadFile = new FileUpload(request, profileRoot);
			uploadFile.uploadFiles();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Map<String, String> params = uploadFile.getParamMap();
		
		UsrVO user = null;
		if(params.get("MEMB_CD").equals(Code.MEMBER_PRI_CD.getKey())) {
			user = makePrivateUser(params);
		} else {
			user = makeCompanyUserVO(params);
		}
		
		String msg = null;
		int result = 0;
		if(user.getMEMB_CD().equals(Code.MEMBER_PRI_CD.getKey())) {
			result = mapper.newMember(user);
			result = mapper.newPriMember((PriUsrVO)user);
		} else {
			result = mapper.newMember(user);
			result = mapper.newComMember((ComUsrVO)user);
		}
		
//		mapper.newElecWallet(vo);
//		mapper.newMemberShip(vo);
//		UsrFileVO fileVO = new UsrFileVO();		
//		mapper.newProfile(fileVO);
		
		// BringSqlSession.getInstance().commit();
		
		request.setAttribute("MEMB_CD", params.get("MEMB_CD"));
		request.setAttribute("msg", msg);
		request.setAttribute("result", result);
		
		if(result > 0) {
			msg = "회원가입이 완료되었습니다.";
		} else {
			msg = "회원가입이 실패하였습니다.";
		}
		
		RequestDispatcher dispacher = request.getServletContext().getRequestDispatcher("/main.do?result="+result + "&msg="+msg);
		dispacher.forward(request, response);
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
