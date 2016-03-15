package com.example.lincolnhttp.core.http;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import com.example.lincolnhttp.core.http.bean.RequestParams;
import com.example.lincolnhttp.core.http.util.LogUtil;

/**
 * 网络请求类入口
 * 
 * @author lincoln
 * 
 */
public class HttpUtil {
	public static void get(String rootUrl, String method, RequestParams params) {
		try {
			URL url = new URL(rootUrl);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod(method);
			urlConnection.connect();
			InputStream inputStream = urlConnection.getInputStream();

			ByteArrayOutputStream byteOutSteam = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int length = -1;
			while ((length = inputStream.read(buffer)) != -1) {
				byteOutSteam.write(buffer,0,length);
			}
			
			String resultString = byteOutSteam.toString();
			LogUtil.d(resultString);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
