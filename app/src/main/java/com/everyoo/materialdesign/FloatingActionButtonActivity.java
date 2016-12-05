package com.everyoo.materialdesign;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class FloatingActionButtonActivity extends AppCompatActivity {

    @InjectView(R.id.floatingActionButton)
    android.support.design.widget.FloatingActionButton fActionButton;
    @InjectView(R.id.floatingActionButton2)
    android.support.design.widget.FloatingActionButton fActionButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_action_button);
        ButterKnife.inject(this);

        fActionButton2.setRippleColor(Color.GRAY);//设置按下去的波纹颜色
        //fActionButton2.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.ic_menu_add));//背景色


        fActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* Snackbar.make(fActionButton2, "你好啊", Snackbar.LENGTH_LONG)
                        .setAction("delete", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(FloatingActionButtonActivity.this, "delete", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
*/

                Snackbar snackbar = Snackbar.make(fActionButton2, "你好啊", Snackbar.LENGTH_LONG);
                snackbar.setAction("跳转", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(FloatingActionButtonActivity.this, "跳转", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(FloatingActionButtonActivity.this, NavigationViewActivity.class));
                    }
                });
                //snackbar.dismiss();
                snackbar.setActionTextColor(Color.BLUE);//设置动作字的颜色


                snackbar.show();


            }
        });


    }
}