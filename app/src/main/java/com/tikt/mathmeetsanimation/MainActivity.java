package com.tikt.mathmeetsanimation;

import android.view.View;
import android.widget.Button;

import com.tikt.mathmeetsanimation.base.BaseAppActivity;
import com.tikt.mathmeetsanimation.ui.ImgTestActivity;
import com.tikt.mathmeetsanimation.ui.animation.AnimationActivity;
import com.tikt.mathmeetsanimation.ui.RetrofitActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseAppActivity {
	@Bind(R.id.id_mainActivity_animation_btn)
	Button idMainActivityAnimationBtn;
	@Bind(R.id.id_mainActivity_retrofit_btn)
	Button idMainActivityRetrofitBtn;
	@Bind(R.id.id_mainActivity_ImgTest_btn)
	Button idMainActivityImgTestBtn;


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

	@OnClick({R.id.id_mainActivity_retrofit_btn,R.id.id_mainActivity_animation_btn,
			R.id.id_mainActivity_ImgTest_btn})
	public void onClick(View view) {
		switch (view.getId()){

			case R.id.id_mainActivity_retrofit_btn:
//				showToast("onClick");
				onStartActivity(RetrofitActivity.class);
				break;
			case R.id.id_mainActivity_animation_btn:
				onStartActivity(AnimationActivity.class);
				break;
			case R.id.id_mainActivity_ImgTest_btn:
				onStartActivity(ImgTestActivity.class);
				break;

		}

	}



}
