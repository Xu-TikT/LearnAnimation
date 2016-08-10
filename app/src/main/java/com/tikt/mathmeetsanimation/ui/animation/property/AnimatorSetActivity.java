package com.tikt.mathmeetsanimation.ui.animation.property;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.widget.Button;
import android.widget.ImageView;

import com.tikt.mathmeetsanimation.R;
import com.tikt.mathmeetsanimation.base.BaseAppActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 属性动画练习，组合动画的实现:
 * 要想完成多个动画协同工作需要借助AnimatorSet这个类，这个类主要提供了三个播放方法，play(),playSequentially(),playTogether()。
 * 1.其中playSequentially()表示多个动画按顺序执行，它主要有两种形式的参数playSequentially(Animator… items)
 * 和playSequentially(List <Animator> animator);一个是可变参数，另一个是动画集合。
 * 2.playTogether()表示几个动画同时执行，它接收的参数类型与playSequentially()一致。
 * play方法接收一个Animator动画实例，play(Animator anim)，调用它之后会返回一个AnimatorSet.Builder的实例:
 * 1.after(Animator anim) 将现有动画插入到传入的动画之后执行
 * 2.after(long delay) 将现有动画延迟指定毫秒后执行
 * 3.before(Animator anim) 将现有动画插入到传入的动画之前执行
 * 4.with(Animator anim) 将现有动画和传入的动画同时执行
 */
public class AnimatorSetActivity extends BaseAppActivity {


	@Bind(R.id.id_animatorSetActivity_img)
	ImageView idAnimatorSetActivityImg;
	@Bind(R.id.id_animatorSetActivity_start_btn)
	Button idAnimatorSetActivityStartBtn;

	//
	ObjectAnimator scaleYAnimator;
	ObjectAnimator scaleXAnimator;
	ObjectAnimator rotationXAnimator;
	ObjectAnimator alphaAnimator;
	AnimatorSet set;

	@Override
	protected int getContentViewLayoutID() {
		return R.layout.activity_animator_set;
	}

	@Override
	protected void initView() {

	}

	@Override
	protected void initEvent() {

		scaleYAnimator = ObjectAnimator.ofFloat(idAnimatorSetActivityImg, "scaleY", 0, 1);
		scaleXAnimator = ObjectAnimator.ofFloat(idAnimatorSetActivityImg, "scaleX", 0, 1);
		rotationXAnimator = ObjectAnimator.ofFloat(idAnimatorSetActivityImg, "rotation", 0, 360);
		alphaAnimator = ObjectAnimator.ofFloat(idAnimatorSetActivityImg, "alpha", 0, 1);


		set = new AnimatorSet();
		/*
		playTogether的用法
		 */
//		scaleYAnimator.setRepeatMode(ObjectAnimator.REVERSE);
//		scaleXAnimator.setRepeatMode(ObjectAnimator.REVERSE);
//		rotationXAnimator.setRepeatMode(ObjectAnimator.REVERSE);
//		alphaAnimator.setRepeatMode(ObjectAnimator.REVERSE);
//
//		scaleYAnimator.setRepeatCount(2);
//		scaleXAnimator.setRepeatCount(2);
//		rotationXAnimator.setRepeatCount(1);
//		alphaAnimator.setRepeatCount(2);
//		set.playTogether(scaleXAnimator, scaleYAnimator, alphaAnimator, rotationXAnimator);

		/*
		play的用法
		让一张图片缩放旋转出场，出场之后让它消失
		 */
		//TODO 动画播放完成后，再点击播放按钮，动画有问题，比如alpha值没有重置
		ObjectAnimator alphaAnimator2 = ObjectAnimator.ofFloat(idAnimatorSetActivityImg, "alpha", 1, 0);
		alphaAnimator2.reverse();
		set.play(scaleXAnimator).with(scaleYAnimator);
		set.play(scaleYAnimator).with(rotationXAnimator);
		set.play(alphaAnimator2).after(rotationXAnimator);
		set.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationEnd(Animator animation) {
				super.onAnimationEnd(animation);
			}
		});
		set.setDuration(3000);


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


	@OnClick(R.id.id_animatorSetActivity_start_btn)
	public void onClick() {
		set.start();

	}
}
