package cn.hofan.provider;

import java.util.Date;


public interface  IJobTimeHandler {
	public abstract boolean CanRun(Date d);

	public abstract String Run();
}
