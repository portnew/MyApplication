package com.example.myapplication.graphics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class DrawableMainActivity extends AppCompatActivity {
    Button btn_1,btn_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawale_main);
        btn_1 = findViewById(R.id.draw_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DrawableMainActivity.this,MatrixActivity.class));
            }
        });
        btn_2 = findViewById(R.id.draw_2);
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DrawableMainActivity.this,MyViewActivity.class));
            }
        });
    }
}
