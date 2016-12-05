package com.everyoo.materialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.textView)
    TextView textView;
    @InjectView(R.id.edit_pho)
    TextInputEditText editPho;
    @InjectView(R.id.edit_pass)
    TextInputEditText editPass;
    @InjectView(R.id.log)
    Button log;
    @InjectView(R.id.textInputLayout)
    TextInputLayout textInputLayoutPho;
    @InjectView(R.id.textInputLayout2)
    TextInputLayout textInputLayoutPassword;
    @InjectView(R.id.activity_main)
    RelativeLayout activityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        textView.setText("MaterialDesignStyle");

        /**
         *   常用方法
         */
        textInputLayoutPho.setHint("请输入您的手机号");//setHint();设置提示语
        //textInputLayoutPho.setError("手机号错误！");//setError();设置错误显示信息
        //textInputLayoutPho.setErrorEnabled(false);//setErrorEnabled();设置错误信息是否显示。true显示，false不显示,默认 false。
        textInputLayoutPho.setCounterEnabled(true);//是否启用计数器
        textInputLayoutPho.setCounterMaxLength(11);//启用计数器时，最大字数限制（仅仅用做显示）
        //textInputLayoutPho.setHintEnabled(false);//是否启用hint动画效果,默认true


        EditText editText = textInputLayoutPho.getEditText();//得到EditText的控件实例。


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //这儿判断操作，如果输入错误可以给用户提示
                if (s.length() > 11) {
                    textInputLayoutPho.setErrorEnabled(true);
                    textInputLayoutPho.setError("您的手机号不能大于11位");
                } else {
                    textInputLayoutPho.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        textInputLayoutPassword.setHint("请输入密码");//setHint();设置提示语
        textInputLayoutPassword.setCounterEnabled(true);//是否启用计数器
        textInputLayoutPassword.setCounterMaxLength(6);//启用计数器时，最大字数限制（仅仅用做显示）


        // textInputLayoutPassword.setPasswordVisibilityToggleEnabled(false);//控制密码可见开关是否启用。默认true
        //textInputLayoutPassword.setPasswordVisibilityToggleDrawable(R.mipmap.ic_launcher);//设置密码可见开关的图标
        //textInputLayoutPassword.setPasswordVisibilityToggleTintList();//控制密码可见开关图标的颜色
        //textInputLayoutPassword.setPasswordVisibilityToggleTintMode();//控制密码可见开关图标的背景颜色混合模式
        //textInputLayoutPassword.setPasswordVisibilityToggleContentDescription();//该功能是为Talkback或其他无障碍功能提供的。


        EditText editTextPass = textInputLayoutPassword.getEditText();//得到EditText的控件实例。


        editTextPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //这儿判断操作，如果输入错误可以给用户提示
                if (s.length() < 6 && s.length() > 0) {
                    textInputLayoutPassword.setErrorEnabled(true);
                    textInputLayoutPassword.setError("您的密码不能小于6位");
                } else {
                    textInputLayoutPassword.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NavigationViewActivity.class));
            }
        });


    }
}
