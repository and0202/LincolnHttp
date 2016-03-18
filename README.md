# LincolnHttp
从零开始做http框架:

#使用方法：
  Get请求：
      RequestParams params = new RequestParams();
			params.put("name", "get");
			HttpUtil.get("get", params, new JsonObjectCallback<JSONObject>() {
				@Override
				public void onSuccess(HttpResult result, JSONObject t) {
					LogUtil.d("onSuccess" + t.toString());
				
				}

				@Override
				public void onFailed(String msg) {
					LogUtil.d("onSuccess" + t.toString());
				}
			});

