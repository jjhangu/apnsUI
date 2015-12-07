package com.apns.ui.log;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.apns.ui.callback.LogCallback;

public class UILogger {
	
	public static UILogger uiLogger = new UILogger();
	public LogCallback logCallBack; 
	
	
	/**
	 * @return the logCallBack
	 */
	public LogCallback getLogCallBack() {
		return logCallBack;
	}

	/**
	 * @param logCallBack the logCallBack to set
	 */
	public void setLogCallBack(LogCallback logCallBack) {
		this.logCallBack = logCallBack;
	}

	public Queue<String> queue  = new LinkedBlockingQueue<String>();
	
		
	
	public static UILogger getInstance()
	{
		return uiLogger;
	}
	
	public void add(String str ){
		System.out.println(str);
		
		if(logCallBack!= null){
			logCallBack.printLog(str);
		}
		queue.add(str);
	}
	
	public Queue<String>  getQueue(){
		return queue;
	}
}
