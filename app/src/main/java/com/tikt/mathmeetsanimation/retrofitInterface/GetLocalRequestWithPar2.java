package com.tikt.mathmeetsanimation.retrofitInterface;

import com.tikt.mathmeetsanimation.entity.Repo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by tikt on 16-7-29.
 */
public interface GetLocalRequestWithPar2 {


	//在函数参数中带上参数
	@GET("webservlet/ServletTest")
	Call<Repo> listRepos(@Query("par") String par);
}
