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
 * tween scale(缩放)动画练习
 * 1.1 独有属性
    android:fromXScale起始的X方向上相对自身的缩放比例,类型float，比如1.0代表自身无变化，0.5代表起始时缩小一倍，2.0代表放大一倍
    android:toXScale:结尾的X方向上相对自身的缩放比例,类型float
    android:fromYScale:起始的Y方向上相对自身的缩放比例,类型float
    android:toYScale:结尾的Y方向上相对自身的缩放比例,类型float
    android:pivotX: 缩放起点X轴坐标，可以是数值、百分数、百分数p ,具体意义roate中已经演示
    android:pivotY:缩放起点Y轴坐标，取值及意义与pivotX一样
    (pivotX,pivotY相当于缩放时移动的距离)
 *
 *
 * 2.2 从Animation类继承的属性
    android:duration:动画执行的时间，以毫秒为单位
    android:fillEnabled:true|false,true:动画结束时还原到开始动画前的状态
    android:fillBefore:如果fillEnabled的值为true，它的值才有意义，否则没有意义默认值是true，视图会停留在动画开始的状态
    android:fillAfter:设置的是在这个动画结束后是否保留这个动画的最后一帧的效果填充后面的动画,它的设置不受fillEnabled的影响
    android:repeatMode:reverse|restart,重复类型,reverse:表示倒序回访,restart:表示重新放一遍这个属性必须与repeatCount联合使用，因为它的前提是重复，即重复播放时的播放类型。
    android:repeatCount:动画重复的次数(注意是重复的次数)，可以是你想循环播放的次数，也是可以是infinite:表示无限循环
    android:interpolator:设定的插值器，它主要用来为动画设置一些特殊的效果，比方说：加速运动、减速运动、动画结束的时候弹起等等。
 */
public class TweenScaleActivity extends BaseAppActivity {


	@Bind(R.id.id_tweenScaleActivity_img)
	ImageView idTweenScaleActivityImg;
	@Bind(R.id.id_tweenScaleActivity_start_btn)
	Button idTweenScaleActivityStartBtn;

	//
	Animation anim;

	@Override
	protected int getContentViewLayoutID() {
		return R.layout.activity_tween_scale;
	}

	@Override
	protected void initView() {

	}

	@Override
	protected void initEvent() {

		anim = AnimationUtils.loadAnimation(this,R.anim.tween_scale);
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


	@OnClick(R.id.id_tweenScaleActivity_start_btn)
	public void onClick() {

		idTweenScaleActivityImg.startAnimation(anim);

	}
}
