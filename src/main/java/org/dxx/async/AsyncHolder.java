/**
 * AsyncResult.java 上午9:03:22 2012-12-21
 *
 * Copyright(c) 2000-2012 HC360.COM, All Rights Reserved.
 */
package org.dxx.async;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


/**
 * <p>持有 {@link #future} 对象的引用</p>
 * 
 * @author dixingxing	
 * @date 2012-12-21
 */
public class AsyncHolder<V> {
	
	private V result;
	
	private Future<V> future;
	
	public AsyncHolder (Future<V> future) {
		if(future == null) {
			throw new IllegalArgumentException("future can not be null ,sth. must be wrong!");
		}
		this.future = future;
	}

	/**
	 * 
	 * <p>获取　 {@link AsyncCallback#execute()}　 的返回值</p>
	 * 
	 * @return result
	 * @see Future#get()
	 */
	public V getResult() {
		if(result == null) {
			try {
				result = future.get();
			} catch (InterruptedException e) {
				// TODO 监控
				throw new AsyncException(e);
			} catch (ExecutionException e) {
				// TODO 监控
				throw new AsyncException(e);
			}
		}
		return result;
	}


	/**
	 *
	 * 
	 * <p>获得 {@link Future} 对象。</p>
	 *
	 * @return
	 */
	public Future<V> getFuture() {
		return future;
	}

	//=====================default scope============================
	
	void setResult(V result) {
		this.result = result;
	}
	
	void setFuture(Future<V> future) {
		this.future = future;
	}
	
}
