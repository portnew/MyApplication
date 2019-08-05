package com.example.myapplication.animation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.example.myapplication.R;

/**
 * 欢迎界面
 */

public class WelcomeActivity extends AppCompatActivity {

    private RelativeLayout layout ;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==1){
                startActivity(new Intent(WelcomeActivity.this,GuideActivity.class));
                //关闭自己，不能回退
                finish();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        layout = findViewById(R.id.layout_welcome_root);
        showAnimation(layout);
    }
    /**
     * 显示动画
     * 旋转0-360 中心点 时间
     * 透明度 AlphaAnimation 0-1
     * 缩放 ScaleAnimation 0-1 中心点
     */
    private void showAnimation(View v){
        //旋转
        RotateAnimation rotateAnimation = new RotateAnimation(
                0,360, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(2000);
        //透明度
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        alphaAnimation.setDuration(2000);
        //缩放
        ScaleAnimation scaleAnimation = new ScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setDuration(2000);
        //创建复合动画保存
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        //显示动画
        v.startAnimation(animationSet);
        //发送延迟3s的消息
        handler.sendEmptyMessageDelayed(1,3000);
    }
}
