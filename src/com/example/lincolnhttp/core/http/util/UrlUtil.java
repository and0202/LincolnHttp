package com.example.lincolnhttp.core.http.util;

import java.util.Map;

import com.example.lincolnhttp.core.http.bean.RequestParams;

public class UrlUtil {
	/**
	 * 处理Get请求参数
	 * @param root
	 * @param params
	 * @return
	 */
	public static String dealGetParams(String root,RequestParams params) {
		root = root+"?";
		Map<String, String> map = RequestParams.getMapString();
		for (Map.Entry<String, String> entry:map.entrySet()) {
			root = root.concat(entry.getKey()+"="+entry.getValue()+"&");
		}
		return root;
	}
}
