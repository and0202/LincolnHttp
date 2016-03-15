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
	public static void get(String rootUrl, RequestParams params,LincolnCallBack<JSONObject> callBack) {
		try {
			rootUrl = UrlUtil.dealGetParams(rootUrl, params);
			LogUtil.d("url:"+rootUrl);
			URL url = new URL(rootUrl);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod(HttpMethod.GET.toString());
			urlConnection.connect();
			InputStream inputStream = urlConnection.getInputStream();

			ByteArrayOutputStream byteOutSteam = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int length = -1;
			while ((length = inputStream.read(buffer)) != -1) {
				byteOutSteam.write(buffer,0,length);
			}
			
			String resultString = byteOutSteam.toString();
			JSONObject object = new JSONObject(resultString);
			callBack.onSuccess(null, object);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
