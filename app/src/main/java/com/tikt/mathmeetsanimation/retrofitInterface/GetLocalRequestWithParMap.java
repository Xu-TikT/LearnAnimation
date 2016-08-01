package com.tikt.mathmeetsanimation.retrofitInterface;

import com.tikt.mathmeetsanimation.entity.Repo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by tikt on 16-7-29.
 */
public interface GetLocalRequestWithParMap {

	//在函数参数中带上参数,使用Map提交复杂的参数
	@GET("webservlet/ServletTwo")
	Call<Repo> listRepos(@QueryMap Map<String,String> options);
}
