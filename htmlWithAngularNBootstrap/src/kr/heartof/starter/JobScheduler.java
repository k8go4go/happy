package kr.heartof.starter;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import kr.heartof.starter.batch.SimpleJob;

public class JobScheduler implements ServletContextListener {
	private SchedulerFactory sf = null;
	private Scheduler sched = null; 
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		try {
			sched.shutdown(true);
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		sf = new StdSchedulerFactory();
		try {
			Scheduler sched = sf.getScheduler();
			JobDetail job = newJob(SimpleJob.class).withIdentity("J_UpdatingAuction", "G_FinishAuction").build();
			Trigger trigger = newTrigger()
				      .withIdentity("T_goUpdatingAuction", "G_FinishAuction")
				      .startNow()
				      .withSchedule(SimpleScheduleBuilder.simpleSchedule()
				          .withIntervalInSeconds(60)
				          .repeatForever())
				      .build();


			sched.scheduleJob(job, trigger);
			sched.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
