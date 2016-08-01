package com.tikt.mathmeetsanimation.retrofitInterface;

import com.tikt.mathmeetsanimation.entity.Repo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by tikt on 16-7-29.
 */
public interface GetLocalRequestWithoutPar2 {

	//使用@Path，在函数参数中设置url,参数名要一样
	@GET("webservlet/{servlet}")
	Call<Repo> listRepos(@Path("servlet") String servlet);
}
