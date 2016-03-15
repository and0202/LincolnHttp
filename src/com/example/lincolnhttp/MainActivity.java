package com.example.lincolnhttp;

import java.util.logging.Logger;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.lincolnhttp.core.http.HttpUtil;
import com.example.lincolnhttp.core.http.bean.RequestParams;
import com.example.lincolnhttp.core.http.util.LogUtil;

public class MainActivity extends Activity implements OnClickListener {
	String root = "http://gc.ditu.aliyun.com/regeocoding?l=39.938133,116.395739&type=001";
	 Handler handler = new Handler(new Callback() {
		
		@Override
		public boolean handleMessage(Message msg) {
			LogUtil.d(msg.what+" - "+msg.obj);
			return false;
		}
	});
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
	}

	private void initViews() {
		findViewById(R.id.btn_get).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_get:
			final RequestParams params = new RequestParams();
			params.put("name", "lincoln");
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					HttpUtil.get(root, params,handler);
				}
			}).start();
			break;
		}
	}


}
