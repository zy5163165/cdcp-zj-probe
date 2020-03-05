package org.asb.mule.probe.framework.nbi.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * Author: Ronnie.Chen
 * Date: 13-6-18
 * Time: 上午9:06
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class TaskRunnable implements Runnable {
	private DataTask task = null;
	private TaskPoolExecutor taskPoolExecutor = null;
	private Object returnObject = null;
	private Log logger = LogFactory.getLog(getClass());

	public TaskRunnable(DataTask task, TaskPoolExecutor taskPoolExecutor) {
		this.task = task;
		this.taskPoolExecutor = taskPoolExecutor;
	}

	public TaskPoolExecutor getTaskPoolExecutor() {
		return taskPoolExecutor;
	}

	public void setTaskPoolExecutor(TaskPoolExecutor taskPoolExecutor) {
		this.taskPoolExecutor = taskPoolExecutor;
	}

	public DataTask getTask() {
		return task;
	}

	public void setTask(DataTask task) {
		this.task = task;
	}

	public Object getReturnObject() {
		return returnObject;
	}

	public void setReturnObject(Object returnObject) {
		this.returnObject = returnObject;
	}

	@Override
	public void run() {
		if (task != null) {
			try {
				System.out.println(Thread.currentThread().getName() + " start...." + task.getClass().getName());
				returnObject = task.excute();
			} catch (Throwable e) {
				logger.error("Failed execute task : " + task);
				logger.error(e, e);
				e.printStackTrace();
			} finally {
				taskPoolExecutor.threadFinish(this);
			}
			System.out.println(Thread.currentThread().getName() + " end...." + task.getClass().getName());
		}
	}
}
