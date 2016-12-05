package com.everyoo.materialdesign;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class NavigationViewActivity extends AppCompatActivity {
    private static final String TAG = "NavigationViewActivity";
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_view);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.id_nv_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.mipmap.bg_personal_center_number);
        ab.setDisplayHomeAsUpEnabled(true);

        setupDrawerContent(mNavigationView);


    }

    private void setupDrawerContent(NavigationView mNavigationView) {

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                System.out.println("NavigationViewActivity.onNavigationItemSelected");
                Log.i(TAG, "onNavigationItemSelected:  item.getItemId()= " + item.getItemId());
                Log.i(TAG, "onNavigationItemSelected:  item.toString()= " + item.toString());

                Log.i(TAG, "onNavigationItemSelected:  item.getTitle()= " + item.getTitle());
                Log.i(TAG, "onNavigationItemSelected:  item.getSubMenu()= " + item.getSubMenu());
                Log.i(TAG, "onNavigationItemSelected:  item.getGroupId()= " + item.getGroupId());

                Log.i(TAG, "onNavigationItemSelected:  item.getIcon()= " + item.getIcon());
                Log.i(TAG, "onNavigationItemSelected:  item.getTitleCondensed()= " + item.getTitleCondensed());

                if (!TextUtils.isEmpty(item.getTitle()) && item.getTitle().equals("ToolBar")) {
                    startActivity(new Intent(NavigationViewActivity.this, ToolbarActivity.class));
                    item.setChecked(true);
                    //item.setIcon(R.mipmap.bg_personal_center_number);
                }
                if (!TextUtils.isEmpty(item.getTitle()) && item.getTitle().equals("TabLayout")) {
                    startActivity(new Intent(NavigationViewActivity.this, TabLayoutActivity.class));
                    item.setChecked(true);
                    //item.setIcon(R.mipmap.bg_personal_center_number);
                }
                if (!TextUtils.isEmpty(item.getTitle()) && item.getTitle().equals("FloatingActionButton")) {
                    startActivity(new Intent(NavigationViewActivity.this, FloatingActionButtonActivity.class));
                    item.setChecked(true);
                    //item.setIcon(R.mipmap.bg_personal_center_number);
                }

                if (!TextUtils.isEmpty(item.getTitle()) && item.getTitle().equals("Animation")) {
                    startActivity(new Intent(NavigationViewActivity.this, AnimationActivity.class));
                    item.setChecked(true);
                    //item.setIcon(R.mipmap.bg_personal_center_number);
                }


                item.setChecked(true);
                // mDrawerLayout.closeDrawers();//关闭所有当前打开抽屉视图
                return true;
            }
        });
    }

    /**
     * 在创建选项菜单
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_drawer, menu);
        return true;
    }


    /**
     * 在选择项选择
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
