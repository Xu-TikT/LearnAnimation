package com.tikt.mathmeetsanimation.ui.animation.frame;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.tikt.mathmeetsanimation.R;
import com.tikt.mathmeetsanimation.base.BaseAppActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Frame动画练习
 * Frame动画：包含一个接一个的将要显示的图片资源，这是一个传统的动画，它创建一个不同的图像序列，有顺序 的播放，就像一卷胶卷，我们称为帧动画。
 * Frame 动画就是一系列的图片的按照指定的顺序播放的过程，Frame动画可以被定义在XML中也可以在代码中来实现。
 * 如果定义在XML中我们可以放在res/drawable/filename.xml，
 * 如果完全由代码实现的话，就要用到AnimationDrawable对象。
 */
   /*
   1.将动画定义在XML中官网给出的定义如下：
    <?xml version="1.0" encoding="utf-8"?>
    <animation-list xmlns:android="http://schemas.android.com/apk/res/android"
        android:oneshot=["true" | "false"] >
    <item
        android:drawable="@[package:]drawable/drawable_resource_name"
        android:duration="integer" />
    </animation-list>
    */

/**
 * 标签及属性说明：
 * \<animation-list>必须元素，包含一个或多个<item>元素.
 * \<android:oneshot> boolean类型.  如果为true则动画只播放一次，如果为false则循环播放动画，如果不设置则默认为fasle.
 * \<item> 一帧动画，必须有一个<animation-list>父节点.
 * \<item>节点中的属性android:drawable此帧动画所对应的图片资源，android:duration此帧动画播放所需要的时间，单位为毫秒。
 *
 */


public class FrameAnimationActivity extends BaseAppActivity {


	@Bind(R.id.id_frameActivity_start_btn)
	Button idFrameActivityStartBtn;
	@Bind(R.id.id_frameActivity_stop_btn)
	Button idFrameActivityStopBtn;
	@Bind(R.id.id_frameActivity_animView_code)
	ImageView idFrameActivityAnimViewCode;
	@Bind(R.id.id_frameActivity_animView_xml)
	ImageView idFrameActivityAnimViewXml;

	//
	AnimationDrawable animXml;//使用xml定义的动画
	AnimationDrawable animCode;//使用代码实现的动画

	@Override
	protected int getContentViewLayoutID() {
		return R.layout.activity_frame_animation;
	}

	@Override
	protected void initView() {

	}

	@Override
	protected void initEvent() {

		idFrameActivityAnimViewXml.setBackgroundResource(R.drawable.frame);
		animXml = (AnimationDrawable) idFrameActivityAnimViewXml.getBackground();

		animCode = new AnimationDrawable();
		for (int i = 1;i<=7;i++){
			//根据资源名称和目录获取R.java中对应的资源ID
			int id = getResources().getIdentifier("v"+i,"drawable",getPackageName());
			//根据资源ID获取到 Drawable对象
			Drawable drawable = getResources().getDrawable(id,null);
			//将此帧添加到AnimationDrawable中
			animCode.addFrame(drawable,300);

		}
		//设置循环播放
		animCode.setOneShot(false);
		//设置图片的背景为我们的动画
		idFrameActivityAnimViewCode.setBackground(animCode);
		animCode.start();
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


	@OnClick({R.id.id_frameActivity_start_btn, R.id.id_frameActivity_stop_btn})
	public void onClick(View view) {
		switch (view.getId()) {
			case R.id.id_frameActivity_start_btn:
				animXml.start();
				break;
			case R.id.id_frameActivity_stop_btn:
				animXml.stop();
				break;
		}
	}
}
