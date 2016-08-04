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
 * tween,translate(位移)动画的练习
 * android:fromXDelta:起始点X轴坐标，可以是数值、百分数、百分数p 三种样式，具体意义在roate已经演示过。
 * android:fromYDelta：起始点Y坐标，可以是数值、百分数、百分数p 三种样式。
 * android:toXDelta：结束点X坐标
 * android:toYDelta:结束点Y坐标
 * <p>
 * <p>
 * android:duration:动画执行的时间，以毫秒为单位
 * android:fillEnabled:true|false,true:动画结束时还原到开始动画前的状态,
 * android:fillBefore:如果fillEnabled的值为true，它的值才有意义，否则没有意义
 * 默认值是true，视图会停留在动画开始的状态
 * android:fillAfter:设置的是在这个动画结束后是否保留这个动画的最后一帧的效果填充后面的动画,它的设置不受fillEnabled的影响
 * android:repeatMode:reverse|restart,重复类型,reverse:表示倒序回访,restart:表示重新放一遍这个属性必须与repeatCount联合使用，因为它的前提是重复，即重复播放时的播放类型。
 * android:repeatCount:动画重复的次数(注意是重复的次数)，可以是你想循环播放的次数，也是可以是infinite:表示无限循环
 * android:interpolator:设定的插值器，它主要用来为动画设置一些特殊的效果，比方说：加速运动、减速运动、动画结束的时候弹起等等
 */

public class TweenTranslateActivity extends BaseAppActivity {

	@Bind(R.id.id_tweenTranslateActivity_img)
	ImageView idTweenTranslateActivityImg;
	@Bind(R.id.id_tweenTranslateActivity_start_btn)
	Button idTweenTranslateActivityStartBtn;


	//
	Animation anim;
	@Override
	protected int getContentViewLayoutID() {
		return R.layout.activity_tween_translate;
	}

	@Override
	protected void initView() {

	}

	@Override
	protected void initEvent() {

		anim = AnimationUtils.loadAnimation(this,R.anim.tween_translate);
		anim.setDuration(3000);
		anim.setFillEnabled(false);
		anim.setFillAfter(true);
		anim.setRepeatMode(Animation.REVERSE);
		anim.setRepeatCount(1);
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


	@OnClick(R.id.id_tweenTranslateActivity_start_btn)
	public void onClick() {
		idTweenTranslateActivityImg.startAnimation(anim);
	}
}
