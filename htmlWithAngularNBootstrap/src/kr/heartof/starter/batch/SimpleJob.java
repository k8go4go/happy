package kr.heartof.starter.batch;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SimpleJob implements Job{
	public void execute(JobExecutionContext context)
	        throws JobExecutionException {
		// 경매가 시간이 오버된 것들을 Update하는 로직을 넣는다.
		System.out.println("Batch 처리 중");
	}
}
