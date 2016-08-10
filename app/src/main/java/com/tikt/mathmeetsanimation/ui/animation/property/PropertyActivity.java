package com.tikt.mathmeetsanimation.ui.animation.property;

import android.view.View;
import android.widget.Button;

import com.tikt.mathmeetsanimation.R;
import com.tikt.mathmeetsanimation.base.BaseAppActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 属性动画练习
 *
 */
public class PropertyActivity extends BaseAppActivity {


	@Bind(R.id.id_ValueAnimatorActivity_onStartBtn)
	Button idValueAnimatorActivityBtn;
	@Bind(R.id.id_ObjectAnimatorActivity_onStartBtn)
	Button idObjectAnimatorActivityBtn;
	@Bind(R.id.id_ObjectAnimatorSetActivity_onStartBtn)
	Button idObjectAnimatorSetActivityBtn;

	@Override
	protected int getContentViewLayoutID() {
		return R.layout.activity_property;
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


	@OnClick({R.id.id_ValueAnimatorActivity_onStartBtn, R.id.id_ObjectAnimatorActivity_onStartBtn,
			R.id.id_ObjectAnimatorSetActivity_onStartBtn})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.id_ValueAnimatorActivity_onStartBtn:
				onStartActivity(ValueAnimatorActivity.class);
				break;
			case R.id.id_ObjectAnimatorActivity_onStartBtn:
				onStartActivity(ObjectAnimatorActivity.class);
				break;
			case R.id.id_ObjectAnimatorSetActivity_onStartBtn:
				onStartActivity(AnimatorSetActivity.class);
				break;
		}
	}
}
