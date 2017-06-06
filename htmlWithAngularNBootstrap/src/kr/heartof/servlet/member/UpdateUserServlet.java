package kr.heartof.servlet.member;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.heartof.constant.Code;
import kr.heartof.service.mapper.MemberMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.util.FileInfo;
import kr.heartof.util.FileUpload;
import kr.heartof.vo.member.ComUsrVO;
import kr.heartof.vo.member.PriUsrVO;
import kr.heartof.vo.member.UsrFileVO;
import kr.heartof.vo.member.UsrVO;

@WebServlet("/updateUser.do")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberMapper mapper = null; 
    public UpdateUserServlet() {
    	mapper = BringSqlSession.getMapper(MemberMapper.class);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsrVO loginUser = (UsrVO)request.getSession().getAttribute("user");
		
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
			user.setMEMB_NUM(loginUser.getMEMB_NUM());
			result += mapper.updateBasicMemberInfo(user);
			if(user.getMEMB_CD().equals(Code.MEMBER_PRI_CD.getKey())) {
				result += mapper.updatePriMemberInfo((PriUsrVO)user);
			} else {
				result += mapper.updateComMemberInfo((ComUsrVO)user);
			}
			
			if(fileParams != null) {
				List<UsrFileVO> insertFileList = makeUsrFileVO(user, fileParams);
				for(UsrFileVO fVo : insertFileList) { 
					if(loginUser.getUSR_FILE() != null) {
						result += mapper.updateProfile(fVo);
					} else {
						result += mapper.newProfile(fVo);
					}
					
					user.setUSR_FILE(fVo);
				}
			}
			
			BringSqlSession.getInstance().commit();
		} catch(Exception e) {
			BringSqlSession.getInstance().rollback();
			result = 0;			
			e.printStackTrace();
		}
		
		String msg = result >= 4 ? "사용자정보가 변경되었습니다." : "사용자정보 변경이 실패하였습니다.";
		request.getSession().setAttribute("user", user);
		
		response.setContentType("text/plain");
		response.getWriter().write("" + msg);
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
