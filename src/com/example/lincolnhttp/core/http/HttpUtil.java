package com.example.lincolnhttp.core.http;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import android.os.Handler;
import android.os.Message;

import com.example.lincolnhttp.core.http.bean.HttpMethod;
import com.example.lincolnhttp.core.http.bean.RequestParams;
import com.example.lincolnhttp.core.http.callback.LincolnCallBack;
import com.example.lincolnhttp.core.http.util.LogUtil;
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
	public static void get(String rootUrl, RequestParams params, final LincolnCallBack<JSONObject> callBack) {
		rootUrl = UrlUtil.dealGetParams(rootUrl, params);
		TaskController taskController = TaskController.registrInstance();
		taskController.start(rootUrl, HttpMethod.GET, params, callBack);
	}

	/**
	 * Post请求
	 */
	public static void post(String rootUrl, RequestParams params, final LincolnCallBack<JSONObject> callBack) {
		TaskController taskController = TaskController.registrInstance();
		taskController.start(rootUrl, HttpMethod.POST, params, callBack);
	}

	/**
	 * Put请求
	 */
	public static void put(String rootUrl, RequestParams params, final LincolnCallBack<JSONObject> callBack) {
		TaskController taskController = TaskController.registrInstance();
		taskController.start(rootUrl, HttpMethod.PUT, params, callBack);
	}

	/**
	 * Patch请求
	 */
	public static void patch(String rootUrl, RequestParams params, final LincolnCallBack<JSONObject> callBack) {
		TaskController taskController = TaskController.registrInstance();
		taskController.start(rootUrl, HttpMethod.PATCH, params, callBack);
	}

	/**
	 * Delete请求
	 */
	public static void delete(String rootUrl, RequestParams params, final LincolnCallBack<JSONObject> callBack) {
		TaskController taskController = TaskController.registrInstance();
		taskController.start(rootUrl, HttpMethod.DELETE, params, callBack);
	}
}
