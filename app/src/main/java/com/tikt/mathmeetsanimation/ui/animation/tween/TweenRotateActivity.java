package com.tikt.mathmeetsanimation.ui.animation.tween;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.tikt.mathmeetsanimation.R;
import com.tikt.mathmeetsanimation.base.BaseAppActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Tween补间动画
 * 在android中补间动画可以分为四类：alpha(渐变)、scale(缩放)、translate(位移)、rotate(旋转)
 * Tween动画都有其独有的属性又有其从Animation类继承的公共的属性
 * 这里以roate动画为例讨论:
 * 1.1 独有属性:
 * android:fromDegrees：动画开始时旋转的角度位置，float类型，正值代表顺时针方向度数，负值代码逆时针方向度数
 * android:toDegrees: 动画结束时旋转到的角度位置，float类型，正值代表顺时针方向度数，负值代码逆时针方向度数
 * android:pivotX:旋转点X轴坐标，float类型，可以是数值、百分数、百分数p三种样式，
 * 比如50、50%、50%p，
 * 当为数值时，表示在当前View的左上角，即原点处加上50px，做为旋转点X坐标.
 * 如果是50%,表示在当前控件的左上角加上自己宽度的50%做为旋转点X坐标;
 * 如果是50%p，那么就是表示在当前控件的左上角加上父控件宽度的50%做为旋转点X坐标。
 * android:pivotY:旋转点Y轴坐标，取值及意义跟android:pivotX一样。
 * <p/>
 * 1.2 从Animation类继承的属性:
 * (以下属性现在需要在代码中设置)
 * android:duration:动画执行的时间，以毫秒为单位
 * android:fillEnabled:true|false,true:动画结束时还原到开始动画前的状态
 * android:fillBefore:如果fillEnabled的值为true，它的值才有意义，否则没有意义,默认值是true，视图会停留在动画开始的状态
 * android:fillAfter:设置的是在这个动画结束后是否保留这个动画的最后一帧的效果填充后面的动画,它的设置不受fillEnabled的影响
 * android:repeatMode:reverse|restart,重复类型,reverse:表示倒序回访,restart:表示重新放一遍，
 * 这个属性必须与repeatCount联合使用,因为它的前提是重复,即重复播放时的播放类型。
 * android:repeatCount:动画重复的次数(注意是重复的次数)，可以是你想循环播放的次数，也是可以是infinite:表示无限循环
 * android:interpolator:设定的插值器，它主要用来为动画设置一些特殊的效果，比方说：加速运动、减速运动、动画结束的时候弹 起等等
 * <p/>
 * XML文件编写好了,借助AnimationUtils这个类,把文件加载进来并将动画启动
 */
public class TweenRotateActivity extends BaseAppActivity {


	@Bind(R.id.id_tweenRotateActivity_animView)
	ImageView idTweenActivityAnimView;

	//
	Animation animation;
	@Bind(R.id.id_tweenRotateActivity_start_btn)
	Button idTweenActivityStartBtn;
	@Bind(R.id.id_tweenRotateActivity_stop_btn)
	Button idTweenActivityStopBtn;
	@Bind(R.id.id_tweenRotateActivity_reset_btn)
	Button idTweenActivityResetBtn;


	@Override
	protected int getContentViewLayoutID() {
		return R.layout.activity_tween_rotate;
	}

	@Override
	protected void initView() {

	}

	@Override
	protected void initEvent() {

		animation = AnimationUtils.loadAnimation(this, R.anim.tween_rotate);
		animation.setDuration(5000);
		animation.setFillEnabled(false);
		animation.setFillAfter(true);
		/*
		RepeatMode:重放的形式,REVERSE:第一次播放完成后倒序播放，RESTART:第一次播放完成后从头播放
		RepeatCount:重放的次数,不算第一次播放
		 */
//		animation.setRepeatMode(Animation.REVERSE);//倒序重放
		animation.setRepeatMode(Animation.RESTART);//从头重放
		animation.setRepeatCount(2);
		animation.setAnimationListener(new Animation.AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {

			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}
		});

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


	@OnClick({R.id.id_tweenRotateActivity_start_btn, R.id.id_tweenRotateActivity_stop_btn,
			R.id.id_tweenRotateActivity_reset_btn})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.id_tweenRotateActivity_start_btn:
				idTweenActivityAnimView.startAnimation(animation);
//				animation.start();
				break;
			case R.id.id_tweenRotateActivity_stop_btn:
//				animation.cancel();
				break;
			case R.id.id_tweenRotateActivity_reset_btn:
//				animation.reset();
				break;
		}
	}
}
