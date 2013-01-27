/**
 * FutureTaskTest.java 上午9:39:05 2012-12-20
 *
 * Copyright(c) 2000-2012 HC360.COM, All Rights Reserved.
 */
package org.dxx.async;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * <p>
 * </p>
 * 
 * @author dixingxing
 * @date 2012-12-20
 */
public class AsyncTemplateTest {
	private AsyncTemplate template = new AsyncTemplate();
	
	private SomeService someService = new SomeService();
	
	@Test
	public void test() {
		long start = System.currentTimeMillis();
		
		AsyncHolder<String> holder1 = template.exec(new AsyncCallback<String>() {
			public String execute() {
				// sleep 1000 ms 异步执行不阻塞主线程
				return someService.getFromRemoteApp(1000L);
			}
		});
		
		AsyncHolder<String> holder2 = template.exec(new AsyncCallback<String>() {
			public String execute() {
				// sleep 1000 ms 异步执行不阻塞主线程
				return someService.getFromDatabase(1000L);
			}
		});
		
		AsyncHolder<String> holder3 = template.exec(new AsyncCallback<String>() {
			public String execute() {
				// sleep 1000 ms 异步执行不阻塞主线程
				return someService.getFromDatabase(1000L);
			}
		});
		
		// sleep 1000 ms 在主线程中执行
		someService.getFromRemoteApp(1000L);
		
		
		assertEquals("this is from remote app", holder1.getResult());
		assertEquals("this is from database", holder2.getResult());
		assertEquals("this is from database", holder3.getResult());
		
		
		long totalCost = System.currentTimeMillis()  - start;

		System.out.println("total cost : " + totalCost);
		
		// 总执行时间一定大于1000ms
		assertTrue(999 < totalCost);
		
		// 并发执行后，总时间一定小于4000ms
		assertTrue(totalCost < 4000);
		
		// 本例并发执行后，总时间应该明显小于4000ms
		assertTrue(totalCost < 1500);
		
		AsyncTemplate.printStatus();
	}

}
