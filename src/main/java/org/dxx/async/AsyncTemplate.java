/**
 * AsyncTemplate.java 上午9:01:27 2012-12-21
 *
 * Copyright(c) 2000-2012 HC360.COM, All Rights Reserved.
 */
package org.dxx.async;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <p>
 * 一个模板类，实现本地多线程并行计算，缩短程序的相应时间。
 * </p>
 * <li><font color="green">仅建议io密集型</font>的程序使用本地多线程并行计算的机制。</li> <li>
 * 因为目前多数框架的事务都是单线程的，所以需要保证在同一事务中执行的操作，<font color="red">不应使用本类。</font></li>
 * 
 * @see AsyncExecutor
 * @see AsyncHolder
 * 
 * @author dixingxing
 * @date 2012-12-21
 */
public class AsyncTemplate {

	private static final ExecutorService es = Executors.newCachedThreadPool();

	/**
	 * 
	 * <p>
	 * 将callback对象提交到线程池中执行。
	 * </p>
	 * 
	 * @param callback
	 * @return
	 */
	public <V> AsyncHolder<V> exec(final AsyncCallback<V> callback) {
		Future<V> future = es.submit(new Callable<V>() {
			public V call() throws Exception {
				return callback.execute();
			}
		});

		return new AsyncHolder<V>(future);
	}

	/**
	 * 打印线程池的运行情况
	 * 
	 * @author dixingxing
	 * @version 1.0
	 * @date 2013-1-27 下午12:44:29 void
	 */
	public static void printStatus() {
		System.out.println(buildStatusString());
	}

	private static String buildStatusString() {
		ThreadPoolExecutor exec = (ThreadPoolExecutor) es;
		StringBuilder sb = new StringBuilder(
				"==============Async status begin : ==============\r\n");
		sb.append("taskCount : ").append(exec.getTaskCount()).append("\r\n");
		sb.append("completedTaskCount : ").append(exec.getCompletedTaskCount())
				.append("\r\n");
		sb.append("activeCount : ").append(exec.getActiveCount())
				.append("\r\n");
		sb.append("largestPoolSize : ").append(exec.getLargestPoolSize())
				.append("\r\n");
		sb.append("==============Async status end : ==============");
		return sb.toString();
	}
}
