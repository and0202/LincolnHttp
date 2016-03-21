package com.example.lincolnhttp.core.http;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import com.example.lincolnhttp.core.http.bean.HttpMethod;
import com.example.lincolnhttp.core.http.bean.RequestParams;
import com.example.lincolnhttp.core.http.callback.LincolnCallBack;
/**
 * 任务线程类
 * @author lincoln
 *
 */
public class HttpTask implements Runnable{	
	private String rootUrl;
	private LincolnCallBack callBack;
	private HttpMethod method;
	private RequestParams params;
	
	public HttpTask(String rootUrl,HttpMethod method,RequestParams params,LincolnCallBack callback){
		this.rootUrl = rootUrl;
		this.callBack = callback;
		this.params = params;
		this.method = method;
	}
	
	public void sendRequest(){
		try {
			URL url = new URL(rootUrl);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod(method.toString());
			if (method != HttpMethod.GET) {
				urlConnection.setDoOutput(true);
				byte[] bytes = params.toString().getBytes();
				urlConnection.getOutputStream().write(bytes);
			}
			
			urlConnection.connect();
			
			InputStream inputStream = urlConnection.getInputStream();
			ByteArrayOutputStream byteOutSteam = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int length = -1;
			while ((length = inputStream.read(buffer)) != -1) {
				byteOutSteam.write(buffer, 0, length);
			}
			String resultString = byteOutSteam.toString();
			JSONObject object = new JSONObject(resultString);
			//响应码>=300,即为失败
			if (urlConnection.getResponseCode() >= 300) {
				String msg = urlConnection.getResponseMessage();
				callBack.onFailed(msg);
			}else {
				callBack.onSuccess(null, object);
			}
		} catch (Exception e) {
			e.printStackTrace();
			callBack.onFailed("请求异常");
		}
	
	}

	@Override
	public void run() {
		sendRequest();
	}
	
}
