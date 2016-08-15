package com.tikt.mathmeetsanimation.ui.mvpdemo;

import android.widget.TextView;

import com.tikt.mathmeetsanimation.R;
import com.tikt.mathmeetsanimation.base.BaseAppActivity;

import butterknife.Bind;

/**
 * mvpDemo
 */
public class MVPDemoActivity extends BaseAppActivity implements MainView{


	@Bind(R.id.id_mvpDemoActivity_textView)
	TextView idMvpDemoActivityTextView;

	//
	MainPresenter presenter;




	@Override
	protected int getContentViewLayoutID() {
		return R.layout.activity_mvpdemo;
	}

	@Override
	protected void initView() {

	}

	@Override
	protected void initEvent() {

		//正式环境
		presenter = new MainPresenter();
		//测试环境
//		presenter = new MainPresenter().test();
		presenter.addTaskListener(this);
		presenter.getString();
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

	@Override
	public void onShowString(String json) {
		idMvpDemoActivityTextView.setText(json);
	}
}
