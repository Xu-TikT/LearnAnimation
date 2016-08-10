package com.tikt.mathmeetsanimation.ui;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.tikt.mathmeetsanimation.R;
import com.tikt.mathmeetsanimation.base.BaseAppActivity;

import butterknife.Bind;

/**
 * 显示长图，并按比例铺满屏幕
 */
public class ImgTestActivity extends BaseAppActivity {


	@Bind(R.id.id_img)
	ImageView idImg;

	@Override
	protected int getContentViewLayoutID() {
		return R.layout.activity_img_test;
	}

	@Override
	protected void initView() {

	}

	@Override
	protected void initEvent() {

		Glide.with(this).load(R.mipmap.bg).into(idImg);

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
