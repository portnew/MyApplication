package com.example.myapplication.service;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class ThreadActivity extends AppCompatActivity {
    private TextView textView;
    public static final int UPDATE_TEXT = 1;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch (msg.what){
                case UPDATE_TEXT:
                    //在这里可以进行UI操作
                    textView.setText("Nice to meet you girl");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        textView = findViewById(R.id.textview_thread_1);
        Button btn = findViewById(R.id.btn_change_text);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                       Message message = new Message();
                       message.what = UPDATE_TEXT;
                       handler.sendMessage(message);
                    }
                }).start();
            }
        });
    }
}
