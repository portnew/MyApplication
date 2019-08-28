package com.example.myapplication.selfview.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.selfview.utils.MyScroller;

public class MyViewPager extends ViewGroup {
    /**
     * 手势识别器
     * 1 定义
     * 2 实例化 把想要的方法重新
     * 3 onTouchEvent（）把事件传递给手势识别器
     */
    private GestureDetector detector;
    private float startX;
    private int currentIndex;//当前位置 索引
    private MyScroller scroller;

    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        scroller = new MyScroller();
        detector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {

//                Log.e("ddddd", distanceX + "");
                //验证往左拖为正，往右为负

                //如果是首末张图片，移动幅度不要过大
                if (currentIndex==0&&distanceX<0){
                    scrollBy((int) (distanceX/6),0);
                }else if (currentIndex==getChildCount()-1&&distanceX>0){
                    scrollBy((int) (distanceX/6),0);
                }else {
                    scrollBy((int) distanceX, 0);
                }
                //scrollBy((int) distanceX, 0);
//                Log.e("CCCCCCCC",currentIndex+"");
                return true;
            }
        });
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        for (int i = 0; i < getChildCount(); i++) {
            View childView = getChildAt(i);
            childView.layout(i * getWidth(), 0, (i + 1) * getWidth(), getHeight());
        }
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        //把事件传递给手势识别器
        detector.onTouchEvent(event);
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //记录坐标
                startX = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                break;

            case MotionEvent.ACTION_UP:
                float endX = event.getX();
                int templateIndex = currentIndex;//下标位置
                if ((startX - endX) > getWidth() / 2) {
                    templateIndex++;
                } else if (endX - startX > getWidth() / 2){
                    templateIndex--;
                }
                scrollToPage(templateIndex);
                break;
        }
        return true;
    }

    /**
     * 屏蔽非法值
     * 根据位置移动
     * @param templateIndex
     */

    private void scrollToPage(int templateIndex) {
        if (templateIndex<0){
            templateIndex = 0;
        }
        if (templateIndex>getChildCount()-1){
            templateIndex = getChildCount()-1;
        }
        currentIndex = templateIndex;

        //getScrollY() 是原始值 ，此处就是0
//        scrollTo(currentIndex*getWidth(),getScrollY());
        int dX = currentIndex*getWidth()-getScrollX();
        scroller.startScroll(getScrollX(),getScrollY(),dX,0);
        invalidate();;//onDraw();computeScroll();
    }
    @Override
    public void computeScroll() {
//        super.computeScroll();
        if( scroller.cuputeScrollOffset()){

            float currX = scroller.getCurrX();

            scrollTo((int) currX,0);

            invalidate();
        };
    }
}
