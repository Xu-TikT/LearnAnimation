package com.tikt.mathmeetsanimation.ui.customizeView;

import android.view.View;
import android.widget.Button;

import com.tikt.mathmeetsanimation.R;
import com.tikt.mathmeetsanimation.base.BaseAppActivity;
import com.tikt.mathmeetsanimation.ui.customizeView.canvas.CanvasBasicActivity;
import com.tikt.mathmeetsanimation.ui.customizeView.canvas.CanvasRotateActivity;
import com.tikt.mathmeetsanimation.ui.customizeView.canvas.CanvasScaleActivity;
import com.tikt.mathmeetsanimation.ui.customizeView.canvas.CanvasSkewActivity;
import com.tikt.mathmeetsanimation.ui.customizeView.canvas.CanvasTranslateActivity;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * 学习Canvas
 */
public class CanvasTestActivity extends BaseAppActivity {


    @Bind(R.id.id_customizeViews_canvas_btn)
    Button idCustomizeViewsCanvasBtn;
    @Bind(R.id.id_customizeViews_pie_chart_btn)
    Button idCustomizeViewsPieChartBtn;
    @Bind(R.id.id_customizeViews_Translate_btn)
    Button idCustomizeViewsTranslateBtn;
    @Bind(R.id.id_customizeViews_Scale_btn)
    Button idCustomizeViewsScaleBtn;
    @Bind(R.id.id_customizeViews_Rotate_btn)
    Button idCustomizeViewsRotateBtn;
    @Bind(R.id.id_customizeViews_Skew_btn)
    Button idCustomizeViewsSkewBtn;

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


    @OnClick({R.id.id_customizeViews_canvas_btn, R.id.id_customizeViews_pie_chart_btn,
            R.id.id_customizeViews_Translate_btn,
            R.id.id_customizeViews_Scale_btn, R.id.id_customizeViews_Rotate_btn,
            R.id.id_customizeViews_Skew_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.id_customizeViews_canvas_btn:
                onStartActivity(CanvasBasicActivity.class);
                break;
            case R.id.id_customizeViews_pie_chart_btn:
                onStartActivity(Canvas_pie_chartActivity.class);
                break;
            case R.id.id_customizeViews_Translate_btn:
                onStartActivity(CanvasTranslateActivity.class);
                break;
            case R.id.id_customizeViews_Scale_btn:
                onStartActivity(CanvasScaleActivity.class);
                break;
            case R.id.id_customizeViews_Rotate_btn:
                onStartActivity(CanvasRotateActivity.class);
                break;
            case R.id.id_customizeViews_Skew_btn:
                onStartActivity(CanvasSkewActivity.class);
                break;
        }
    }

}
