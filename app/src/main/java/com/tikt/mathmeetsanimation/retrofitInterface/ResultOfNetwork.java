package com.tikt.mathmeetsanimation.retrofitInterface;

import retrofit2.Response;

/**
 * Created by tikt on 16-8-1.
 * 网络请求的结果
 */
public interface ResultOfNetwork<T> {

	 void onSuccess(Response<T> result);
	 void onFailure(Response<T> result);
}
