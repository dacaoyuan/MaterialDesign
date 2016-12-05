package com.everyoo.materialdesign;

import android.animation.Animator;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageButton;

public class AnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);


        final ImageButton imageButton = (ImageButton) findViewById(R.id.img_btn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                AnimatorMaterialDesign(imageButton);
            }

        });


    }

    /**
     * 这五个参数分别是：
     * view 操作的视图
     * centerX 动画开始的中心点X
     * centerY 动画开始的中心点Y
     * startRadius 动画开始半径
     * startRadius 动画结束半径
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void AnimatorMaterialDesign(ImageButton imageButton) {
        int maxRadius = Math.max(imageButton.getWidth(), imageButton.getHeight());
        Animator animator = ViewAnimationUtils.createCircularReveal(
                imageButton,
                imageButton.getWidth() / 2,
                imageButton.getHeight() / 2,
                maxRadius,
                0);

       /* Animator animator = ViewAnimationUtils.createCircularReveal(
                imageButton,
                0,
                0,
                0,
                (float) Math.hypot(imageButton.getWidth(), imageButton.getHeight()));*/

        animator.setInterpolator(new AccelerateDecelerateInterpolator());//设置加速减速插入器
        animator.setDuration(3000);
        animator.start();
    }


}
