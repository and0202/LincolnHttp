package com.example.lincolnhttp;

import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.lincolnhttp.core.http.HttpUtil;
import com.example.lincolnhttp.core.http.bean.HttpResult;
import com.example.lincolnhttp.core.http.bean.RequestParams;
import com.example.lincolnhttp.core.http.callback.JsonObjectCallback;
import com.example.lincolnhttp.core.http.util.LogUtil;
import com.example.lincolnhttp.core.http.util.ToastUtil;

public class MainActivity extends Activity implements OnClickListener {
	private TextView descView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
	}

	private void initViews() {
		descView = (TextView) findViewById(R.id.desc);
		findViewById(R.id.btn_get).setOnClickListener(this);
		findViewById(R.id.btn_post).setOnClickListener(this);
		findViewById(R.id.btn_put).setOnClickListener(this);
		findViewById(R.id.btn_patch).setOnClickListener(this);
		findViewById(R.id.btn_delete).setOnClickListener(this);
		findViewById(R.id.btn_exception).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		final RequestParams params = new RequestParams();
		switch (v.getId()) {
		case R.id.btn_get:
			params.put("name", "get");
			HttpUtil.get("get", params, new JsonObjectCallback<JSONObject>() {
				@Override
				public void onSuccess(HttpResult result, JSONObject t) {
					LogUtil.d("onSuccess" + t.toString());
					SetTextView(t.toString());
				}

				@Override
				public void onFailed(String msg) {
					SetTextView(msg);
				}

			});

			break;
		case R.id.btn_post:
			params.put("name", "post");
			HttpUtil.post("post", params, new JsonObjectCallback<JSONObject>() {
				@Override
				public void onSuccess(HttpResult result, JSONObject t) {
					LogUtil.d("onSuccess" + t.toString());
					SetTextView(t.toString());
				}

				@Override
				public void onFailed(String msg) {
					SetTextView(msg);
				}

			});

			break;
		case R.id.btn_put:
			params.put("name", "put");
			HttpUtil.put("put", params, new JsonObjectCallback<JSONObject>() {
				@Override
				public void onSuccess(HttpResult result, JSONObject t) {
					LogUtil.d("onSuccess" + t.toString());
					SetTextView(t.toString());
				}

				@Override
				public void onFailed(String msg) {
					SetTextView(msg);
				}

			});

			break;
		case R.id.btn_patch:
			params.put("name", "patch");
			HttpUtil.patch("patch", params, new JsonObjectCallback<JSONObject>() {
				@Override
				public void onSuccess(HttpResult result, JSONObject t) {
					LogUtil.d("onSuccess" + t.toString());
					SetTextView(t.toString());
				}

				@Override
				public void onFailed(String msg) {
					SetTextView(msg);
				}

			});

			break;
		case R.id.btn_delete:
			params.put("name", "delete");
			HttpUtil.delete("delete", params, new JsonObjectCallback<JSONObject>() {
				@Override
				public void onSuccess(HttpResult result, JSONObject t) {
					LogUtil.d("onSuccess" + t.toString());
					SetTextView(t.toString());
				}

				@Override
				public void onFailed(String msg) {
					SetTextView(msg);
				}

			});

			break;
		case R.id.btn_exception:
			params.put("name", "异常");
			HttpUtil.get("get/exception", params, new JsonObjectCallback<JSONObject>() {
				@Override
				public void onSuccess(HttpResult result, JSONObject t) {
					LogUtil.d("onSuccess" + t.toString());
					SetTextView(t.toString());
				}

				@Override
				public void onFailed(String msg) {
					SetTextView(msg);
				}

			});
			break;
		}
	}

	private void SetTextView(final String content) {
		runOnUiThread(new Runnable() {

			@Override
			public void run() {
				descView.setText(content);
			}
		});
	}

}
