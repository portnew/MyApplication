package com.example.tab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost = findViewById(android.R.id.tabhost);
        //初始化
        tabHost.setup();
        //加载tab布局
        LayoutInflater inflater = LayoutInflater.from(this);
        inflater.inflate(R.layout.tab1,tabHost.getTabContentView());
        inflater.inflate(R.layout.tab2,tabHost.getTabContentView());

        //将tab添加到tabhost
        tabHost.addTab(tabHost.newTabSpec("第1个").setIndicator("Today").setContent(R.id.left));
        tabHost.addTab(tabHost.newTabSpec("第2个").setIndicator("Tomorrow").setContent(R.id.right));


    }
}
