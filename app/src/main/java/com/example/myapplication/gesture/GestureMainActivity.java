package com.example.myapplication.gesture;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class GestureMainActivity extends AppCompatActivity {

    Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_main);
        button1 = findViewById(R.id.btn_gesture_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GestureMainActivity.this, GestureActivity.class);
                startActivity(intent);
            }
        });
        button2 = findViewById(R.id.btn_gesture_2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GestureMainActivity.this, ImageActivity.class);
                startActivity(intent);
            }
        });
    }
}
