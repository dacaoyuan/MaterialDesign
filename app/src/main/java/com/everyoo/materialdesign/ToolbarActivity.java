package com.everyoo.materialdesign;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //透明状态栏效果
        /*if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);

        }*/

        //setContentView(R.layout.activity_toolbar);
        setContentView(R.layout.activity_toolbar1);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        //toolbar.setSubtitle("这里是子标题");
        //toolbar.setLogo(R.mipmap.bg_personal_center_number);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        //ab.setHomeAsUpIndicator(R.mipmap.bg_personal_center_number);
        ab.setDisplayHomeAsUpEnabled(true);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToolbarActivity.this, "Toolbar", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ToolbarActivity.this, TabLayoutActivity.class));
            }
        });

    }


    /**
     * 在创建选项菜单
     *
     * @param menu
     * @return
     */
  /*  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/


    /**
     * 在选择项选择
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
