package com.example.fragmentapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewsContentActivity extends AppCompatActivity {

    public static  void actionStart(Context context,String newsTitle,String newsContent){
        Intent intent = new Intent(context,NewsContentActivity.class);
        intent.putExtra("news_title",newsTitle);
        intent.putExtra("news_content",newsContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_content);
        //从intent里获取数据
        String newsTitle = getIntent().getStringExtra("news_title");
        String newsContent = getIntent().getStringExtra("news_content");
        //获取要填充数据的fragment
        NewsContentFragment fragment =
                (NewsContentFragment) getSupportFragmentManager().findFragmentById(R.id.news_content_for_single);
        //利用NewsContentFragment的refresh方法填充数据
        fragment.refresh(newsTitle,newsContent);


    }
}
