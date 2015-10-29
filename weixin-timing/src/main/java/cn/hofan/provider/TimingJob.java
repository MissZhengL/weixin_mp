package cn.hofan.provider;

import java.util.Date;
import java.util.List;

import cn.hofan.util.DateUtil;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.StatefulJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TimingJob implements StatefulJob {
	private static Logger logger = LoggerFactory.getLogger(TimingJob.class);

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		logger.info("------开始执行定时器的一次心跳： "
				+ DateUtil.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss")
				+ "------");
		Date dtNow = new Date();
		List<IJobTimeHandler> jobs = new JobMapping().Map(dtNow);
		if (jobs.size() == 0) {
			logger.info("当前时间点无可执行的作业： "
					+ DateUtil.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
			return;
		}

		int iTotal = jobs.size();
		logger.info("当前时间点： "
				+ DateUtil.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss")
				+ "，待执行作业总数:" + iTotal);

		int iRun = 1;
		// 加载所有可执行的作业程序并运行
		for (IJobTimeHandler job : jobs) {
			job.Run();
			logger.info("已执行作业数： " + iRun + ",待执行作业数：" + (iTotal - (iRun++)));
			try {
				logger.info("当前时间点： "
						+ DateUtil.dateToString(new Date(),
								"yyyy-MM-dd HH:mm:ss") + "线程睡了");
				Thread.sleep(1000);
				logger.info("当前时间点： "
						+ DateUtil.dateToString(new Date(),
								"yyyy-MM-dd HH:mm:ss") + "线程醒了");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				logger.error("线程缓冲休眠异常：", e);
			}
		}

		logger.info("------结束执行定时器的此次心跳： "
				+ DateUtil.dateToString(new Date(), "yyyy-MM-dd HH:mm:ss")
				+ "------");
	}
}
