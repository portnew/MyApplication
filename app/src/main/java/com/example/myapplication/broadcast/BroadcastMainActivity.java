package com.example.myapplication.broadcast;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.broadcast.offline.LoginActivity;

public class BroadcastMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast_main);
        Button btn1 = findViewById(R.id.btn_broadcast_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BroadcastMainActivity.this,LocalActivity.class);
                startActivity(intent);
            }
        });
        Button btn2 = findViewById(R.id.btn_broadcast_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BroadcastMainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
