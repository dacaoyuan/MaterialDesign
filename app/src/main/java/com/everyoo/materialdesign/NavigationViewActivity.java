package com.everyoo.materialdesign;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class NavigationViewActivity extends AppCompatActivity {
    private static final String TAG = "NavigationViewActivity";
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //透明状态栏效果
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }


        setContentView(R.layout.activity_navigation_view);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.id_nv_menu);
        view = mNavigationView.inflateHeaderView(R.layout.header_just_username);
        TextView textViewName = (TextView) view.findViewById(R.id.id_username);
        textViewName.setText("袁培凯");


        Button openMenuBtn = (Button) findViewById(R.id.openMenu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.mipmap.bg_personal_center_number);
        ab.setDisplayHomeAsUpEnabled(true);*/


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        setupDrawerContent(mNavigationView);


        openMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                    mDrawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    mDrawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });

        mDrawerLayout.openDrawer(GravityCompat.START);


    }

    private void setupDrawerContent(NavigationView mNavigationView) {

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Log.i(TAG, "onNavigationItemSelected:  item.getTitle()= " + item.getTitle());
                Log.i(TAG, "onNavigationItemSelected:  item.getSubMenu()= " + item.getSubMenu());
                Log.i(TAG, "onNavigationItemSelected:  item.getGroupId()= " + item.getGroupId());

                Log.i(TAG, "onNavigationItemSelected:  item.getIcon()= " + item.getIcon());
                Log.i(TAG, "onNavigationItemSelected:  item.getTitleCondensed()= " + item.getTitleCondensed());

                Intent intent = null;
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        intent = new Intent(NavigationViewActivity.this, ToolbarActivity.class);
                        //item.setIcon(R.mipmap.bg_personal_center_number);
                        break;
                    case R.id.nav_tabLayout:
                        intent = new Intent(NavigationViewActivity.this, TabLayoutActivity.class);
                        //item.setIcon(R.mipmap.bg_personal_center_number);

                        break;
                    case R.id.nav_floatingActionButton:
                        intent = new Intent(NavigationViewActivity.this, TabLayoutActivity.class);
                        //item.setIcon(R.mipmap.bg_personal_center_number);

                        break;
                    case R.id.nav_BottomNavigationView:
                        intent = new Intent(NavigationViewActivity.this, BottomNavigationViewActivity.class);
                        //item.setIcon(R.mipmap.bg_personal_center_number);

                        break;
                    case R.id.nav_animation:
                        intent = new Intent(NavigationViewActivity.this, AnimationActivity.class);
                        //item.setIcon(R.mipmap.bg_personal_center_number);

                        break;
                    case R.id.sub01:
                        Log.i(TAG, "onNavigationItemSelected: sub01");
                        intent = new Intent(NavigationViewActivity.this, AnimationActivity.class);
                        break;
                    case R.id.sub02:
                        Log.i(TAG, "onNavigationItemSelected: sub02");
                        intent = new Intent(NavigationViewActivity.this, AnimationActivity.class);

                        break;

                }
                startActivity(intent);
                item.setChecked(true);
                mDrawerLayout.closeDrawers();//关闭所有当前打开抽屉视图
                return true;
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * 在创建选项菜单
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



      /*  这两个方法配合使用
      final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.mipmap.bg_personal_center_number);
        ab.setDisplayHomeAsUpEnabled(true);*/

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/


    /**
     * 在选择项选择
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
