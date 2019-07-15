package com.example.myapplication.lbs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class LBSMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lbsmain);
        Button btn = findViewById(R.id.btn_baidu_map);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LBSMainActivity.this,BaiduActivity.class);
                startActivity(intent);
            }
        });
        Button btn2 = findViewById(R.id.btn_gaode_map);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LBSMainActivity.this,GaodeActivity.class);
                startActivity(intent);
            }
        });
    }
}
