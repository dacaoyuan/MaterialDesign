package com.everyoo.materialdesign;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * 效果还不错，感觉还是不如这个开源底部导航栏好一些
 * http://blog.csdn.net/qq_16131393/article/details/51419901
 */
public class BottomNavigationViewActivity extends AppCompatActivity {

    @InjectView(R.id.nav_tv)
    TextView navTv;
    @InjectView(R.id.bottom_nav)
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_view);
        ButterKnife.inject(this);

        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.bottom_nav_ui:
                        navTv.setText(item.getTitle());
                        break;
                    case R.id.bottom_nav_data:
                        navTv.setText(item.getTitle());
                        break;
                    case R.id.bottom_nav_service:
                        navTv.setText(item.getTitle());
                        break;
                    case R.id.bottom_nav_net:
                        navTv.setText(item.getTitle());
                        break;
                    case R.id.bottom_nav_media:
                        navTv.setText(item.getTitle());
                        break;
                }
                return true;
            }
        });
    }
}
