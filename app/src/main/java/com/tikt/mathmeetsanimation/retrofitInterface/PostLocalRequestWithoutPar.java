package com.tikt.mathmeetsanimation.retrofitInterface;

import com.tikt.mathmeetsanimation.entity.Repo;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by tikt on 16-7-29.
 */
public interface PostLocalRequestWithoutPar {

	@POST("webservlet/ServletTwo")
	Call<Repo> listRepos();
}
