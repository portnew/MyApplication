package com.example.myapplication.gesture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.myapplication.R;
import com.example.myapplication.utils.ToastUtils;

//实现接口，并实现所有方法
public class GestureActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {


    //定义一个全局的手势检测器
   private GestureDetector detector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture);

        detector = new GestureDetector(this,this);

    }

    //将触碰事件交给GestureDetector处理
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent e) {
        ToastUtils.showMsg(this,"onDown");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        ToastUtils.showMsg(this,"onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        ToastUtils.showMsg(this,"onSingleTapUp");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        ToastUtils.showMsg(this,"onScroll");

        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        ToastUtils.showMsg(this,"onLongPress");

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        ToastUtils.showMsg(this,"onFling");

        return false;
    }
}
