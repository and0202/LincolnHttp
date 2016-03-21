package com.example.lincolnhttp.core.http.callback;

import com.example.lincolnhttp.core.http.bean.HttpResult;
/**
 * 返回结果抽象类
 * @author lincoln
 *
 * @param <T>
 */
public interface LincolnCallBack<T> {
	void onStart();
	void onSuccess(HttpResult result,T t);
	void onFailed(String msg);
	void onProgerss(int precent);
	void onFinish();
}
