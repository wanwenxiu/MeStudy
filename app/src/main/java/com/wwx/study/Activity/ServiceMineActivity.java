package com.wwx.study.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.ecloud.pulltozoomview.PullToZoomScrollViewEx;
import com.wwx.study.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：wwx on 2017/5/2 0002 11:53
 * 邮箱：wanwenxiu0709@foxmail.com
 * 描述：
 */

public class ServiceMineActivity extends ActionBarActivity {


    @BindView(R.id.mine_scrollView)
    PullToZoomScrollViewEx mineScrollView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_activty_mine_layout);
        ButterKnife.bind(this);

        loadViewForCode();

        mineScrollView.getPullRootView().findViewById(R.id.tv_test1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("geek", "onClick -->");
            }
        });

        mineScrollView.getPullRootView().findViewById(R.id.tv_test2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("geek", "onClick -->");
            }
        });

        mineScrollView.getPullRootView().findViewById(R.id.tv_test3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("geek", "onClick -->");
            }
        });
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenWidth = localDisplayMetrics.widthPixels;
        LinearLayout.LayoutParams localObject = new LinearLayout.LayoutParams(mScreenWidth, (int) (9.0F * (mScreenWidth / 16.0F)));
        mineScrollView.setHeaderLayoutParams(localObject);
    }


    /**
     * 加载头部布局
     */
    private void loadViewForCode() {
        View headView = LayoutInflater.from(this).inflate(R.layout.profile_head_view, null, false);
        View zoomView = LayoutInflater.from(this).inflate(R.layout.profile_zoom_view, null, false);
        View contentView = LayoutInflater.from(this).inflate(R.layout.profile_content_view, null, false);
        mineScrollView.setHeaderView(headView);
        mineScrollView.setZoomView(zoomView);
        mineScrollView.setScrollContentView(contentView);
    }

}
