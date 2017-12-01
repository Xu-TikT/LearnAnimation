package com.tikt.mathmeetsanimation.ui.customizeView.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by tikt on 17-12-1.
 * 画布缩放
 * 缩放的中心默认为坐标原点,而缩放中心轴就是坐标轴
 * 缩放提供了两个方法:
 * 1、public void scale (float sx, float sy)
 * 2、public final void scale (float sx, float sy, float px, float py)
 * 前两个参数是相同的分别为x轴和y轴的缩放比例。而第二种方法比前一种多了两个参数，用来控制缩放中心位置的。
 *
 * 当缩放比例为负数的时候会根据缩放中心轴进行翻转:
 * canvas.scale(-0.5f,-0.5f) 该方法就会以原点为中心进行翻转
 * canvas.scale(-0.5f,-0.5f,200,0)该方法又将缩放中心向右偏移了200个单位
 *
 * 和位移(translate)一样，缩放也是可以叠加的。
 *
 */

public class CanvasScaleView extends View {

    private Paint mPaint = new Paint();

    public CanvasScaleView(Context context) {
//        super(context);
        this(context,null);
    }

    public CanvasScaleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public CanvasScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initPaint() {
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(canvas.getWidth()/2,canvas.getHeight()/2);

        RectF rectF = new RectF(-400,-400,400,400);//矩形绘制

        mPaint.setColor(Color.BLACK);

        for (int i=0; i<=20; i++)
        {
            canvas.scale(0.9f,0.9f);
            canvas.drawRect(rectF,mPaint);
        }
    }
}
