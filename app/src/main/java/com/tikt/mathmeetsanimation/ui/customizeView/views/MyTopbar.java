package com.tikt.mathmeetsanimation.ui.customizeView.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tikt.mathmeetsanimation.R;

/**
 * Created by tikt on 17-11-22.
 *
 */

public class MyTopbar extends RelativeLayout{

    private Context context;

    private int attrs;
    private int mLeftTextColor;
    private Drawable mLeftBackground;
    private String mLeftText;
    private int mRightTextColor;
    private Drawable mRightBackground;
    private String mRightText;
    private float mTitleTextSize;
    private int mTitleTextColor;
    private String mTitle;
    private TextView mTitleView;
    private Button mLeftBtn;
    private Button mRightBtn;
    private RelativeLayout.LayoutParams mLeftParams;
    private RelativeLayout.LayoutParams mRightParams;
    private RelativeLayout.LayoutParams mTitleParams;

    public MyTopbar(Context context) {
        super(context);
    }

    public MyTopbar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
    }

    public MyTopbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private void init(){
        //系统提供了TypedArrary来获取自定义属性集
        //通过这个方法，将在attrs.xml中定义的declare-styleable
        //的所有属性的值存储到TypedArrary中
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        //从Typed中取出对应的值来为要设置的属性赋值
        mLeftTextColor = ta.getColor(R.styleable.TopBar_leftTextColor,0);
        mLeftBackground = ta.getDrawable(R.styleable.TopBar_leftBackground);
        mLeftText = ta.getString(R.styleable.TopBar_leftText);
        mRightTextColor = ta.getColor(R.styleable.TopBar_rightTextColor,0);
        mRightBackground = ta.getDrawable(R.styleable.TopBar_rightBackground);
        mRightText = ta.getString(R.styleable.TopBar_rightText);
        mTitleTextSize = ta.getDimension(R.styleable.TopBar_titleTextSize,10);
        mTitleTextColor = ta.getColor(R.styleable.TopBar_titleTextColor,0);
        mTitle = ta.getString(R.styleable.TopBar_title);
        //获取完TypedArrary的值后，一般要调用
        //recycle 方法来完成资源的回收,避免重新创建的时候的错误
        ta.recycle();

//        initView();
    }

    private void initView(){
        mLeftBtn = new Button(context);
        mRightBtn = new Button(context);
        mTitleView = new TextView(context);

        //为创建的组件元素赋值
        //值就来源于attrs.xml文件中给对应属性的赋值
        mLeftBtn.setTextColor(mLeftTextColor);
        mLeftBtn.setBackgroundDrawable(mLeftBackground);
        mLeftBtn.setText(mLeftText);
        mLeftBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null!=mListener){
                    mListener.leftClick();
                }
            }
        });

        mRightBtn.setTextColor(mRightTextColor);
        mRightBtn.setBackgroundDrawable(mRightBackground);
        mRightBtn.setText(mRightText);
        mRightBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null!=mListener){
                    mListener.rightClick();
                }
            }
        });

        mTitleView.setText(mTitle);
        mTitleView.setTextColor(mTitleTextColor);
        mTitleView.setTextSize(mTitleTextSize);
        mTitleView.setGravity(Gravity.CENTER);

        //为组件元素设置相应的布局元素
        mLeftParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);

        //添加到viewgroup
        addView(mLeftBtn,mLeftParams);


        mRightParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);

        addView(mRightBtn,mRightParams);


        mTitleParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);

        addView(mTitleView,mTitleParams);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        initView();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        initView();
    }

    public interface topbarClickListener{
        void leftClick();
        void rightClick();
    }

    private topbarClickListener mListener;
    public void setTopbarClickListener(topbarClickListener mListener){
        this.mListener = mListener;
    }

    /**
     * 设置按钮的显示与否通过id区分按钮，flag区分是否显示
     * @param id
     * @param flag
     */
    public void setButtonVisable(int id,boolean flag){
        if(flag){
            if(id==0){
                mLeftBtn.setVisibility(VISIBLE);
            }else{
                mRightBtn.setVisibility(VISIBLE);

            }
        }else{
            if(id==0){
                mLeftBtn.setVisibility(GONE);
            }else{
                mRightBtn.setVisibility(GONE);

            }
        }

    }
}
