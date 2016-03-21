package com.example.lincolnhttp.core.http.util;

public class GlobalUtil {
	private static final boolean ISONLINE= false;
	private static final String ROOTURL_ONLINE= "http://123.57.68.198:9001/http/";
	private static final String ROOTURL_TEST= "http://192.168.6.110:9001/http/";
	public static  String ROOTURL= "";
	
	static{
		if (ISONLINE) {
			ROOTURL = ROOTURL_ONLINE;
		}else {
			ROOTURL = ROOTURL_TEST;
		}
	}

}
