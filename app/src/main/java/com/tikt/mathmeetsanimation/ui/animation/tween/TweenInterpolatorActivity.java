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
 * tween interpolator(插值器)
 * interpolaotor定义了动画变化的速率，它允许基础动画(alpha, scale, translate, rotate)加速，减速，重复变化等等。
 * 在补间动画中，我们一般只定义关键帧（首帧和尾帧），然后由系统自动生成中间帧，生成中间帧的这个过程可以成为“插值”。
 * 插值器定义了动画变化的速率，
 * 提供不同的函数定义变化值相对于时间的变化规则，可以定义各种各样的非线性变化函数，比如加速、减速等。
 *
 * 1.系统提供的插值器
 * Interpolator对象 	                     资源ID 	                                              功能作用

 * AccelerateDecelerateInterpolator 	@android:anim/accelerate_decelerate_interpolator 	先加速再减速
 * AccelerateInterpolator 	            @android:anim/accelerate_interpolator 	            加速
 * AnticipateInterpolator 	            @android:anim/anticipate_interpolator 	            先回退一小步然后加速前进
 * AnticipateOvershootInterpolator 	    @android:anim/anticipate_overshoot_interpolator 	先回退一小步然后加速前进，超出终点一小步后再回到终点
 * BounceInterpolator 	                @android:anim/bounce_interpolator 	                最后阶段弹球效果
 * CycleInterpolator 	                @android:anim/cycle_interpolator 	                周期运动
 * DecelerateInterpolator 	            @android:anim/decelerate_interpolator 	            减速
 * LinearInterpolator 	                @android:anim/linear_interpolator 	                匀速
 * OvershootInterpolator 	            @android:anim/overshoot_interpolator 	            快速到达终点并超出一小步最后回到终点
 *
 * 2.自定义插值器
 * 我们可以创建一个插值器资源修改插值器的属性，比如修改AnticipateInterpolator的加速速率，调整CycleInterpolator的循环次数等。
 * 为了完成这种需求，我们需要创建XML资源文件，然后将其放于/res/anim下，然后在动画元素中引用即可。
 * 我们先来看一下几种常见的插值器可调整的属性：
 *  <accelerateDecelerateInterpolator> 无
 *  <accelerateInterpolator> android:factor 浮点值，加速速率，默认为1
 *  <anticipateInterploator> android:tension 浮点值，起始点后退的张力、拉力数，默认为2
 *  <anticipateOvershootInterpolator> android:tension 同上 android:extraTension 浮点值，拉力的倍数，默认为1.5（2  * 1.5）
 *  <bounceInterpolator> 无
 *  <cycleInterplolator> android:cycles 整数值，循环的个数，默认为1
 *  <decelerateInterpolator> android:factor 浮点值，减速的速率，默认为1
 *  <linearInterpolator> 无
 *  <overshootInterpolator> 浮点值，超出终点后的张力、拉力，默认为2
 *
 *
 *
 *
 */
public class TweenInterpolatorActivity extends BaseAppActivity {


	@Bind(R.id.id_tweenInterpolatorActivity_img)
	ImageView idTweenInterpolatorActivityImg;
	@Bind(R.id.id_tweenInterpolatorActivity_start_btn)
	Button idTweenInterpolatorActivityStartBtn;

	//
	Animation anim;


	@Override
	protected int getContentViewLayoutID() {
		return R.layout.activity_tween_interpolator;
	}

	@Override
	protected void initView() {

	}

	@Override
	protected void initEvent() {

		anim = AnimationUtils.loadAnimation(this,R.anim.tween_interpolator);
//		anim.setInterpolator(new AnticipateInterpolator());
//		anim.setInterpolator(new AccelerateDecelerateInterpolator());
//		anim.setInterpolator(new AccelerateInterpolator());
//		anim.setInterpolator(new AnticipateOvershootInterpolator());
//		anim.setInterpolator(new BounceInterpolator());
//		anim.setInterpolator(new CycleInterpolator(2.0f));
		anim.setInterpolator(this,R.anim.my_anticipate_interpolator);//使用修改了AnticipateInterpolator的tension值的插值器
//		anim.setInterpolator(new DecelerateInterpolator());
//		anim.setInterpolator(new LinearInterpolator());
//		anim.setInterpolator(new OvershootInterpolator());
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


	@OnClick(R.id.id_tweenInterpolatorActivity_start_btn)
	public void onClick() {

		idTweenInterpolatorActivityImg.startAnimation(anim);
	}
}
