package com.tikt.mathmeetsanimation.ui.customizeView;

import android.os.Bundle;

import com.tikt.mathmeetsanimation.R;
import com.tikt.mathmeetsanimation.base.BaseAppActivity;
import com.tikt.mathmeetsanimation.ui.customizeView.views.pie_chart.Canvas_pie_chartView;
import com.tikt.mathmeetsanimation.ui.customizeView.views.pie_chart.PieData;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 使用canvas画饼状图
 */
public class Canvas_pie_chartActivity extends BaseAppActivity {


    @Bind(R.id.id_canvas_pie_chart)
    Canvas_pie_chartView idCanvasPieChart;

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_canvas_pie_chart;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initEvent() {

        ArrayList<PieData> mList = new ArrayList<>();
        PieData pieData = new PieData("test",20);
        PieData pieData1 = new PieData("test",35);
        PieData pieData2 = new PieData("test",15);
        PieData pieData3 = new PieData("test",30);
        mList.add(pieData);
        mList.add(pieData1);
        mList.add(pieData2);
        mList.add(pieData3);


        idCanvasPieChart.setStartAngle(10);

        idCanvasPieChart.setData(mList);
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
}
