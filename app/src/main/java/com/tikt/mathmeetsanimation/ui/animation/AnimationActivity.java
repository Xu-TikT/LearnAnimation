package com.tikt.mathmeetsanimation.ui.animation;

import android.view.View;
import android.widget.Button;

import com.tikt.mathmeetsanimation.R;
import com.tikt.mathmeetsanimation.base.BaseAppActivity;
import com.tikt.mathmeetsanimation.ui.animation.frame.FrameAnimationActivity;
import com.tikt.mathmeetsanimation.ui.animation.tween.TweenAlphaActivity;
import com.tikt.mathmeetsanimation.ui.animation.tween.TweenInterpolatorActivity;
import com.tikt.mathmeetsanimation.ui.animation.tween.TweenRotateActivity;
import com.tikt.mathmeetsanimation.ui.animation.tween.TweenScaleActivity;
import com.tikt.mathmeetsanimation.ui.animation.tween.TweenSetActivity;
import com.tikt.mathmeetsanimation.ui.animation.tween.TweenSetWithCodeActivity;
import com.tikt.mathmeetsanimation.ui.animation.tween.TweenTranslateActivity;

import butterknife.Bind;
import butterknife.OnClick;


/**
 * 动画练习
 */
public class AnimationActivity extends BaseAppActivity {

	@Bind(R.id.id_animationActivity_tween_set_code_btn)
	Button idAnimationActivityTweenSetWithCodeBtn;
	@Bind(R.id.id_animationActivity_tween_interpolator_btn)
	Button idAnimationActivityTweenInterpolatorBtn;
	@Bind(R.id.id_animationActivity_tween_set_btn)
	Button idAnimationActivityTweenSetBtn;
	@Bind(R.id.id_animationActivity_tween_scale_btn)
	Button idAnimationActivityTweenScaleBtn;
	@Bind(R.id.id_animationActivity_tween_translate_btn)
	Button idAnimationActivityTweenTranslateBtn;
	@Bind(R.id.id_animationActivity_tween_alpha_btn)
	Button idAnimationActivityTweenAlphaBtn;
	@Bind(R.id.id_animationActivity_tween_rotate_btn)
	Button idAnimationActivityTweenRotateBtn;
	@Bind(R.id.id_animationActivity_frame_btn)
	Button idAnimationActivityFrameBtn;

	@Override
	protected int getContentViewLayoutID() {
		return R.layout.activity_animation;
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


	@OnClick({R.id.id_animationActivity_frame_btn,
			R.id.id_animationActivity_tween_rotate_btn,
			R.id.id_animationActivity_tween_alpha_btn,
			R.id.id_animationActivity_tween_translate_btn,
			R.id.id_animationActivity_tween_scale_btn,
			R.id.id_animationActivity_tween_set_btn,
			R.id.id_animationActivity_tween_interpolator_btn,
			R.id.id_animationActivity_tween_set_code_btn})
	public void onClick(View view) {

		switch (view.getId()) {
			case R.id.id_animationActivity_frame_btn:
				onStartActivity(FrameAnimationActivity.class);
				break;
			case R.id.id_animationActivity_tween_rotate_btn:
				onStartActivity(TweenRotateActivity.class);
				break;
			case R.id.id_animationActivity_tween_alpha_btn:
				onStartActivity(TweenAlphaActivity.class);
				break;
			case R.id.id_animationActivity_tween_translate_btn:
				onStartActivity(TweenTranslateActivity.class);
				break;
			case R.id.id_animationActivity_tween_scale_btn:
				onStartActivity(TweenScaleActivity.class);
				break;
			case R.id.id_animationActivity_tween_set_btn:
				onStartActivity(TweenSetActivity.class);
				break;
			case R.id.id_animationActivity_tween_interpolator_btn:
				onStartActivity(TweenInterpolatorActivity.class);
				break;
			case R.id.id_animationActivity_tween_set_code_btn:
				onStartActivity(TweenSetWithCodeActivity.class);
				break;
		}

	}
}
