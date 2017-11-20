package com.tikt.mathmeetsanimation.ui.customizeView;

import android.os.Bundle;
import android.widget.Button;

import com.tikt.mathmeetsanimation.R;
import com.tikt.mathmeetsanimation.base.BaseAppActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 学习自定义view的主界面
 */
public class CustomizeViewsActivity extends BaseAppActivity {


    @Bind(R.id.id_customizeViews_textview_1_btn)
    Button idCustomizeViewsTextview1Btn;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_customize_views;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.id_customizeViews_textview_1_btn)
    public void onViewClicked() {
        onStartActivity(TextView_1_Activity.class);

    }
}
