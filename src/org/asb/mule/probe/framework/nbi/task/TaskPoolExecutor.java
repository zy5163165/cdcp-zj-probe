package org.asb.mule.probe.framework.nbi.task;

import com.alcatelsbell.nms.valueobject.BObject;
import org.apache.log4j.Logger;
import org.asb.mule.probe.framework.entity.C_TASK;
import org.asb.mule.probe.framework.util.ProbeLog;

import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: Ronnie.Chen
 * Date: 13-6-18
 * Time: 上午9:01
 * rongrong.chen@alcatel-sbell.com.cn
 */
public class TaskPoolExecutor {
	private int poolSize = 10;
	private ThreadPoolExecutor executor = null;

	// private Logger logger = ProbeLog.getInstance().getDataLog();
	public TaskPoolExecutor(int poolSize) {
		this.poolSize = poolSize;
		executor = new ThreadPoolExecutor(poolSize, poolSize, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
	}

	public ThreadPoolExecutor getExecutor() {
		return executor;
	}

	public void setExecutor(ThreadPoolExecutor executor) {
		this.executor = executor;
	}

	public int getPoolSize() {
		return poolSize;
	}

	public void setPoolSize(int poolSize) {
		this.poolSize = poolSize;
	}

	private AtomicInteger count = new AtomicInteger(0);

	private ReentrantLock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private volatile boolean waiting = false;

	public void waitingForAllFinish() {
		if (count.get() == 0)
			return;
		waiting = true;
		lock.lock();
		try {
			condition.await();
		} catch (Exception e) {

		} finally {
			lock.unlock();
		}

	}

	private ConcurrentHashMap<DataTask, TaskResultHandler> map = new ConcurrentHashMap();

	public void executeTask(DataTask dataTask, TaskResultHandler handler) {
		count.incrementAndGet();
		if (handler != null)
			map.put(dataTask, handler);
		TaskRunnable thread = new TaskRunnable(dataTask, this);
		executor.execute(thread);
	}

	public void executeTask(DataTask dataTask) {
		executeTask(dataTask, null);
	}

	public void threadFinish(TaskRunnable runnable) {
		count.decrementAndGet();
		DataTask task = runnable.getTask();
		Object returnObject = runnable.getReturnObject();
		TaskResultHandler handler = map.get(task);
		if (handler != null) {
			try {
				handler.handleResult(task, returnObject);
			} catch (Exception e) {
				// logger.error(e,e);
				e.printStackTrace();
			}
		}
		if (count.get() == 0 && waiting) {
			lock.lock();
			try {
				condition.signal();
			} catch (Exception e) {

			} finally {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		TaskPoolExecutor executor1 = new TaskPoolExecutor(5);
		for (int i = 0; i < 15; i++) {
			executor1.executeTask(new DataTask() {
				@Override
				public Vector<BObject> excute() {
					try {
						Thread.sleep(1000l);
						return new Vector<BObject>();
					} catch (InterruptedException e) {

					}
					return null;
				}

				@Override
				public void insertDate(Vector<BObject> dataList) {

				}

				@Override
				public void updateDate(Vector<BObject> dataList) {

				}

				@Override
				public void deleteDate(Vector<BObject> dataList) {

				}

				@Override
				public void saveTask(C_TASK task) {

				}
			}, new TaskResultHandler() {
				@Override
				public void handleResult(DataTask task, Object result) throws Exception {
					System.out.println("result = " + result);
				}
			});

		}

		executor1.waitingForAllFinish();
        Thread.sleep(1000l);
		System.out.println("All ...finished");
	}

}
