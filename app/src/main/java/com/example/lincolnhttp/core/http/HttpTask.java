package com.example.lincolnhttp.core.http;

import android.os.Environment;

import com.example.lincolnhttp.core.http.bean.HttpMethod;
import com.example.lincolnhttp.core.http.bean.RequestParams;
import com.example.lincolnhttp.core.http.callback.FileDownLoadCallBack;
import com.example.lincolnhttp.core.http.callback.JsonArrayCallback;
import com.example.lincolnhttp.core.http.callback.JsonObjectCallback;
import com.example.lincolnhttp.core.http.callback.LincolnCallBack;
import com.example.lincolnhttp.core.http.callback.StringCallBack;
import com.example.lincolnhttp.core.http.util.LogUtil;
import com.example.lincolnhttp.core.http.util.StringUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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
	
	public void sendRequest() throws FileNotFoundException{
		String resultString = "",fileSaveName=params.getFileSaveName();
		String filePath = Environment.getExternalStorageDirectory().toString();
		if (StringUtil.isUseable(fileSaveName)){
			filePath = filePath.concat("/test/").concat(fileSaveName);
		}else{
			filePath = filePath.concat("/test/").concat(""+System.currentTimeMillis());
		}
		File file = new File(filePath);
		if(file.exists()){
			file.delete();
		}
		FileOutputStream outputStream = new FileOutputStream(file);
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
//			ByteArrayOutputStream byteOutSteam = new ByteArrayOutputStream();
			byte[] buffer = new byte[512];
			long contentLength = urlConnection.getContentLength();
			int length = 0,count = 0;
//			while ((length = inputStream.read(buffer)) != -1 && !(callBack instanceof FileDownLoadCallBack<?>)) {
//				resultString = outputStream.toString();
//			}
			//响应码>=300,即为失败

			if (urlConnection.getResponseCode() >= 300 && !(callBack instanceof FileDownLoadCallBack<?>)) {
				String msg = urlConnection.getResponseMessage();
				callBack.onFailed(msg);
				return;
			} 
			Object object = null;
			if (callBack instanceof JsonObjectCallback<?>) {
				object = new JSONObject(resultString);
			}else if(callBack instanceof JsonArrayCallback<?>){
				object = new JSONArray(resultString);
			}else if(callBack instanceof StringCallBack<?>){
				object = resultString;
			}else if(callBack instanceof FileDownLoadCallBack<?>){
				LogUtil.d("filecallback");
				int currentPrecent = 0;
				while ((length = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, length);

					count =count+ length;

					int percent = (int) (count*100/contentLength);
					if (percent == currentPrecent){

					}else{
						currentPrecent = percent;
						LogUtil.d("percent:"+percent);
						LogUtil.d("total:"+contentLength+"  count:"+count +" length:"+length);
					}


					callBack.onProgerss(percent);
				}

			}
			inputStream.close();
			outputStream.close();
			callBack.onSuccess(null, object);
		} catch (Exception e) {
			e.printStackTrace();
			callBack.onFailed("请求异常");
		}finally{
			try {
//				inputStream.close();
				outputStream.flush();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			callBack.onFinish();
		}
	
	}

	@Override
	public void run() {
		callBack.onStart();
		try {
			sendRequest();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 网络请求状态
	 */
	public enum State{
		IDLE(0),WAITING(1),STARTED(2),SUCCESS(3),CANCLED(4),ERROR(5);
		private final int value ;
		private State(int value ){
			this.value = value;
		}
		
		public int value(){
			return value;
		}
	}
	
}
