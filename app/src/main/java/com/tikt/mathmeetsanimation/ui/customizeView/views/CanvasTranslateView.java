package com.tikt.mathmeetsanimation.ui.customizeView.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by tikt on 17-12-1.
 * 画布位移
 */

public class CanvasTranslateView extends View {

    private Paint mPaint = new Paint();

    public CanvasTranslateView(Context context) {
//        super(context);
        this(context,null);
    }

    public CanvasTranslateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }


    public CanvasTranslateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initPaint() {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**
         * translate是坐标系的移动，可以为图形绘制选择一个合适的坐标系。
         * 请注意，位移是基于当前位置移动，而不是每次基于屏幕左上角的(0,0)点移动
         * 我们首先将坐标系移动一段距离绘制一个圆形，之后再移动一段距离绘制一个圆形，两次移动是可叠加的。
         *
         */

        //在坐标原点绘制一个黑色的圆形
        mPaint.setColor(Color.BLACK);
        canvas.translate(200,200);
        canvas.drawCircle(0,0,100,mPaint);

        //在坐标原点绘制一个蓝色圆形
        mPaint.setColor(Color.BLUE);
        canvas.translate(200,200);
        canvas.drawCircle(0,0,100,mPaint);


    }
}
