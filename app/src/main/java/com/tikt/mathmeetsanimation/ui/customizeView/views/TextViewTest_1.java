package com.tikt.mathmeetsanimation.ui.customizeView.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by tikt on 17-11-20.
 *
 */

public class TextViewTest_1 extends AppCompatTextView {

    /*
    给TextView绘制背景
     */
    Paint mPaint1;
    Paint mPaint2;
    private int mViewWidth;
    private Paint mPaint;
    /*
    使用LinearGradient Shader和Matrix实现一个动态的文字闪动效果
     */
    private Matrix mGradientMatrix;
    private LinearGradient mLinearGradient;
    private int mTranslate;


    public TextViewTest_1(Context context) {
        super(context);

    }

    public TextViewTest_1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint1 = new Paint();
        mPaint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
        mPaint1.setStyle(Paint.Style.FILL);
        mPaint2 = new Paint();
        mPaint2.setColor(Color.YELLOW);
        mPaint2.setStyle(Paint.Style.FILL);
    }

    public TextViewTest_1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        //绘制外层矩形
        canvas.drawRect(0,0,getMeasuredWidth(),getMeasuredHeight(),mPaint1);
        //绘制内层矩形
        canvas.drawRect(10,10,getMeasuredWidth()-10,getMeasuredHeight()-10,mPaint2);
        canvas.save();
        //绘制文字前平移10像素
        canvas.translate(10,10);
        //父类完成的方法，即绘制文本
        super.onDraw(canvas);
        canvas.restore();

        /**
         * 最关键的就是使用getPaint()方法获取当前绘制TextView的Paint对象，
         * 并给Paint对象设置原生TextView没有的LinearGradient属性。
         * 之后通过矩阵的方式来不断平移渐变效果，从而在绘制文字时产生动态的闪动效果。
         */

        if(mGradientMatrix != null){
            mTranslate += mViewWidth/5;
            if(mTranslate >2*mViewWidth){
                mTranslate =- mViewWidth;
            }
            mGradientMatrix.setTranslate(mTranslate,0);
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            postInvalidateDelayed(50);


        }




    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if(mViewWidth==0){
            mViewWidth = getMeasuredWidth();
            if(mViewWidth>0){
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(0,0,mViewWidth,0,
                        new int[]{Color.BLUE,0xffffffff,Color.BLUE},null, Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();
            }
        }













    }
}
