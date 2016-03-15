package com.example.lincolnhttp.core.http.bean;

public enum HttpMethod {
	GET("GET"),
	POST("POST");
	private final String value;
	
	 HttpMethod(String value){
		this.value = value;
	}
}
