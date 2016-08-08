package com.tikt.mathmeetsanimation.ui.animation.tween;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.tikt.mathmeetsanimation.R;
import com.tikt.mathmeetsanimation.base.BaseAppActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * tween
 * <p/>
 * 使用代码实现一组动画
 */
public class TweenSetWithCodeActivity extends BaseAppActivity {


	@Bind(R.id.id_tweenSetWithCodeActivity_img)
	ImageView idTweenSetWithCodeActivityImg;
	@Bind(R.id.id_tweenSetWithCodeActivity_start_btn)
	Button idTweenSetWithCodeActivityStartBtn;


	//
	ScaleAnimation scaleAnimation;
	AlphaAnimation alphaAnimation_2;
	AlphaAnimation alphaAnimation_1;
	TranslateAnimation translateAnimation;
	RotateAnimation rotateAnimation;
	AnimationSet animationSet;


	@Override
	protected int getContentViewLayoutID() {
		return R.layout.activity_tween_set_with_code;
	}

	@Override
	protected void initView() {

	}

	@Override
	protected void initEvent() {
		alphaAnimation_1 = new AlphaAnimation(0f,1f);
		alphaAnimation_1.setDuration(3000);

		scaleAnimation = new ScaleAnimation(0f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0.5f,
				Animation.RELATIVE_TO_SELF, 0.5f);
		scaleAnimation.setDuration(3000);


		rotateAnimation = new RotateAnimation(0, 720, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		rotateAnimation.setDuration(3000);

		translateAnimation = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 85,
				Animation.ABSOLUTE, 0, Animation.ABSOLUTE, 0);
		translateAnimation.setDuration(1000);
		translateAnimation.setStartOffset(3000);

		alphaAnimation_2 = new AlphaAnimation(1f, 0f);
		alphaAnimation_2.setDuration(1000);
		alphaAnimation_2.setStartOffset(4000);

		animationSet = new AnimationSet(false);
		animationSet.addAnimation(alphaAnimation_1);
		animationSet.addAnimation(scaleAnimation);
		animationSet.addAnimation(rotateAnimation);
		animationSet.addAnimation(translateAnimation);
		animationSet.addAnimation(alphaAnimation_2);


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


	@OnClick(R.id.id_tweenSetWithCodeActivity_start_btn)
	public void onClick() {

		idTweenSetWithCodeActivityImg.startAnimation(animationSet);
	}
}
