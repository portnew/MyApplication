package com.example.myapplication.selfview;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.utils.ToastUtils;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TextView textView;
    private LinearLayout layout;
    private ArrayList<ImageView>  list;
    //上一次高亮位置
    private int prePosition = 0;
    //ViewPager是否滚动
    private boolean isScroll = false;

    // 图片资源ID
    private final int[] imageIds = {
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e };
    // 图片标题集合
    private final String[] imageDescriptions = {
            "尚硅谷波河争霸赛！",
            "凝聚你我，放飞梦想！",
            "抱歉没座位了！",
            "7月就业名单全部曝光！",
            "平均起薪11345元"
    };
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);

            //延迟发消息
            handler.sendEmptyMessageDelayed(1, 4000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        viewPager = findViewById(R.id.viewpager);
        textView = findViewById(R.id.text_viewbottom);
        textView.setText(imageDescriptions[prePosition]);
        layout = findViewById(R.id.layout_point);


        list = new ArrayList<>();
        for(int i=0;i< imageIds.length;i++){
            ImageView imageView = new ImageView(this);
            imageView.setBackgroundResource(imageIds[i]);
            list.add(imageView);
            //添加点
            ImageView point = new ImageView(this);
            point.setBackgroundResource(R.drawable.point_selector);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20,20);
            if (i==0){
                point.setEnabled(true);
            }else{
                point.setEnabled(false);
                params.leftMargin = 8;
            }
            point.setLayoutParams(params);

            layout.addView(point);
        }
        //设置适配器
        viewPager.setAdapter(new MyPagerAdapter());
        //设置中间位置，解决从0开始无法左滑的bug
        int item = (Integer.MAX_VALUE/2-(Integer.MAX_VALUE/2)%list.size());
        viewPager.setCurrentItem(item);

        //触发消息
        handler.sendEmptyMessageDelayed(1, 4000);

        //设置监听
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /**
             *
             * @param i 当前页面的位置
             * @param v 页面滑动的百分比
             * @param i1 在屏幕上滑动的像素
             */
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            /**
             * 当页面被选中
             * @param i 被选中的页面的位置
             */
            @Override
            public void onPageSelected(int i) {
                int realPosition = i%list.size();
                layout.getChildAt(prePosition).setEnabled(false);
                layout.getChildAt(realPosition).setEnabled(true);
                textView.setText(imageDescriptions[realPosition]);
                prePosition = realPosition;

            }

            /**
             当页面滚动状态变化的时候回调这个方法
             静止->滑动
             滑动-->静止
             静止-->拖拽

             */
            @Override
            public void onPageScrollStateChanged(int i) {

                if (i == ViewPager.SCROLL_STATE_DRAGGING){
                    isScroll = true;

                }else if (i == ViewPager.SCROLL_STATE_SETTLING){

                }else if (i == ViewPager.SCROLL_STATE_IDLE&&isScroll){
                    isScroll = false;
                    handler.removeCallbacksAndMessages(null);
                    handler.sendEmptyMessageDelayed(1, 4000);
                }
            }
        });



    }
    class MyPagerAdapter extends PagerAdapter{

        @Override
        public int getCount() {

            //return list.size();
            //支持无限滑动
            return Integer.MAX_VALUE;
        }

        /**
         * 比较view和object是否同一个实例
         * @param view 页面
         * @param o 下面方法的返回值
         * @return
         */
        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return view==o;
        }

        /**
         * 实例化每一个视图
         * @param container ViewPager自身
         * @param position 当前实例化的位置
         * @return
         */
        @SuppressLint("ClickableViewAccessibility")
        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            int realPosition = position%list.size();
            ImageView imageView = list.get(realPosition);
            //设置触摸事件
            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()){
                        case MotionEvent.ACTION_DOWN:
                            handler.removeCallbacksAndMessages(null);
                            break;
                       /* case MotionEvent.ACTION_CANCEL:
                            handler.removeCallbacksAndMessages(null);
                            handler.sendEmptyMessageDelayed(1, 3000);
                            break;*/
                        case MotionEvent.ACTION_UP:
                            handler.removeCallbacksAndMessages(null);
                            handler.sendEmptyMessageDelayed(1, 3000);
                            break;
                    }
                    return true;
                }
            });
            container.addView(imageView);//添加到ViewPager中
            return imageView;
        }

        /**
         * 释放资源
         * @param container ViewPager
         * @param position 要释放的位置
         * @param object 要释放的页面
         */
        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

            container.removeView((View) object);
        }
    }
}
