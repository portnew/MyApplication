package com.example.myapplication.selfview.myview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.myapplication.R;

import java.net.InterfaceAddress;

/**
 * 快速索引
 * 绘制字母
 */
public class IndexView extends View {
    /**
     * 每个item的宽和高
     */
    private float itemWidth;
    private float itemHeight;
    private int index=-1;
    private Paint paint;
    private OnLetterChangeListener listener;

    private String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"};
    public IndexView(Context context) {
        super(context);
    }



    @SuppressLint("ResourceAsColor")
    public IndexView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(50);
        paint.setTypeface(Typeface.DEFAULT_BOLD);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //得到item的宽和高
        itemWidth = getMeasuredWidth();
        itemHeight = getMeasuredHeight()/letters.length;
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(int i=0;i<letters.length;i++){
            String letter = letters[i];

            Rect bounds = new Rect();
            paint.getTextBounds(letter,0,1,bounds);

            //计算每个文字的宽和高
            int letterWidth = bounds.width();
            int letterHeight = bounds.height();

            float letterX = itemWidth/2 - letterWidth/2;
            float letterY = itemHeight/2 + letterHeight/2 + i * itemHeight;
            //点击变色
            if (i==index){
                paint.setColor(Color.RED);
                paint.setTextSize(70);

            }else{
                paint.setColor(R.color.indexColor);
                paint.setTextSize(50);
            }

            canvas.drawText(letter,letterX,letterY,paint);
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                index = (int) (event.getY() / itemHeight);
                if (listener!=null&&index>=0&&index<=25){
                    listener.OnLetterChange(letters[index]);
                    //会去到实现方法处
                }
                break;
            case MotionEvent.ACTION_UP:
                index = -1;
                break;
        }
        invalidate();
        return true;
    }

    public interface OnLetterChangeListener{
        public void OnLetterChange(String letter);
    }
    public void setOnLetterChangeListener(OnLetterChangeListener mlistener){
        this.listener = mlistener;
    }

}
