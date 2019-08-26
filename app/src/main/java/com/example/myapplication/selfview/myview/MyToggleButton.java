package com.example.myapplication.selfview.myview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.myapplication.R;

public class MyToggleButton extends View {
    private Bitmap back;
    private Bitmap slide;
    private int slideLeftMax;
    private int slideLeft;
    private Paint paint;
    boolean state = false;
    public MyToggleButton(Context context) {
        super(context);
    }

    public MyToggleButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        back = BitmapFactory.decodeResource(getResources(), R.drawable.switch_background);
        slide = BitmapFactory.decodeResource(getResources(),R.drawable.slide_button);
        slideLeftMax = back.getWidth()-slide.getWidth();
        paint = new Paint();
        paint.setAntiAlias(true);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                state = !state;
                if (state){
                    slideLeft = slideLeftMax;
                }else {
                    slideLeft = 0;
                }
                invalidate();//重新执行onDraw（）

            }
        });
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(back.getWidth(),back.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(back,0,0,paint);
        canvas.drawBitmap(slide,slideLeft,0,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
