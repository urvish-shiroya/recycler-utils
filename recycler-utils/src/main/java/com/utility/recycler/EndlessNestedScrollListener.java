package com.utility.recycler;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;

public abstract class EndlessNestedScrollListener implements NestedScrollView.OnScrollChangeListener {

    private int page = 0;
    private NestedScrollView nestedScrollView = null;

    public EndlessNestedScrollListener(NestedScrollView nestedScrollView) {
        this.nestedScrollView = nestedScrollView;
    }

    public EndlessNestedScrollListener(NestedScrollView nestedScrollView, int defaultPage) {
        this.nestedScrollView = nestedScrollView;
        this.page = defaultPage;
    }

    @Override
    public void onScrollChange(@NonNull NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

        // Check if the user has scrolled to the bottom
        View contentView = nestedScrollView.getChildAt(0);
        int contentHeight = contentView.getHeight();
        int scrollViewHeight = nestedScrollView.getHeight();
        int diff = contentHeight - scrollViewHeight - scrollY;

        if (diff <= 0 && diff < oldScrollY) {
            page++;
            loadNextPageData(page);
        }

    }


    public abstract void loadNextPageData(int page);
}
