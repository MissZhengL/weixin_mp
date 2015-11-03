package cn.hofan.provider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.hofan.application.SendallByGroupJobHandler;

public class JobMapping {

	public List<IJobTimeHandler> Map(Date d) {

		List<IJobTimeHandler> allJobs = new ArrayList<IJobTimeHandler>();
		allJobs.add(new SendallByGroupJobHandler());

		List<IJobTimeHandler> runJobs = new ArrayList<IJobTimeHandler>();
		// 加载当前时间可执行的左右
		for (IJobTimeHandler p : allJobs) {
			if (p.CanRun(d))
				runJobs.add(p);
		}
		return runJobs;
	}
}
