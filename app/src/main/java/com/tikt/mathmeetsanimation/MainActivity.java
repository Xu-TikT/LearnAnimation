package com.tikt.mathmeetsanimation;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tikt.mathmeetsanimation.base.BaseAppActivity;
import com.tikt.mathmeetsanimation.entity.Repo;
import com.tikt.mathmeetsanimation.retrofitInterface.LocalRequestWithPar;
import com.tikt.mathmeetsanimation.retrofitInterface.LocalRequestWithoutPar;

import butterknife.Bind;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BaseAppActivity {

	@Bind(R.id.id_mainActivity_loclaServlet_noPar_btn)
	Button idMainActivityLoclaServletBtn;
	@Bind(R.id.id_mainActivity_loclaServlet_Par_btn)
	Button idMainActivityLoclaServletParBtn;

	//
	Retrofit retrofit;

	@Override
	protected int getContentViewLayoutID() {
		return R.layout.activity_main;
	}

	@Override
	protected void initView() {


	}

	@Override
	protected void initEvent() {

		retrofit = new Retrofit.Builder()
				.baseUrl("http://192.168.1.121:8080/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
	}

	@Override
	protected void dealWithCreate() {

	}

	@Override
	protected void dealWithStart() {

	}

	@Override
	protected void dealWithDestroy() {

	}

	@OnClick({R.id.id_mainActivity_loclaServlet_noPar_btn, R.id.id_mainActivity_loclaServlet_Par_btn})
	public void onClick(View view) {
		switch (view.getId()) {

			case R.id.id_mainActivity_loclaServlet_noPar_btn:
				onRetrofitWithoutParams();
				break;
			case R.id.id_mainActivity_loclaServlet_Par_btn:
				onRetrofitWithParams();
				break;

		}


	}


	/**
	 * 无参Get请求
	 */
	private void onRetrofitWithoutParams() {
		LocalRequestWithoutPar service = retrofit.create(LocalRequestWithoutPar.class);
		Call<Repo> repoCall = service.listRepos();
		Log.i(TAG, "initEvent: repoCall.request().url()==" + repoCall.request().url());

		repoCall.enqueue(new Callback<Repo>() {
			@Override
			public void onResponse(Call<Repo> call, Response<Repo> response) {

				Log.i(TAG, "onResponse: ==");
				Log.i(TAG, "onResponse: getUsername==" + response.body().getUsername());

			}

			@Override
			public void onFailure(Call<Repo> call, Throwable t) {

				Log.i(TAG, "onFailure: ==");

			}
		});
	}

	/**
	 * 带参Get请求
	 */
	private void onRetrofitWithParams() {
		LocalRequestWithPar service = retrofit.create(LocalRequestWithPar.class);
		Call<Repo> repoCall = service.listRepos();
		Log.i(TAG, "initEvent: repoCall.request().url()==" + repoCall.request().url());
		repoCall.enqueue(new Callback<Repo>() {
			@Override
			public void onResponse(Call<Repo> call, Response<Repo> response) {

				Log.i(TAG, "onResponse: ==");
				Log.i(TAG, "onResponse: getUsername==" + response.body().getUsername());

			}

			@Override
			public void onFailure(Call<Repo> call, Throwable t) {

				Log.i(TAG, "onFailure: ==");

			}
		});
	}
}
