package com.tikt.mathmeetsanimation.ui.customizeView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tikt.mathmeetsanimation.R;
import com.tikt.mathmeetsanimation.base.BaseAppActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 学习Canvas
 */
public class CanvasTestActivity extends BaseAppActivity {


    @Bind(R.id.id_customizeViews_canvas_btn)
    Button idCustomizeViewsCanvasBtn;
    @Bind(R.id.id_customizeViews_pie_chart_btn)
    Button idCustomizeViewsPieChartBtn;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_canvas_test;
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

    @OnClick({R.id.id_customizeViews_canvas_btn, R.id.id_customizeViews_pie_chart_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.id_customizeViews_canvas_btn:
                onStartActivity(CanvasActivity.class);
                break;
            case R.id.id_customizeViews_pie_chart_btn:
                onStartActivity(Canvas_pie_chartActivity.class);
                break;
        }
    }
}
