package com.tikt.mathmeetsanimation.ui.animation.property;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.widget.Button;
import android.widget.ImageView;

import com.tikt.mathmeetsanimation.R;
import com.tikt.mathmeetsanimation.base.BaseAppActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * ObjectAnimator的基本用法:
 * <p/>
 * 相比于ValueAnimator，在开发中可能ObjectAnimator要比ValueAnimator用的多，
 * 因为ObjectAnimator可以直接操作对象的属性，而不用像ValueAnimator那么麻烦。
 * 假如让一个ImageView做旋转的动画，代码可以这样写：
 * <p/>
 * ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(ivImage,"rotation",0,360);
 * objectAnimator.setDuration(3000);
 * objectAnimator.start();
 * 从上述代码我们可以看到ObjectAnimator与ValueAnimator的用法有点相似，又有不同，
 * 在上述代码中objectAnimator调用了ofFloat()方法来去创建一个ObjectAnimator的实例，
 * 与ValueAnimator不同的是，这里的ofFloat()方法当中接收的参数有点变化了。
 * 这里第一个参数要求传入一个object对象，即进行动画的对象，在上面我们传了一个ImageView。
 * 第二个参数是属性的名字，因为做旋转动画所以这里传的属性的名字为“rotation”。
 * 后面就是可变参数了，这里我们传的是0，360，表示让ImageView旋转360度，
 * 然后设置时长，调用start方法。
 */


public class ObjectAnimatorActivity extends BaseAppActivity {


	@Bind(R.id.id_ObjectAnimatorActivity_img)
	ImageView idObjectAnimatorActivityImg;
	@Bind(R.id.id_ObjectAnimatorActivity_start_btn)
	Button idObjectAnimatorActivityStartBtn;

	//
	ObjectAnimator anim;

	@Override
	protected int getContentViewLayoutID() {
		return R.layout.activity_object_animator;
	}

	@Override
	protected void initView() {

	}

	@Override
	protected void initEvent() {

		/**
		 * ofFloat中的第二个参数都是能传哪些值呢？上面的代码中传了个“alpha”和”rotation”,
		 * 但是究竟它能传哪些值呢？这一点从其名字中可以看出“属性”动画，无疑它是操作对象的属性的，
		 * 所以它可以接收任意值，但是这里有一个前提，那就是这个属性必须要有get和set方法，什么意思呢？
		 * 属性动画针对我们传入的属性值，比方说“alpha”,它会去寻找这个属性名所对应的get和set方法，
		 * 内部会通过java反射机制来调用set函数修改对象属性值。由此我们可以推断出ImageView中肯定会有对alpha属性的get和set操作，
		 * 通过寻找你会发现这两个方法在ImageView的父类View中，通过寻找在View中确实找到了这两个方法如下：
		 *      public void setAlpha(@FloatRange(from=0.0, to=1.0) float alpha);
		 *      public float getAlpha();
		 *
		 * 这里对经常用到的属性做一个小的总结：
		 *  ① translationX和translationY：表示在X轴或者Y轴方向上的位移
		 *  ② scaleX和scaleY：表示在X轴或者Y轴方向上的缩放
		 *  ③ rotation、rotationX和rotationY：这三个属性控制View对象围绕支点进行2D和3D旋转。
		 *  ④ pivotX和pivotY：这两个属性控制着View对象的支点位置，围绕这个支点进行旋转和缩放变换处理。默认情况下，该支点的位置就是View对象的中心点。
		 *  ⑤ x和y：这是两个简单实用的属性，它描述了View对象在它的容器中的最终位置，它是最初的左上角坐标和translationX和translationY值的累计和。
		 *  ⑥ alpha：它表示View对象的alpha透明度。默认值是1（不透明），0代表完全透明（不可见）。
		 *
		 *
		 *
		 */
		anim = ObjectAnimator.ofFloat(idObjectAnimatorActivityImg,"rotation",0,360);
		anim.setRepeatMode(ObjectAnimator.REVERSE);
		anim.setRepeatCount(1);
		anim.setDuration(3000);

		/**
		 * 这里有一点大家需要明白:
		 * AnimatorSet和ValueAnimator是继承自Animator的，而ObjectAnimator是继承自ValueAnimator的。
		 * 所以对于Animator类中的监听，AnimatorSet、ValueAnimator、ObjectAnimator都可以用，
		 * 而ValueAnimator类中的监听，AnimatorSet中是没有的，而ObjectAnimator是继承自ValueAnimator的，
		 * 所以ValueAnimator和ObjectAnimator都是可以调用的。
		 *
		 *
		 */
		/*


		anim.addListener(new Animator.AnimatorListener() {
			@Override
			public void onAnimationStart(Animator animator) {

			}

			@Override
			public void onAnimationEnd(Animator animator) {

			}

			@Override
			public void onAnimationCancel(Animator animator) {

			}

			@Override
			public void onAnimationRepeat(Animator animator) {

			}
		});

		可以看到AnimatorListener提供了对动画开始、动画重复、动画结束、取消动画做了监听。
		但是有时候我们并不需要这么多啊，比如我们只想监听动画的开始，假如用这种方法需要把这四个方法都重写才行，
		代码太冗余了，谷歌的攻城狮也是想到了这一点，给我们提供了一个适配器AnimatorListenerAdapter，有这个类我们就可以选择性的，
		根据需要添加监听了，比如我们只需要添加动画开始时的监听，我们可以这么做：

		*/
		anim.addListener(new AnimatorListenerAdapter() {
			@Override
			public void onAnimationStart(Animator animation) {
				super.onAnimationStart(animation);
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



	@OnClick(R.id.id_ObjectAnimatorActivity_start_btn)
	public void onClick() {
		anim.start();
	}
}
