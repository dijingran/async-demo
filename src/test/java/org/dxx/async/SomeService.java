/**
 * SomeService.java 上午10:39:01 2012-12-21
 *
 * Copyright(c) 2000-2012 HC360.COM, All Rights Reserved.
 */
package org.dxx.async;

/**
 * <p>
 * </p>
 * 
 * @author dixingxing
 * @date 2012-12-21
 */
public class SomeService {
	public String getFromRemoteApp(long sleepTime) {
		try {
			Thread.sleep(sleepTime);
			return "this is from remote app";
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public String getFromDatabase(long sleepTime) {
		try {
			Thread.sleep(sleepTime);
			return "this is from database";
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void notifyRemoteApp(long sleepTime) {
		try {
			Thread.sleep(sleepTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
