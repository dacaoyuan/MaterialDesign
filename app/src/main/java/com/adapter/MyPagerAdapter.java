package com.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016-12-4.
 */

public class MyPagerAdapter extends PagerAdapter {

    ArrayList<TextView> textViews;


    public MyPagerAdapter(ArrayList<TextView> textViews) {
        this.textViews = textViews;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return textViews.get(position).getText();
    }

    @Override
    public int getCount() {
        return textViews.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(textViews.get(position));
        return textViews.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(((View) object));
    }
}
