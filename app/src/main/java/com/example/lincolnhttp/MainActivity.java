package com.example.lincolnhttp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.lincolnhttp.core.http.HttpUtil;
import com.example.lincolnhttp.core.http.bean.HttpResult;
import com.example.lincolnhttp.core.http.bean.RequestParams;
import com.example.lincolnhttp.core.http.callback.FileDownLoadCallBack;
import com.example.lincolnhttp.core.http.callback.JsonArrayCallback;
import com.example.lincolnhttp.core.http.callback.JsonObjectCallback;
import com.example.lincolnhttp.core.http.util.LogUtil;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;

public class MainActivity extends Activity implements OnClickListener {
	private TextView descView,descArrayTextView;
//	private final String downloadUrl = "http://123.57.68.198/Gallery/css/blueimp-gallery.min.css";
	private final String downloadUrl = "http://123.57.68.198/http_framework/dizhu.apk";
//	private final String downloadUrl = "http://www.dxsbb.com/upFiles/infoImg/2015071183223033.jpg";


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
	}

	private void initViews() {
		descView = (TextView) findViewById(R.id.desc);
		descArrayTextView = (TextView) findViewById(R.id.desc_array);
		findViewById(R.id.btn_get).setOnClickListener(this);
		findViewById(R.id.btn_post).setOnClickListener(this);
		findViewById(R.id.btn_put).setOnClickListener(this);
		findViewById(R.id.btn_patch).setOnClickListener(this);
		findViewById(R.id.btn_delete).setOnClickListener(this);
		findViewById(R.id.btn_exception).setOnClickListener(this);
		
		findViewById(R.id.btn_get_array).setOnClickListener(this);
		findViewById(R.id.btn_get_download).setOnClickListener(this);
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
					SetTextView(false,t.toString());
				}

				@Override
				public void onFailed(String msg) {
					SetTextView(false,msg);
				}
			});

			break;
		case R.id.btn_post:
			params.put("name", "post");
			HttpUtil.post("post", params, new JsonObjectCallback<JSONObject>() {
				@Override
				public void onSuccess(HttpResult result, JSONObject t) {
					LogUtil.d("onSuccess" + t.toString());
					SetTextView(false,t.toString());
				}

				@Override
				public void onFailed(String msg) {
					SetTextView(false,msg);
				}

			});

			break;
		case R.id.btn_put:
			params.put("name", "put");
			HttpUtil.put("put", params, new JsonObjectCallback<JSONObject>() {
				@Override
				public void onSuccess(HttpResult result, JSONObject t) {
					LogUtil.d("onSuccess" + t.toString());
					SetTextView(false,t.toString());
				}

				@Override
				public void onFailed(String msg) {
					SetTextView(false,msg);
				}

			});

			break;
		case R.id.btn_patch:
			params.put("name", "patch");
			HttpUtil.patch("patch", params, new JsonObjectCallback<JSONObject>() {
				@Override
				public void onSuccess(HttpResult result, JSONObject t) {
					LogUtil.d("onSuccess" + t.toString());
					SetTextView(false,t.toString());
				}

				@Override
				public void onFailed(String msg) {
					SetTextView(false,msg);
				}

			});

			break;
		case R.id.btn_delete:
			params.put("name", "delete");
			HttpUtil.delete("delete", params, new JsonObjectCallback<JSONObject>() {
				@Override
				public void onSuccess(HttpResult result, JSONObject t) {
					LogUtil.d("onSuccess" + t.toString());
					SetTextView(false,t.toString());
				}

				@Override
				public void onFailed(String msg) {
					SetTextView(false,msg);
				}

			});

			break;
		case R.id.btn_exception:
			params.put("name", "异常");
			HttpUtil.get("get/exception", params, new JsonObjectCallback<JSONObject>() {
				@Override
				public void onSuccess(HttpResult result, JSONObject t) {
					LogUtil.d("onSuccess" + t.toString());
					SetTextView(false,t.toString());
				}

				@Override
				public void onFailed(String msg) {
					SetTextView(false,msg);
				}

			});
			break;
		case R.id.btn_get_array:
			params.put("name", "get");
			HttpUtil.get("get/array", params, new JsonArrayCallback<JSONArray>() {
				@Override
				public void onSuccess(HttpResult result, JSONArray t) {
					LogUtil.d("onSuccess" + t.toString());
					SetTextView(false,t.toString());
				}

				@Override
				public void onFailed(String msg) {
					SetTextView(false,msg);
				}
			});

			break;
		case R.id.btn_get_download:
			params.setFileSaveName("jizhang.apk");
			HttpUtil.getDownload(downloadUrl, params, new FileDownLoadCallBack<File>() {

				@Override
				public void onStart() {
				}

				@Override
				public void onSuccess(HttpResult result, File t) {
					LogUtil.d("onSuccess");
				}

				@Override
				public void onFailed(String msg) {
					LogUtil.d("onFailed");
				}

				@Override
				public void onProgerss(int precent) {
//					LogUtil.d("onProgerss:"+precent);

					SetTextView(true,"进度："+precent+"%");
				}

				@Override
				public void onFinish() {
					LogUtil.d("onFinish");
				}
			});

			break;
		}
	}

	private void SetTextView(final boolean isArray ,final String content) {
		runOnUiThread(new Runnable() {

			@Override
			public void run() {
				if (isArray) {
					descArrayTextView.setText(content);
				}else{
					descView.setText(content);
				}
			}
		});
	}



}
