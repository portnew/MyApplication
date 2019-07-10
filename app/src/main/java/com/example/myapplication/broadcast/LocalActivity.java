package com.example.myapplication.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.utils.ToastUtils;

public class LocalActivity extends AppCompatActivity {
    private IntentFilter intentFilter;
    private LocalReceiver localReceiver;
    private LocalBroadcastManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);
        manager = LocalBroadcastManager.getInstance(this);//获取实例
        Button button = findViewById(R.id.btn_localbroadcast);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.myapplication.broadcast.LOCAL");
                manager.sendBroadcast(intent);
            }
        });
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.myapplication.broadcast.LOCAL");
        localReceiver = new LocalReceiver();
        manager.registerReceiver(localReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        manager.unregisterReceiver(localReceiver);
    }
    class LocalReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            ToastUtils.showMsg(context,"收到本地广播");
        }
    }
}
