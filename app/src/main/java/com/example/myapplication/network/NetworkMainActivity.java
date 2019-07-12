package com.example.myapplication.network;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class NetworkMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_main);
        Button button1 = findViewById(R.id.btn_HttpURLConnection);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NetworkMainActivity.this,UrlActivity.class);
                startActivity(intent);
            }
        });
        Button button2 = findViewById(R.id.btn_HttpURLConnection);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NetworkMainActivity.this,OkHttpActivity.class);
                startActivity(intent);
            }
        });
    }
}
