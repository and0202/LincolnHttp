package com.example.lincolnhttp.core.http;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONObject;

import com.example.lincolnhttp.core.http.bean.HttpMethod;
import com.example.lincolnhttp.core.http.bean.RequestParams;
import com.example.lincolnhttp.core.http.callback.LincolnCallBack;
/**
 * 线程控制类
 * @author lincoln
 *
 */
public class TaskController {
	private static TaskController taskController;
	private static ExecutorService executor;
	private static int MAX_THREAD_COUNT= 10;

	public static TaskController registrInstance(){
		if (taskController == null) {
			synchronized (TaskController.class) {
				if (taskController == null) {
					taskController = new TaskController();
					executor = Executors.newFixedThreadPool(MAX_THREAD_COUNT);
				}
			}
		}
		return taskController;
	}
	
	
	public <T> void  start(String rootUrl,HttpMethod method ,RequestParams params,LincolnCallBack<JSONObject> callback){
		HttpTask task = new HttpTask(rootUrl,method, callback);
		executor.submit(task);
	}
	
}
