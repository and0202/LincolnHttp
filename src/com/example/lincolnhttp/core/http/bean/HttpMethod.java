package com.example.lincolnhttp.core.http.bean;
/**
 * 网络请求方法封装
 * @author lincoln
 *
 */
public enum HttpMethod {
	GET("GET"),
	POST("POST");
	private final String value;
	
	 HttpMethod(String value){
		this.value = value;
	}
}
