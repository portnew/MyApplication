package com.example.myapplication.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.myapplication.R;
import com.example.myapplication.animation.utils.Rotate3dAnimation;

public class Rotation3DActivity extends AppCompatActivity {

    private int mCenterX;
    private int mCenterY;
    private int depthZ = 400;
    private int duration = 600;
    private boolean isOpen = false;

    private FrameLayout mContent;
    private LinearLayout mLayoutChatRoom;
    private LinearLayout mLayoutCircle;
    private Button mBtn;
    private Button mBtn1;
    private Rotate3dAnimation mOpenFlipAnimation;
    private Rotate3dAnimation mCloseFlipAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation3_d);
        mContent = (FrameLayout) findViewById(R.id.content);
        mLayoutChatRoom = (LinearLayout) findViewById(R.id.layout_chat_room);
        mLayoutCircle = (LinearLayout) findViewById(R.id.layout_circle);
        mBtn = (Button) findViewById(R.id.btn);
        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Rotation3DActivity.this, Rotate3DTwoActivity.class));
            }
        });

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //以旋转对象的中心点为旋转中心点，这里主要不要再onCreate方法中获取，因为视图初始绘制时，获取的宽高为0
                mCenterX = mContent.getWidth() / 2;
                mCenterY = mContent.getHeight() / 2;
                if (mOpenFlipAnimation == null) {
                    Rotation3DActivity.this.initOpenAnim();
                    Rotation3DActivity.this.initCloseAnim();
                }

                //用作判断当前点击事件发生时动画是否正在执行
                if (mOpenFlipAnimation.hasStarted() && !mOpenFlipAnimation.hasEnded()) {
                    return;
                }
                if (mCloseFlipAnimation.hasStarted() && !mCloseFlipAnimation.hasEnded()) {
                    return;
                }

                //判断动画执行
                if (isOpen) {
                    mContent.startAnimation(mCloseFlipAnimation);
                } else {
                    mContent.startAnimation(mOpenFlipAnimation);
                }


                isOpen = !isOpen;
                mBtn.setText(isOpen ? "关闭" : "打开");

            }
        });
    }


    private void initOpenAnim() {
        mOpenFlipAnimation = new Rotate3dAnimation(0, 90, mCenterX, mCenterY, depthZ, true);
        mOpenFlipAnimation.setDuration(duration);
        mOpenFlipAnimation.setFillAfter(true);
        mOpenFlipAnimation.setInterpolator(new AccelerateInterpolator());
        mOpenFlipAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mLayoutChatRoom.setVisibility(View.GONE);
                mLayoutCircle.setVisibility(View.VISIBLE);

                //从270到360度，顺时针旋转视图，此时reverse参数为false，达到360度动画结束时视图变得可见
                Rotate3dAnimation rotateAnimation = new Rotate3dAnimation(270, 360, mCenterX, mCenterY, depthZ, false);
                rotateAnimation.setDuration(duration);
                rotateAnimation.setFillAfter(true);
                rotateAnimation.setInterpolator(new DecelerateInterpolator());
                mContent.startAnimation(rotateAnimation);
            }
        });
    }
    /**
     * 卡牌文本介绍关闭效果：旋转角度与打开时逆行即可
     */
    private void initCloseAnim() {
        mCloseFlipAnimation = new Rotate3dAnimation(360, 270, mCenterX, mCenterY, depthZ, true);
        mCloseFlipAnimation.setDuration(duration);
        mCloseFlipAnimation.setFillAfter(true);
        mCloseFlipAnimation.setInterpolator(new AccelerateInterpolator());
        mCloseFlipAnimation.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mLayoutChatRoom.setVisibility(View.VISIBLE);
                mLayoutCircle.setVisibility(View.GONE);

                Rotate3dAnimation rotateAnimation = new Rotate3dAnimation(90, 0, mCenterX, mCenterY, depthZ, false);
                rotateAnimation.setDuration(duration);
                rotateAnimation.setFillAfter(true);
                rotateAnimation.setInterpolator(new DecelerateInterpolator());
                mContent.startAnimation(rotateAnimation);
            }
        });
    }

}
