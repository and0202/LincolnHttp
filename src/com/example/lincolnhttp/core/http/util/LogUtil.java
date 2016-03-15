package com.example.lincolnhttp.core.http.util;

import android.util.Log;
/**
 * log输出工具类
 * @author lincoln
 *
 */
public class LogUtil {
	private static boolean DEBUG = true;
	private static  String tag="lincoln";
	
	public static void d(String content){
		if (DEBUG) {
			Log.d(tag, content);
		}
	};

}
