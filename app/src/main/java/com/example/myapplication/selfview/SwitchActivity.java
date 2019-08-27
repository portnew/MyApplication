package com.example.myapplication.selfview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.selfview.myview.MyToggleButton;
import com.example.myapplication.utils.ToastUtils;

public class SwitchActivity extends AppCompatActivity {

    MyToggleButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        button = findViewById(R.id.switch_button);
        /**
         * 这里设置点击事件会覆盖控件本身的点击事件
         */
        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!button.isState()){
                    ToastUtils.showMsg(getApplicationContext(),"关闭");
                }else {
                    ToastUtils.showMsg(getApplicationContext(),"打开");
                }
            }
        });*/


    }
}
