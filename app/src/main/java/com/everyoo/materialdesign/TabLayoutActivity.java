package com.everyoo.materialdesign;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.TextView;

import com.adapter.MyPagerAdapter;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class TabLayoutActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    @InjectView(R.id.tablayout)
    TabLayout tablayout;
    @InjectView(R.id.viewpager)
    ViewPager viewpager;
    private ArrayList<TextView> textViews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        ButterKnife.inject(this);

        initData();
        viewpager.setAdapter(new MyPagerAdapter(textViews));
        viewpager.addOnPageChangeListener(this);


        //将ViewPager与TabLayout关联
        tablayout.setupWithViewPager(viewpager);

        //设置指示器的颜色
        tablayout.setSelectedTabIndicatorColor(Color.GREEN);


    }

    private void initData() {
        textViews = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            TextView textView = new TextView(this);
            textView.setTextSize(30);
            textView.setGravity(Gravity.CENTER);
            textView.setText("name=" + i);
            textViews.add(textView);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 3) {
            startActivity(new Intent(TabLayoutActivity.this, FloatingActionButtonActivity.class));
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
