package com.example.myapplication.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class IntentServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);

        Button button = findViewById(R.id.start_service_3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //打印主线程的id
                Log.d("MyIntentService","Thread id is"+Thread.currentThread().getId());
                Intent intentService = new Intent(IntentServiceActivity.this,MyIntentService.class);
                startService(intentService);
            }
        });
    }
}
