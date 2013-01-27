/**
 * AsyncCallback.java 上午9:24:47 2012-12-21
 *
 * Copyright(c) 2000-2012 HC360.COM, All Rights Reserved.
 */
package org.dxx.async;


/**
 * <p>并行执行的回调接口</p>
 * 
 * @see AsyncTemplate
 * 
 * @param　V 返回值类型
 * @author dixingxing	
 * @date 2012-12-21
 */
public interface AsyncCallback<V> {
	
	/**
	 * 
	 * <p>定义需要被异步执行的方法</p>
	 *
	 * @return
	 */
	V execute() ;
	
}
