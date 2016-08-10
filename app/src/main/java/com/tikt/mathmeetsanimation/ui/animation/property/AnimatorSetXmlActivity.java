package com.tikt.mathmeetsanimation.ui.animation.property;

import com.tikt.mathmeetsanimation.R;
import com.tikt.mathmeetsanimation.base.BaseAppActivity;

/**
 * 使用xml定义属性动画
 *
 * 在xml文件中总共有可以用三个标签，与代码实现是对应着的:
 * <animator> 对应代码中的ValueAnimator
 * <objectAnimator> 对应代码中的ObjectAnimator
 * <set> 对应代码中的AnimatorSet
 *
 *  1.animator中的属性：
 *
 *  <animator
     android:duration="int"
     android:valueFrom="float | int | color"
     android:valueTo="float | int | color"
     android:startOffset="int"
     android:repeatCount="int"
     android:repeatMode=["repeat" | "reverse"]
     android:valueType=["intType" | "floatType"]
     android:interpolator=["@android:interpolator/XXX"]/>

 *  android:duration:表示动画播放的时长
 *  android:valueFrom:动画属性开始的值；取值范围为float,int和color，如果未指定，动画开始属性通过属性的get方法获得。
    颜色用6位16进制数表示(例如：#333333)
 *  android:valueTo：动画结束值；取值范围同valueFrom
 *  android:startOffset：取值范围为int,动画的start方法被调用后，延迟多少毫秒执行。
 *  android:repeatCount：动画重复的次数，可以设置为-1或者正整数，-1表示无限循环，假如我们设置成1，表示重复执行一次，所以它总共会执行2次。
 *  android:repeatMode：动画重复模式，取值为repeat和reverse；repeat表示正序重播，reverse表示倒序重播，这与前面讲的Tween动画是类似的。
 *  android:valueType：表示参数值类型，取值为intType和floatType；与android:valueFrom、android:valueTo相对应。
    如果这里的取值为intType，那么android:valueFrom、android:valueTo的值也就要对应的是int类型的数值。float也是一样。
    如果android:valueFrom、android:valueTo的值设置为color类型的值，则不需要设置这个参数；
 *  android:interpolator:设置加速器

 * 2.objectAnimator标签中的属性如下：
 *
 *
 *
 *
 */
public class AnimatorSetXmlActivity extends BaseAppActivity {


	@Override
	protected int getContentViewLayoutID() {
		return R.layout.activity_animator_set_xml;
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
}
