package com.example.lincolnhttp.core.http.callback;

import org.json.JSONObject;

import com.example.lincolnhttp.core.http.bean.HttpResult;
import com.example.lincolnhttp.core.http.util.LogUtil;
/**
 * 返回结果是：JSONObject
 * @author lincoln
 *
 */
public abstract class JsonObjectCallback<JSONObject> implements LincolnCallBack<JSONObject>{
	@Override
	public void onStart() {
		LogUtil.d("onStart");
	}

	@Override
	public void onFinish() {
		LogUtil.d("onFinish");
	}
	
	@Override
	public void onProgerss(int precent) {
		LogUtil.d("onProgerss");
	}

}
