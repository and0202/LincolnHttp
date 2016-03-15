package com.example.lincolnhttp.core.http.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 参数实体类
 * @author lincoln
 *
 */
public class RequestParams implements Serializable {
	private static Map<String, String> mapString = new HashMap<String, String>();
	public static void name(String key ,String value) {
		mapString.put(key, value);
	}
	public static String get(String key ){
		return mapString.get(key);
	}
}
