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
 * tween补间动画
 * 渐变透明度的练习(Alpha)
 * <p/>
 * android:fromAlpha:动画开始时的透明度，变化范围为0.0-1.0,0.0表示完全透明，1.0表示完全不透明
 * android:toAlpha：动画结束是的透明度，变化范围和意义同上。
 */

public class TweenAlphaActivity extends BaseAppActivity {

	@Bind(R.id.id_tweenAlphaActivity_view)
	ImageView idTweenAlphaActivityView;
	@Bind(R.id.id_tweenAlphaActivity_start_btn)
	Button idTweenAlphaActivityStartBtn;


	//
	Animation anim;


	@Override
	protected int getContentViewLayoutID() {
		return R.layout.activity_tween_alpha;
	}

	@Override
	protected void initView() {

	}

	@Override
	protected void initEvent() {

		anim = AnimationUtils.loadAnimation(this, R.anim.tween_alpha);
		anim.setDuration(3000);
		anim.setRepeatMode(Animation.REVERSE);
		anim.setRepeatCount(3);
		anim.setFillEnabled(false);
		anim.setFillAfter(true);
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


	@OnClick(R.id.id_tweenAlphaActivity_start_btn)
	public void onClick() {
		idTweenAlphaActivityView.startAnimation(anim);
	}
}
