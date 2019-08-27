package com.example.myapplication.selfview.myview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.myapplication.R;

public class MyToggleButton extends View {
    private Bitmap back;
    private Bitmap slide;
    //能滑动的最大距离
    private int slideLeftMax;
    private int slideLeft;
    private Paint paint;
    /**
     * 记录开关的状态
     * false为关，默认也为关
     */
    boolean state = false;
    private float startX;
    private float rawX;
    /**
     * 点击事件是否执行
     * true 点击执行。滑动不执行
     * false 点击不执行，滑动执行
     */
    boolean EnableClick = true;

    public boolean isState() {
        return state;
    }

    //构造方法
    public MyToggleButton(Context context) {
        super(context);
    }

    public MyToggleButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        back = BitmapFactory.decodeResource(getResources(), R.drawable.switch_background);
        slide = BitmapFactory.decodeResource(getResources(), R.drawable.slide_button);
        slideLeftMax = back.getWidth() - slide.getWidth();
        paint = new Paint();
        paint.setAntiAlias(true);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("onClick","onClick");
                //注册的点击事件在onTouchEvent之后执行，所以可以在onTouchEvent里对点击事件的可用性做出改变

                if (EnableClick) {
                    state = !state;
                    flushView();
                }
            }
        });
    }

    //抽取的公用方法，刷新视图
    private void flushView() {
        if (state) {
            slideLeft = slideLeftMax;
        } else {
            slideLeft = 0;
        }
        invalidate();//重新执行onDraw（）
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(back.getWidth(), back.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(back, 0, 0, paint);
        canvas.drawBitmap(slide, slideLeft, 0, paint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        Log.e("onTouchEvent","onTouchEvent");
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                rawX = startX = event.getX();
                EnableClick = true;//变更状态
                break;
            case MotionEvent.ACTION_MOVE:
                float endX = event.getX();
                float dX = endX - startX;
                slideLeft += dX;
                if (slideLeft > slideLeftMax) {
                    slideLeft = slideLeftMax;
                }
                if (slideLeft < 0) {
                    slideLeft = 0;
                }
                invalidate();//刷新
                startX = event.getX();

                if (Math.abs(endX - rawX) > 5) {
                    EnableClick = false;
                }
                break;
            case MotionEvent.ACTION_UP:
                if (!EnableClick) {
                    if (slideLeft >= slideLeftMax / 2) {
                        state = true;
                    } else if (slideLeft < slideLeftMax / 2) {
                        state = false;
                    }
                    flushView();
                }
                break;
        }
        return true;
    }
}
