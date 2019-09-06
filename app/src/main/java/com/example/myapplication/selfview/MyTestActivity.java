/*
package com.example.myapplication.selfview;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.example.myapplication.R;

public class MyTestActivity extends AppCompatActivity {

    private float startX;
    private float startY;
    private float downX;//只赋值一次
    private float downY;
    LinearLayout layout;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_test);
        layout = findViewById(R.id.test_layout);
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //1.按下记录坐标
                        downX = startX = event.getX();
                        downY = startY = event.getY();
                        Log.e("onTouchEvent","onTouchEvent-ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.e("onTouchEvent","onTouchEvent-ACTION_MOVE");
                        //2.记录结束值
                        float endX = event.getX();
                        float endY = event.getY();
                        //3.计算偏移量
                        float distanceX = endX - startX;
                        Log.e("distanceX",distanceX+"");

                        int toScrollX = (int) (v.getScrollX() - distanceX);

                        Log.e("toScrollX",toScrollX+"");


                        if (toScrollX < 0) {
                            toScrollX = 0;
                        } else if (toScrollX > menuWidth) {
                            toScrollX = menuWidth;
                        }

                        v.scrollTo(toScrollX, v.getScrollY());

                        startX = event.getX();
                        startY = event.getY();
                        //在X轴和Y轴滑动的距离
                      */
/*  float DX = Math.abs(endX-downX);
                        float DY = Math.abs(endY-downY);
                        if(DX > DY&&DX>8){
                            //水平方向滑动
                            //响应侧滑
                            //反拦截-事件给SlideLayout
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }

*//*

                        break;
                    case MotionEvent.ACTION_UP:
                        */
/*Log.e(TAG,"SlideLayout-onTouchEvent-ACTION_UP");
                        int totalScrollX = getScrollX();//偏移量
                        if(totalScrollX < menuWidth/2){
                            //关闭Menu
                            closeMenu();
                        }else{
                            //打开Menu
                            openMenu();
                        }*//*

                        break;
                }
        });}*/
