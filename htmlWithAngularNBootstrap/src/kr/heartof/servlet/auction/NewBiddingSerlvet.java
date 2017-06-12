package kr.heartof.servlet.auction;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.heartof.service.mapper.AuctionMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.util.DateUtil;
import kr.heartof.util.FileInfo;
import kr.heartof.vo.auction.BiddingVO;
import kr.heartof.vo.auction.RegAucFileVO;
import kr.heartof.vo.auction.RegAucVO;
import kr.heartof.vo.member.UsrVO;

@WebServlet("/newBidding.do")
public class NewBiddingSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsrVO loginUser = (UsrVO)request.getSession().getAttribute("user");
		AuctionMapper mapper = BringSqlSession.getMapper(AuctionMapper.class);
		
		int result = 0;
		try {
			RegAucVO rvo = new RegAucVO();
			rvo.setMEMB_NUM(6);
			rvo.setAUC_REG_NUM(Integer.parseInt(request.getParameter("AUC_REG_NUM")));
			
			int maxPrice = mapper.maxBiddingPrice(Integer.parseInt(request.getParameter("AUC_REG_NUM")));
			int bidNum = mapper.getBidNum(rvo);
			
			BiddingVO vo = new BiddingVO();
			vo.setBID_PRICE(Integer.parseInt(request.getParameter("BID_PRICE")));
			vo.setBID_NUM(bidNum);
			
			if(maxPrice < Integer.parseInt(request.getParameter("BID_PRICE"))) {
				result = mapper.newbiddingHistory(vo);
				BringSqlSession.getInstance().commit(); 
			} else {
				result = -1;
			}
		} catch(Exception e) {
			result = 0;
			e.printStackTrace();
			BringSqlSession.getInstance().rollback();
		}
		
		String msg = result == 1 ? "입찰 등록이 완료되었습니다" : "입찰 등록이 실패되었습니다";
		if(result == -1)
			msg = "최고금액보다 낮은 금액은 입찰할수 없습니다."; 
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.write(makeJson(msg, String.valueOf(result)));
	}
	
	private String makeJson(String msg, String result) {
		Map<String, String> map = new HashMap<>();
		map.put("msg", msg);
		map.put("result", result);
		Gson gson = new Gson();
		String gsonStr = gson.toJson(map);
		
		return gsonStr;
	}
	
	private RegAucVO makeRegAuction(Map<String, String> params, UsrVO loginUser) throws ParseException {
		RegAucVO aucVO = new RegAucVO();
		aucVO.setAUC_PROD_NM(params.get("AUC_PROD_NM"));
		aucVO.setSHORT_CONT(params.get("SHORT_CONT"));
		aucVO.setSTART_DTIME(DateUtil.converToDate(params.get("START_DTIME")));
		aucVO.setEND_DTIME(DateUtil.converToDate(params.get("END_DTIME")));
		aucVO.setSTART_PRICE(Integer.parseInt(params.get("START_PRICE")));
		aucVO.setQTY(Integer.parseInt(params.get("QTY")));
		aucVO.setMEMB_NUM(loginUser.getMEMB_NUM());
		aucVO.setAUC_TYPE_NUM(params.get("AUC_TYPE_NUM"));
		aucVO.setPROD_CATE_NUM(params.get("PROD_CATE_NUM"));
		
		return aucVO;
	}
	
	private List<RegAucFileVO> makeFileVO(Map<String, FileInfo> fileParams) {
		List<RegAucFileVO> fileList = new ArrayList<RegAucFileVO>();
		
		Set<String> keys = fileParams.keySet();
		
		for(String key : keys) {
			FileInfo temp = fileParams.get(key);
			RegAucFileVO usrFile = new RegAucFileVO();
			usrFile.setREAL_NM(temp.getREAL_NM());
			usrFile.setFILE_NM(temp.getFILE_NM());
			usrFile.setFILE_SIZE(temp.getFILE_SIZE());
			usrFile.setFILE_PATH(temp.getFILE_PATH());
			fileList.add(usrFile);
		}
		return fileList;
	}
}
