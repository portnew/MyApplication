package com.example.myapplication.selfview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class MyselfActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myself);
        btn1 = findViewById(R.id.myview_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyselfActivity.this,ZoomActivity.class));
            }
        });
        btn2 = findViewById(R.id.ripple_1);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyselfActivity.this,RippleActivity.class));
            }
        });
        btn3 = findViewById(R.id.youku_menu);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyselfActivity.this,YoukuActivity.class));
            }
        });
        btn4 = findViewById(R.id.view_pager);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyselfActivity.this,ViewPagerActivity.class));
            }
        });
        btn5 = findViewById(R.id.dropdown);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyselfActivity.this,PopActivity.class));
            }
        });
        btn6 = findViewById(R.id.myswitch);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyselfActivity.this,SwitchActivity.class));
            }
        });
        btn7 = findViewById(R.id.myattr);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyselfActivity.this,MyAttrActivity.class));
            }
        });
        btn8 = findViewById(R.id.viewgroup_1);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MyselfActivity.this,ViewGroupActivity1.class));
            }
        });
    }
}
