package com.tikt.mathmeetsanimation.ui.animation.property;

import android.animation.ValueAnimator;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import com.tikt.mathmeetsanimation.R;
import com.tikt.mathmeetsanimation.base.BaseAppActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * ValueAnimator的基本使用:
 * <p>
 * //设置操作属性的一系列值float
 * ofFloat(float... values)
 * ofInt(int... values)
 * ofObject(TypeEvaluator evaluator, Object... values)
 * //用于实现组合动画等
 * ofPropertyValuesHolder(PropertyValuesHolder... values)
 * setFrameDelay(long frameDelay)
 * ValueAnimator setDuration(long duration)
 * //获取ValueAnimator在运动时，当前运动点的值
 * Object getAnimatedValue();
 * //开始动画
 * void start()
 * //设置循环次数,设置为INFINITE表示无限循环
 * void setRepeatCount(int value)
 * //设置循环模式 value取值有RESTART，REVERSE，
 * void setRepeatMode(int value)
 * // 取消动画
 * void cancel()
 * <p>
 * 在上面的方法中，可能大家比较陌生的就是of开头的那几个，
 * 其中ofFloat，ofInt它们接收的参数类型都是可变参，
 * 所以我们可以传入任何数量的值；传进去的值列表，就表示动画时的变化范围:
 * 比如ofInt(3,9,6)就表示从数值3变化到数值9再变化到数值6
 * 而ofObject接收两个参数一个TypeEvaluator类型的，另一个是Object类型的可变参数。
 * 然后就是ofPropertyValuesHolder多属性动画同时工作管理类，有时候我们需要对一个对象的多个属性做动画，此时就会用到它。
 * setFrameDelay设置多长时间刷新一帧，默认是10ms。但最终依赖系统的当前状态，一般我们不用管。
 *
 *
 *
 */


public class ValueAnimatorActivity extends BaseAppActivity {


	@Bind(R.id.id_ValueAnimatorActivity_img)
	ImageView idValueAnimatorActivityImg;
	@Bind(R.id.id_ValueAnimatorActivity_start_btn)
	Button idValueAnimatorActivityStartBtn;

	//
	ValueAnimator anim;

	@Override
	protected int getContentViewLayoutID() {
		return R.layout.activity_value_animator;
	}

	@Override
	protected void initView() {

	}

	@Override
	protected void initEvent() {

		/*
		执行上面的代码就执行了一个值从0到1平滑过渡的动画，从下面的代码中可以看出它并没有与任何的控件的任何属性有关系，
		从它的名字也能看出来它是对值做平滑过渡的

		在上述代码中我们给valueAnimator添加了一个addUpdateListener监听，在监听的回调中，
		回调给我们的是当前状态的ValueAnimator 的实例，得到这个实例后通过调用getAnimatedValue就可以拿到当前的值，然后将其打印，
		这里有一点需要提醒大家注意的是拿到的这个值的类型是与of..后的值得类型相对应的，ofFloat拿到的就是float类型，ofInt拿到的就是int类型。

		 */
		anim = ValueAnimator.ofFloat(0,100);
		anim.setRepeatMode(ValueAnimator.REVERSE);
		anim.setRepeatCount(1);
		anim.setDuration(3000);
		anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(ValueAnimator valueAnimator) {
				float val = (float) valueAnimator.getAnimatedValue();
				Log.i(TAG, "onAnimationUpdate: val=="+val);
				// 在上述代码中通过对valueAnimator添加监听，拿到当前帧的值后，
				// 不断的设置ImageView的TranslatonX(该View在X轴的偏移量)值，从而让其移动。
				// 可以看到我们通过使用ValueAnimator实现了在3秒内在X,Y轴方向上移动100px的效果。这个动画的操作是在ValueAnimator的监听中实现的。
				idValueAnimatorActivityImg.setTranslationX(val);
				idValueAnimatorActivityImg.setTranslationY(val);

				/**
				 * 小总结： ValueAnimator是计算动画过程中变化的值，包含动画的开始值，结束值，持续时间等属性。
				 * 但是这些值与我们的控件是无关的，要想把计算出来的值应用到对象上，必须为ValueAnimator注册一个监听器，
				 * 该监听器负责更新对象的属性值。在实现这个监听器的时候，可以通过getAnimatedValue()的方法来获取当前动画的值，
				 * 拿到这个值后，我们就可以为所欲为了。
				 *
				 *
				 */
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



	@OnClick(R.id.id_ValueAnimatorActivity_start_btn)
	public void onClick() {
		anim.start();
	}
}
