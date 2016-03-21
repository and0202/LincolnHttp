package com.example.lincolnhttp.core.http.callback;

import org.json.JSONArray;

import com.example.lincolnhttp.core.http.util.LogUtil;
/**
 * 返回结果：JSONArray
 * @author lincoln
 *
 * @param <JSONArray>
 */
public abstract class JsonArrayCallback<JSONArray> implements LincolnCallBack<JSONArray>{

	@Override
	public void onStart() {
		LogUtil.d("jsonarray onStart");
	}

	@Override
	public void onFinish() {
		LogUtil.d("jsonarray  onFinish");
	}
	
	@Override
	public void onProgerss(int precent) {
	}

}
