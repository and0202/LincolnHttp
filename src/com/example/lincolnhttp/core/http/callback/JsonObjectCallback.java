package com.example.lincolnhttp.core.http.callback;

import org.json.JSONObject;

import com.example.lincolnhttp.core.http.bean.HttpResult;
/**
 * 返回结果是：JSONObject
 * @author lincoln
 *
 */
public abstract class JsonObjectCallback<JSONObject> implements LincolnCallBack<JSONObject>{

	@Override
	public void onSuccess(HttpResult result, JSONObject t) {
		
	}


}
