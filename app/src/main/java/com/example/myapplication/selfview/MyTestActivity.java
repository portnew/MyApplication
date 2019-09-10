package com.example.myapplication.selfview;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.myapplication.R;

public class MyTestActivity extends AppCompatActivity {

    private float startX;
    private float startY;
    private float downX;//只赋值一次
    private float downY;
    RelativeLayout layout;
    TextView tv;
    Button btn;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_test);

        layout = findViewById(R.id.test_layout);
        tv = findViewById(R.id.tv_test);
        btn = findViewById(R.id.btn_test_1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv.scrollTo(400,200);

                        System.out.println("+++++++");
                    }
                });
            }
        });

    }


    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                tv.scrollTo(400,200);

                Log.e("v.getScrollX();","down");


                break;
            case MotionEvent.ACTION_MOVE:
                float endX = event.getX();
                int scrollX = tv.getScrollX();
                Log.e("v.getScrollX();",scrollX+"");
                tv.scrollBy((int) (endX-startX),0);
                startX = event.getX();
                break;
            case MotionEvent.ACTION_POINTER_UP:
                break;
        }
        return super.onTouchEvent(event);
    }*/
}
