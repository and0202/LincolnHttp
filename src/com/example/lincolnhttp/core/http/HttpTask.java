package com.example.lincolnhttp.core.http;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

import com.example.lincolnhttp.core.http.bean.HttpMethod;
import com.example.lincolnhttp.core.http.callback.LincolnCallBack;

public class HttpTask implements Runnable{	
	private String rootUrl;
	private LincolnCallBack callBack;
	
	public HttpTask(String rootUrl,HttpMethod method,LincolnCallBack callback){
		this.rootUrl = rootUrl;
		this.callBack = callback;
	}
	
	public void sendRequest(){
		try {
			URL url = new URL(rootUrl);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod(HttpMethod.GET.toString());
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
			callBack.onSuccess(null, object);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	@Override
	public void run() {
		sendRequest();
	}
	
}
