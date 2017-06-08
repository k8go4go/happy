package kr.heartof.servlet.auction;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
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

import kr.heartof.constant.Code;
import kr.heartof.service.mapper.AuctionMapper;
import kr.heartof.service.mapper.ProductMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.util.DateUtil;
import kr.heartof.util.FileInfo;
import kr.heartof.util.FileUpload;
import kr.heartof.vo.auction.RegAucFileVO;
import kr.heartof.vo.auction.RegAucVO;
import kr.heartof.vo.member.UsrVO;

@WebServlet("/updateRegAuc.do")
public class UpdateRegAucSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsrVO loginUser = (UsrVO)request.getSession().getAttribute("user");
		AuctionMapper mapper = BringSqlSession.getMapper(AuctionMapper.class);
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		FileUpload uploadFile = null;
		Map<String, String> params = null;
		Map<String, FileInfo> fileParams = null;
		RegAucVO vo = null;
		List<RegAucFileVO> list = null;
		try {
			uploadFile = new FileUpload(request, repository);
			fileParams = uploadFile.uploadFiles();
			params = uploadFile.getParamMap();
			vo = makeRegAuction(params, loginUser);
			list = makeFileVO(fileParams, params);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int result = 0;
		try {
			result = mapper.updateAuction(vo);
		
			for(RegAucFileVO regFile : list) {
				regFile.setAUC_REG_NUM(vo.getAUC_REG_NUM());
				result += mapper.updateAuctionFile(regFile);
			}
		
			BringSqlSession.getInstance().commit();
		} catch(Exception e) {
			result = 0;
			e.printStackTrace();
			BringSqlSession.getInstance().rollback();
		}
		
		String msg = result == 3 ? "경매수정이완료되었습니다." : "경매수정이 실패하였습니다.";
		request.setAttribute("msg", msg);
		request.setAttribute("result", result);
		request.setAttribute("aucVO", vo);
		request.setAttribute("fileListVO", list);
		
		RequestDispatcher dispacher = request.getServletContext().getRequestDispatcher("/regAucList.do?result="+result + "&msg="+msg);
		dispacher.forward(request, response);
	}
	
	private RegAucVO makeRegAuction(Map<String, String> params, UsrVO loginUser) throws ParseException {
		RegAucVO aucVO = new RegAucVO();
		aucVO.setAUC_PROD_NM(params.get("AUC_PROD_NM"));
		aucVO.setSHORT_CONT(params.get("SHORT_CONT"));
		aucVO.setSTART_DTIME(DateUtil.converToDate(params.get("START_DTIME")));
		aucVO.setEND_DTIME(DateUtil.converToDate(params.get("END_DTIME")));
		aucVO.setSTART_PRICE(Integer.parseInt(params.get("START_PRICE")));
		aucVO.setQTY(Integer.parseInt(params.get("QTY")));
		aucVO.setAUC_REG_NUM(Integer.parseInt(params.get("AUC_REG_NUM")));
		aucVO.setAUC_TYPE_NUM(params.get("AUC_TYPE_NUM"));
		aucVO.setPROD_CATE_NUM(params.get("PROD_CATE_NUM"));
		
		return aucVO;
	}
	
	private List<RegAucFileVO> makeFileVO(Map<String, FileInfo> fileParams,
			Map<String, String> params) {
		List<RegAucFileVO> fileList = new ArrayList<RegAucFileVO>();
		
		Set<String> keys = fileParams.keySet();
		
		int count=1;
		for(String key : keys) {
			FileInfo temp = fileParams.get(key);
			RegAucFileVO usrFile = new RegAucFileVO();
			usrFile.setATTAC_FILE_NUM(Integer.parseInt(params.get("ATTAC_FILE_NUM" + (count++))));
			usrFile.setREAL_NM(temp.getREAL_NM());
			usrFile.setFILE_NM(temp.getFILE_NM());
			usrFile.setFILE_SIZE(temp.getFILE_SIZE());
			usrFile.setFILE_PATH(temp.getFILE_PATH());
			fileList.add(usrFile);
		}
		return fileList;
	}
}
