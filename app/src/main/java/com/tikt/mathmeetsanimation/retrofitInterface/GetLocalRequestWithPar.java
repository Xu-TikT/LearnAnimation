package com.tikt.mathmeetsanimation.retrofitInterface;

import com.tikt.mathmeetsanimation.entity.Repo;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by tikt on 16-7-29.
 */
public interface GetLocalRequestWithPar {


	//在url中带上参数
	@GET("webservlet/ServletTest?par=hello")
	Call<Repo> listRepos();
}
