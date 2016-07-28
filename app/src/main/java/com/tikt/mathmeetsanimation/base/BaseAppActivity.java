package com.tikt.mathmeetsanimation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by tikt on 16-7-27.
 * 最底层的BaseActivity
 */
public abstract class BaseAppActivity extends AppCompatActivity{

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dealWithCreate();
		if (getContentViewLayoutID() != 0) {
			setContentView(getContentViewLayoutID());
		}
	}
	/**
	 * bind layout resource file
	 *
	 * @return id of layout resource
	 */
	protected abstract int getContentViewLayoutID();

	@Override
	public void setContentView(int layoutResID) {
		super.setContentView(layoutResID);
		ButterKnife.bind(this);
		initViewsAndEvents();
	}

	@Override
	protected void onStart() {
		super.onStart();
		dealWithStart();
	}

	protected void initViewsAndEvents(){

		initView();
		initEvent();

	}

	/**
	 * initView
	 */
	protected abstract void initView();


	/**
	 * initEvent
	 */
	protected abstract void initEvent();

	/**
	 * 创建时进行一些与界面无关的操作
	 */
	protected abstract void dealWithCreate();

	/**
	 * 开始时的操作
	 */
	protected abstract void dealWithStart();

	/**
	 * 销毁时的操作
	 */
	protected abstract void dealWithDestroy();

	@Override
	protected void onDestroy() {
		super.onDestroy();
		dealWithDestroy();
		ButterKnife.unbind(this);
	}
}
