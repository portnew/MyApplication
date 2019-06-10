package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView iv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
//        iv2 = findViewById(R.id.iv_1);
//        //使用Glide库加载网络图片
//        Glide.with(this).load("http://goo.gl/gEgYUd").into(iv2);
    }

}
