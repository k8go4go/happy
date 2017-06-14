package kr.heartof.starter.batch;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import kr.heartof.admin.mapper.BatchAuctionMapper;
import kr.heartof.admin.vo.BatchRegAucVO;
import kr.heartof.util.BringSqlSession;

public class SimpleJob implements Job{
	public void execute(JobExecutionContext context)
	        throws JobExecutionException {
		System.out.println("==================Batch 시작");
		SqlSession sqlSession = BringSqlSession.getSqlSessionInstance();
		BatchAuctionMapper mapper = sqlSession.getMapper(BatchAuctionMapper.class);
		try {
			mapper.updateBatch2301();
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
		
		try {
			mapper.updateBatch2304();
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
		
		try {
			mapper.updateBatch2302();
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
		
		try {
			mapper.updateBatch2303();
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
		
		try {
			mapper.updateBatch2305();
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
		
		try {
			List<BatchRegAucVO> list = mapper.resultBidding();
			for(BatchRegAucVO vo : list) {
				if(vo.getBID_PRICE() > 0) {
					mapper.newSbidding(vo);
				} else {
					mapper.updateBatch2306(vo.getAUC_REG_NUM());
				}
			}
			sqlSession.commit();
		} catch(Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		}
		
		System.out.println("Batch 종료===================");
	}
}
