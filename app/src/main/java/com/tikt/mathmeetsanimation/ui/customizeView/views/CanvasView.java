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
 * Created by tikt on 17-11-23.
 *
 */

public class CanvasView extends View {

    private Paint mPaint;
    private Paint mPaint1;




    public CanvasView(Context context) {
        super(context);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private void initPaint(){
        mPaint = new Paint();
        mPaint1 = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.FILL);//设置画笔模式为填充
        mPaint.setStrokeWidth(10f);//设置画笔宽度为10px
        mPaint1.setColor(Color.YELLOW);
        mPaint1.setStyle(Paint.Style.FILL);//设置画笔模式为填充
        mPaint1.setStrokeWidth(10f);//设置画笔宽度为10px
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(measureWidth(widthMeasureSpec),measureHeight(heightMeasureSpec));
    }

    private int measureHeight(int heightMeasureSpec) {

        int result = 0;
        int specMode = MeasureSpec.getMode(heightMeasureSpec);
        int specSize = MeasureSpec.getSize(heightMeasureSpec);

        if(specMode == MeasureSpec.EXACTLY){
            result = specSize;
        }else{
            result = 200;
            if(specMode == MeasureSpec.AT_MOST){
                result = Math.min(result,specSize);
            }
        }

        return result;
    }

    private int measureWidth(int widthMeasureSpec) {
        int result = 0;
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);

        if(specMode == MeasureSpec.EXACTLY){
            result = specSize;
        }else{
            result = 200;
            if(specMode == MeasureSpec.AT_MOST){
                result = Math.min(result,specSize);
            }
        }

        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        /**
         * 画点
         */
        canvas.drawPoint(200,200,mPaint);//在坐标(200,200)位置绘制一个点
        canvas.drawPoints(new float[]{
                500,500,
                500,600,
                500,700
        },mPaint);          //绘制一组点，坐标位置由float数组指定

        /**
         * 画线
         */
        canvas.drawLine(300,300,400,600,mPaint);//在坐标(300,300)(400,600)之间绘制一条直线
        canvas.drawLines(new float[]{100,200,300,300,100,300,200,300},mPaint);//绘制一组线，每四个数字(两个点的坐标)确定一条线

        /**
         * 画矩形
         */
        //第一种
        canvas.drawRect(100,700,500,1000,mPaint);
        //第二种
//        Rect rect = new Rect(100,100,800,400);//Ract是int,RactF是浮点型
//        canvas.drawRect(rect,mPaint);
        //第三种
//        RectF rectF = new RectF(100,100,800,400);
//        canvas.drawRect(rectF,mPaint);

        /**
         * 绘制圆角矩形
         *
         */
        //第一种
        RectF rectF1 = new RectF(100,1100,500,1400);
        canvas.drawRoundRect(rectF1,30,30,mPaint);
        //第二种,api21以上才能使用
//        canvas.drawRoundRect(100,100,800,400,30,30,mPaint);

        /**
         *  圆角矩形比矩形多了两个参数 rx,ry
         *  210对应rx ,160对应ry
         *  圆角矩形的角实际上不是正圆的圆弧，而是椭圆的圆弧，rx,ry是椭圆的两个半径
         *  当rx,ry各自大于对应的宽高的一半时，圆角矩形就变成了椭圆
         *
         *  实际上在rx为宽度的一半，ry为高度的一半时，刚好是一个椭圆，
         *  通过上面我们分析的原理推算一下就能得到，
         *  而当rx大于宽度的一半，ry大于高度的一半时，实际上是无法计算出圆弧的，
         *  所以drawRoundRect对大于该数值的参数进行了限制(修正)，凡是大于一半的参数均按照一半来处理。
         *
         */
        RectF rectF2 = new RectF(100,1100,500,1400);
        canvas.drawRoundRect(rectF2,210,160,mPaint1);


        /**
         * 绘制椭圆
         * 椭圆只需要一个矩形作为参数
         * 绘制椭圆实际上就是绘制一个矩形的内切图形
         * 如果你传递进来的是一个长宽相等的矩形(即正方形)，那么绘制出来的实际上就是一个圆。
         */
        //第一种
        RectF rectF = new RectF(100,1500,500,1800);
        canvas.drawOval(rectF,mPaint);
        //第二种,需要api21以上
//        canvas.drawOval(100,1500,500,1800,mPaint);

        /**
         * 绘制圆
         * 绘制圆形有四个参数，前两个是圆心坐标，第三个是半径，最后一个是画笔。
         */
        canvas.drawCircle(500,2300,400,mPaint1);// 绘制一个圆心坐标在(500,2300)，半径为400 的圆

        /**
         * 绘制圆弧
         * 相比于绘制椭圆，绘制圆弧还多了三个参数：
         * startAngle  // 开始角度
         * sweepAngle  // 扫过角度
         * useCenter   // 是否使用中心
         */

        RectF rectF3 = new RectF(100,100,800,400);
        canvas.drawArc(rectF3,0,90,false,mPaint1);

        RectF rectF4 = new RectF(10,600,800,900);
        canvas.drawArc(rectF4,0,90,true,mPaint1);

        //相比于使用椭圆，我们还是使用正圆比较多的
        RectF rectF5 = new RectF(100,100,600,600);
        canvas.drawArc(rectF5,0,90,true,mPaint);
        canvas.drawArc(rectF5,0,90,false,mPaint1);




    }
}
