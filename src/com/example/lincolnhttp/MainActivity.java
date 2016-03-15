package com.example.lincolnhttp;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.lincolnhttp.core.http.HttpUtil;
import com.example.lincolnhttp.core.http.bean.HttpResult;
import com.example.lincolnhttp.core.http.bean.RequestParams;
import com.example.lincolnhttp.core.http.callback.JsonObjectCallback;
import com.example.lincolnhttp.core.http.util.LogUtil;
import com.example.lincolnhttp.core.http.util.ToastUtil;

public class MainActivity extends Activity implements OnClickListener {
	String root = "http://gc.ditu.aliyun.com/regeocoding?l=39.938133,116.395739&type=001";
	
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
					Looper.prepare();
					HttpUtil.get(root, params,new JsonObjectCallback<JSONObject>() {
						@Override
						public void onSuccess(HttpResult result, JSONObject t) {
							LogUtil.d("onSuccess"+t.toString());
						}

						@Override
						public void onFailed() {
						}
					});
				}
			}).start();
			break;
		}
	}


}
