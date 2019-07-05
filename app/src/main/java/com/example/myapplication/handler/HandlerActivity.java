package com.example.myapplication.handler;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.utils.ToastUtils;

public class HandlerActivity extends AppCompatActivity {

    private Handler handler;
    @SuppressLint("HandlerLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        //handler = new Handler();

        //3S后跳转到MainActivity
       /* handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(HandlerActivity.this, SharedActivity.class);
                startActivity(intent);
            }
        },3000);*/

       //这里是主线程
       handler = new Handler(){
           @Override
           public void handleMessage(Message msg) {
               super.handleMessage(msg);
               switch (msg.what){
                   case 1:
                       ToastUtils.showMsg(HandlerActivity.this,"线程通信成功");
                       break;
               }

           }
       };

       //下面是一个新的线程
       new Thread(){
           @Override
           public void run() {
               super.run();
               Message message = new Message();
               message.what = 1;
               handler.sendMessage(message);
           }
       }.start();
    }


}
