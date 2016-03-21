package com.example.lincolnhttp.core.http;

import org.json.JSONObject;

import com.example.lincolnhttp.core.http.bean.HttpMethod;
import com.example.lincolnhttp.core.http.bean.RequestParams;
import com.example.lincolnhttp.core.http.callback.LincolnCallBack;
import com.example.lincolnhttp.core.http.util.GlobalUtil;
import com.example.lincolnhttp.core.http.util.UrlUtil;

/**
 * 网络请求入口
 * 
 * @author lincoln
 * 
 */
public class HttpUtil {
	/**
	 * Get请求
	 */
	public static void get(String rootPath, RequestParams params, final LincolnCallBack<?> callBack) {
		String rootUrl = GlobalUtil.ROOTURL.concat(rootPath);
		rootUrl = UrlUtil.dealGetParams(rootUrl, params);
		TaskController taskController = TaskController.registrInstance();
		taskController.start(rootUrl, HttpMethod.GET, params, callBack);
	}

	/**
	 * Post请求
	 */
	public static void post(String rootPath, RequestParams params, final LincolnCallBack<JSONObject> callBack) {
		String rootUrl = GlobalUtil.ROOTURL.concat(rootPath);
		TaskController taskController = TaskController.registrInstance();
		taskController.start(rootUrl, HttpMethod.POST, params, callBack);
	}

	/**
	 * Put请求
	 */
	public static void put(String rootPath, RequestParams params, final LincolnCallBack<JSONObject> callBack) {
		String rootUrl = GlobalUtil.ROOTURL.concat(rootPath);
		TaskController taskController = TaskController.registrInstance();
		taskController.start(rootUrl, HttpMethod.PUT, params, callBack);
	}

	/**
	 * Patch请求
	 */
	public static void patch(String rootPath, RequestParams params, final LincolnCallBack<JSONObject> callBack) {
		String rootUrl = GlobalUtil.ROOTURL.concat(rootPath);
		TaskController taskController = TaskController.registrInstance();
		taskController.start(rootUrl, HttpMethod.PATCH, params, callBack);
	}

	/**
	 * Delete请求
	 */
	public static void delete(String rootPath, RequestParams params, final LincolnCallBack<JSONObject> callBack) {
		String rootUrl = GlobalUtil.ROOTURL.concat(rootPath);
		TaskController taskController = TaskController.registrInstance();
		taskController.start(rootUrl, HttpMethod.DELETE, params, callBack);
	}
	/**
	 * Download Get请求
	 */
	public static void getDownload(String rootUrl, RequestParams params, final LincolnCallBack<?> callBack) {
		TaskController taskController = TaskController.registrInstance();
		taskController.start(rootUrl, HttpMethod.GET, params, callBack);
	}

	
}
