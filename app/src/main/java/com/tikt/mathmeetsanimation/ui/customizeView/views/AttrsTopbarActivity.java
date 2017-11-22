package com.tikt.mathmeetsanimation.ui.customizeView.views;

import android.os.Bundle;

import com.tikt.mathmeetsanimation.R;
import com.tikt.mathmeetsanimation.base.BaseAppActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 通过attrs为一个view提供自定义属性
 * 这里以Topbar为例
 */

public class AttrsTopbarActivity extends BaseAppActivity {


    @Bind(R.id.id_attrsTopbar_view)
    MyTopbar idAttrsTopbarView;


    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_attrs_topbar;
    }

    @Override
    protected void initView() {


    }

    @Override
    protected void initEvent() {

        idAttrsTopbarView.setTopbarClickListener(new MyTopbar.topbarClickListener() {
            @Override
            public void leftClick() {
                showToast("left click");
            }

            @Override
            public void rightClick() {
                showToast("right click");

            }
        });


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
