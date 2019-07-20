package com.example.myapplication.res;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.res.menu.ContextMenuActivity;
import com.example.myapplication.res.menu.MenuActivity;

public class ResMainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res_main);
        btn1 =findViewById(R.id.btn_res_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResMainActivity.this,DrawableActivity.class);
                startActivity(intent);
            }
        });
        btn2 =findViewById(R.id.btn_res_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResMainActivity.this,StringActivity.class);
                startActivity(intent);
            }
        });
        btn3 =findViewById(R.id.btn_res_3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResMainActivity.this,LogActivity.class);
                startActivity(intent);
            }
        });
        btn4 =findViewById(R.id.btn_res_4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResMainActivity.this,ThemeActivity.class);
                startActivity(intent);
            }
        });
        btn5 = findViewById(R.id.btn_res_5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResMainActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });
        btn6 = findViewById(R.id.btn_res_6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResMainActivity.this, ContextMenuActivity.class);
                startActivity(intent);
            }
        });
    }
}
