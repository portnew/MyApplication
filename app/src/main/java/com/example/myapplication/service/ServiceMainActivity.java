package com.example.myapplication.service;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class ServiceMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_main);
        Button btn1 = findViewById(R.id.btn_thread);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ServiceMainActivity.this,ThreadActivity.class));
            }
        });
        Button btn2 = findViewById(R.id.btn_service);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ServiceMainActivity.this,ServiceActivity.class));
            }
        });
        Button btn3 = findViewById(R.id.btn_foreservice);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ServiceMainActivity.this,ForeActivity.class));
            }
        });
        Button btn4 = findViewById(R.id.btn_intentservice);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ServiceMainActivity.this,IntentServiceActivity.class));
            }
        });
    }
}
