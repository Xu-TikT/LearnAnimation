package com.tikt.mathmeetsanimation;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.tikt.mathmeetsanimation.api.Api;
import com.tikt.mathmeetsanimation.base.BaseAppActivity;
import com.tikt.mathmeetsanimation.entity.Repo;
import com.tikt.mathmeetsanimation.retrofitInterface.GetLocalRequestWithPar;
import com.tikt.mathmeetsanimation.retrofitInterface.GetLocalRequestWithPar2;
import com.tikt.mathmeetsanimation.retrofitInterface.GetLocalRequestWithParMap;
import com.tikt.mathmeetsanimation.retrofitInterface.GetLocalRequestWithoutPar;
import com.tikt.mathmeetsanimation.retrofitInterface.GetLocalRequestWithoutPar2;
import com.tikt.mathmeetsanimation.retrofitInterface.ResultOfNetwork;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BaseAppActivity implements ResultOfNetwork{

	@Bind(R.id.id_mainActivity_loclaServlet_noPar_btn)
	Button idMainActivityLoclaServletBtn;
	@Bind(R.id.id_mainActivity_loclaServlet_Par_btn)
	Button idMainActivityLoclaServletParBtn;
	@Bind(R.id.id_mainActivity_loclaServlet_ParMap_btn)
	Button idMainActivityLoclaServletParMapBtn;
	@Bind(R.id.id_mainActivity_loclaServlet_Par2_btn)
	Button idMainActivityLoclaServletPar2Btn;
	@Bind(R.id.id_mainActivity_loclaServlet_noPar2_btn)
	Button idMainActivityLoclaServletNoPar2Btn;

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
				.baseUrl(Api.BaseUrl)
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

	@OnClick({R.id.id_mainActivity_loclaServlet_noPar_btn, R.id.id_mainActivity_loclaServlet_Par_btn,
			R.id.id_mainActivity_loclaServlet_noPar2_btn,R.id.id_mainActivity_loclaServlet_Par2_btn,
			R.id.id_mainActivity_loclaServlet_ParMap_btn})
	public void onClick(View view) {
		switch (view.getId()) {

			case R.id.id_mainActivity_loclaServlet_noPar_btn:
				onGetRetrofitWithoutParams();
				break;
			case R.id.id_mainActivity_loclaServlet_Par_btn:
				onGetRetrofitWithParams();
				break;
			case R.id.id_mainActivity_loclaServlet_noPar2_btn:
				onGetRetrofitWithoutParams2();
				break;
			case R.id.id_mainActivity_loclaServlet_Par2_btn:
				onGetRetrofitWithParams2();
				break;
			case R.id.id_mainActivity_loclaServlet_ParMap_btn:
				onGetRetrofitWithParamsMap();
				break;

		}


	}


	/**
	 * 无参Get请求
	 */
	private void onGetRetrofitWithoutParams() {
		GetLocalRequestWithoutPar service = retrofit.create(GetLocalRequestWithoutPar.class);
		Call<Repo> repoCall = service.listRepos();
		Log.i(TAG, "initEvent: repoCall.request().url()==" + repoCall.request().url());

		repoCall.enqueue(new Callback<Repo>() {
			@Override
			public void onResponse(Call<Repo> call, Response<Repo> response) {

				Log.i(TAG, "onResponse: ==");
				Log.i(TAG, "onResponse: getResponse==" + response.body().getResponse());
				showToast(response.body().getResponse());

			}

			@Override
			public void onFailure(Call<Repo> call, Throwable t) {

				Log.i(TAG, "onFailure: ==");

			}
		});
	}

	/**
	 * 无参Get请求,利用函数参数修改url
	 */
	private void onGetRetrofitWithoutParams2() {
		GetLocalRequestWithoutPar2 service = retrofit.create(GetLocalRequestWithoutPar2.class);
		Call<Repo> repoCall = service.listRepos("ServletTwo");
		Log.i(TAG, "initEvent: repoCall.request().url()==" + repoCall.request().url());

		repoCall.enqueue(new Callback<Repo>() {
			@Override
			public void onResponse(Call<Repo> call, Response<Repo> response) {

				Log.i(TAG, "onResponse: ==");
				Log.i(TAG, "onResponse: getResponse==" + response.body().getResponse());
				showToast(response.body().getResponse());

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
	private void onGetRetrofitWithParams() {
		GetLocalRequestWithPar service = retrofit.create(GetLocalRequestWithPar.class);
		Call<Repo> repoCall = service.listRepos();
		Log.i(TAG, "initEvent: repoCall.request().url()==" + repoCall.request().url());
		repoCall.enqueue(new Callback<Repo>() {

			@Override
			public void onResponse(Call<Repo> call, Response<Repo> response) {

				Log.i(TAG, "onResponse: ==");
				Log.i(TAG, "onResponse: getResponse==" + response.body().getResponse());
				showToast(response.body().getResponse());
				onSuccess(response);
			}

			@Override
			public void onFailure(Call<Repo> call, Throwable t) {

				Log.i(TAG, "onFailure: ==");

			}
		});
	}

	/**
	 * 带参Get请求,使用函数参数传入提交参数
	 */
	private void onGetRetrofitWithParams2() {
		GetLocalRequestWithPar2 service = retrofit.create(GetLocalRequestWithPar2.class);
		Call<Repo> repoCall = service.listRepos("hello onGetRetrofitWithParams2!");
		Log.i(TAG, "initEvent: repoCall.request().url()==" + repoCall.request().url());
		repoCall.enqueue(new Callback<Repo>() {

			@Override
			public void onResponse(Call<Repo> call, Response<Repo> response) {

				Log.i(TAG, "onResponse: ==");
				Log.i(TAG, "onResponse: getResponse==" + response.body().getResponse());
				showToast(response.body().getResponse());
				onSuccess(response);
			}

			@Override
			public void onFailure(Call<Repo> call, Throwable t) {

				Log.i(TAG, "onFailure: ==");

			}
		});
	}

	/**
	 * 带参Get请求,使用函数参数传入提交参数
	 */
	private void onGetRetrofitWithParamsMap() {
		GetLocalRequestWithParMap service = retrofit.create(GetLocalRequestWithParMap.class);

		Map<String ,String > map = new HashMap<>();
		map.put("first par","hello");
		map.put("second par","world");
		Call<Repo> repoCall = service.listRepos(map);
		Log.i(TAG, "initEvent: repoCall.request().url()==" + repoCall.request().url());
		repoCall.enqueue(new Callback<Repo>() {

			@Override
			public void onResponse(Call<Repo> call, Response<Repo> response) {

				Log.i(TAG, "onResponse: ==");
				Log.i(TAG, "onResponse: getResponse==" + response.body().getResponse());
				showToast(response.body().getResponse());
				onSuccess(response);
			}

			@Override
			public void onFailure(Call<Repo> call, Throwable t) {

				Log.i(TAG, "onFailure: ==");

			}
		});
	}


	@Override
	public void onSuccess(Response result){
	}

	@Override
	public void onFailure(Response result) {

	}

}
