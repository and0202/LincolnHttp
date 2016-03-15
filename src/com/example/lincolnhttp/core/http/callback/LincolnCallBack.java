package com.example.lincolnhttp.core.http.callback;

import com.example.lincolnhttp.core.http.bean.HttpResult;

public interface LincolnCallBack<T> {
	void onSuccess(HttpResult result,T t);
}
