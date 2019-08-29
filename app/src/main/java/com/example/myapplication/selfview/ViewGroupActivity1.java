package com.example.myapplication.selfview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.myapplication.R;
import com.example.myapplication.selfview.myview.MyViewPager;

public class ViewGroupActivity1 extends Activity {

    MyViewPager myViewPager;
    RadioGroup radioGroup;
    private int[] ids = {
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a3,
            R.drawable.a4,
            R.drawable.a5,
            R.drawable.a6,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //隐藏标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_group1);

        myViewPager = findViewById(R.id.my_viewpager);
        radioGroup = findViewById(R.id.radio_group);
        for (int i = 0;i<ids.length;i++){
            ImageView imageView = new ImageView(this);
//            imageView.setImageResource(ids[i]);
            imageView.setBackgroundResource(ids[i]);
            myViewPager.addView(imageView);
        }

        for (int i=0;i<myViewPager.getChildCount();i++){
            RadioButton button = new RadioButton(this);
            button.setId(i);
            if (i==0){
                button.setChecked(true);
            }
            radioGroup.addView(button);
        }
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                myViewPager.scrollToPage(checkedId);
            }
        });

        //页面滑动的时候，radiobutton也切换
        myViewPager.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                int i = myViewPager.getCurrentIndex();
                radioGroup.check(i);
            }
        });
    }
}
