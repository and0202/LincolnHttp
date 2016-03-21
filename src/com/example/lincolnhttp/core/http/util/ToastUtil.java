package com.example.lincolnhttp.core.http.util;

import android.content.Context;
import android.widget.Toast;
/**
 * Toast工具类
 * @author lincoln
 *
 */
public class ToastUtil {
	
	public static void showLong(Context context ,String content){
		Toast.makeText(context, content, Toast.LENGTH_LONG).show();
	}
	
	public static void showShort(Context context ,String content){
		Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
	}

}
