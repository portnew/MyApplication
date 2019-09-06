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
                        Log.e("onTouchEvent", "onTouchEvent-ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        Log.e("onTouchEvent", "onTouchEvent-ACTION_MOVE");
                        //2.记录结束值
                        float endX = event.getX();
                        //3.计算偏移量
                        float distanceX = endX - startX;
                        Log.e("distanceX=endX - startX", distanceX  + "");

                        Log.e("v.getScrollX()", v.getScrollX()  + "");
                        int toScrollX = (int) (v.getScrollX() - distanceX);

                        Log.e("toScrollX", toScrollX + "");


                        if (toScrollX < 0) {
                            toScrollX = 0;
                        } else if (toScrollX > 200) {
                            toScrollX = 200;
                        }

                        v.scrollTo(toScrollX, v.getScrollY());

                        startX = event.getX();
                        startY = event.getY();


                        break;
                    case MotionEvent.ACTION_UP:

                        break;
                }
                return true;
            }
        });
    }
}
