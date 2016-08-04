package com.tikt.mathmeetsanimation.ui.animation.tween;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.tikt.mathmeetsanimation.R;
import com.tikt.mathmeetsanimation.base.BaseAppActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 使用set标签，将不同的动画类型组合成一组复杂的动画效果
 * set标签自已是没有属性的，他的属性都是从Animation继承而来
 */
public class TweenSetActivity extends BaseAppActivity {


	@Bind(R.id.id_tweenSetActivity_img)
	ImageView idTweenSetActivityImg;
	@Bind(R.id.id_tweenSetActivity_start_btn)
	Button idTweenSetActivityStartBtn;

	//
	Animation anim;

	@Override
	protected int getContentViewLayoutID() {
		return R.layout.activity_tween_set;
	}

	@Override
	protected void initView() {

	}

	@Override
	protected void initEvent() {

		anim = AnimationUtils.loadAnimation(this,R.anim.tween_set);


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


	@OnClick(R.id.id_tweenSetActivity_start_btn)
	public void onClick() {
		idTweenSetActivityImg.startAnimation(anim);
	}
}
