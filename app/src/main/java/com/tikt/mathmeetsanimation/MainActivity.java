package com.tikt.mathmeetsanimation;

import android.view.View;
import android.widget.Button;

import com.tikt.mathmeetsanimation.base.BaseAppActivity;
import com.tikt.mathmeetsanimation.ui.RetrofitActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseAppActivity {
	@Bind(R.id.id_mainActivity_retrofit_btn)
	Button idMainActivityRetrofitBtn;


	//

	@Override
	protected int getContentViewLayoutID() {
		return R.layout.activity_main;
	}

	@Override
	protected void initView() {


	}

	@Override
	protected void initEvent() {


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

	@OnClick({R.id.id_mainActivity_retrofit_btn})
	public void onClick(View view) {
		switch (view.getId()){

			case R.id.id_mainActivity_retrofit_btn:
				showToast("onClick");
					onStartActivity(RetrofitActivity.class);
				break;


		}

	}



}
