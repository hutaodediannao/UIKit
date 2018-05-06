package com.hutao.ui.uikit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;

/**
 * Created by 胡涛 on 2018/5/6.
 */

public class RefreshLayout extends FrameLayout{

    private View mRootView;
    private SwipeToLoadLayout mSwipeToLoadLayout;
    private RecyclerView mRecyclerView;
    private ImageView mEmptyView;

    public RefreshLayout(@NonNull Context context) {
        this(context, null);
    }

    public RefreshLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RefreshLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initConfig();
    }

    private void initConfig() {
        initView();
        setListener();
    }

    /**
     * 空View点击监听事件
     */
    private void setListener() {
        this.mEmptyView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mClickEmptyViewListener != null) mClickEmptyViewListener.clickEmptyView();
            }
        });
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getContext()).inflate(R.layout.refresh_layout, null, false);
        this.mSwipeToLoadLayout = (SwipeToLoadLayout) mRootView.findViewById(R.id.swipeToLoadLayout);
        this.mRecyclerView = (RecyclerView) mRootView.findViewById(R.id.swipe_target);
        this.mEmptyView = mRootView.findViewById(R.id.entryView);
        this.addView(mRootView);
    }

    public View getmRootView() {
        return mRootView;
    }

    public SwipeToLoadLayout getmSwipeToLoadLayout() {
        return mSwipeToLoadLayout;
    }

    public RecyclerView getmRecyclerView() {
        return mRecyclerView;
    }

    public ImageView getmEmptyView() {
        return mEmptyView;
    }

    /**
     * 是否显示空view提示
     * @param isVisibity
     */
    public void isShowEmptyView(boolean isVisibity) {
        mEmptyView.setVisibility(isVisibity?VISIBLE:GONE);
    }

    /**
     * 设置空view背景展示
     * @param resId
     */
    public void setEmptyViewSrc(int resId) {
        mEmptyView.setImageResource(resId);
    }

    public interface ClickEmptyViewListener{
        void clickEmptyView();
    }

    private ClickEmptyViewListener mClickEmptyViewListener;

    public void setmClickEmptyViewListener(ClickEmptyViewListener mClickEmptyViewListener) {
        this.mClickEmptyViewListener = mClickEmptyViewListener;
    }
}
