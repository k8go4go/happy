package kr.heartof.test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.heartof.service.mapper.AuctionMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.vo.auction.BiddingVO;
import kr.heartof.vo.auction.RegAucVO;
import kr.heartof.vo.auction.RegBiddingVO;

public class CreateBiddingEnter {
	public static void main(String[] args) {
		SqlSession session = BringSqlSession.getSqlSessionInstance();
		AuctionMapper mapper = session.getMapper(AuctionMapper.class);
		
		List<RegAucVO> list = mapper.allProgressing();
		
		int count = 1;
		for (RegAucVO v : list) {
			List<RegBiddingVO> biddings = mapper.biddingRegList(v.getAUC_REG_NUM());
			
			Calendar c = Calendar.getInstance(); 
			
			for(RegBiddingVO uv : biddings) {
				c.setTime(v.getSTART_DTIME()); 
				c.add(Calendar.DATE, 1);
				Date dt = c.getTime();
				
				BiddingVO rbv = new BiddingVO();
				rbv.setBID_NUM(uv.getBID_NUM());
				rbv.setBID_PRICE(v.getSTART_PRICE() + (1000 * count++));
				rbv.setBID_DTIME(dt);
				mapper.newbiddingHistory(rbv);
			}
			session.commit();
			count = 1;
		}
		session.close();
	}
}
