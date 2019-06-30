package com.example.myapplication.event;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class EventMainActivity extends AppCompatActivity {

    Button btn1, btn2 ,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_main);
        btn1 = findViewById(R.id.btn_event_1);
        btn2 = findViewById(R.id.btn_event_2);
        btn3 = findViewById(R.id.btn_event_3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventMainActivity.this, EventActivity.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventMainActivity.this, LongClickActivity.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventMainActivity.this, TouchActivity.class);
                startActivity(intent);
            }
        });
    }
}
