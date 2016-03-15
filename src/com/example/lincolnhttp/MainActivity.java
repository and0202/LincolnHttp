package com.example.lincolnhttp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.lincolnhttp.core.http.HttpUtil;

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
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					HttpUtil.get(root, "GET", null);
				}
			}).start();
			break;
		}
	}


}
