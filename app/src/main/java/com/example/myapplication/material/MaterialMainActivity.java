package com.example.myapplication.material;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class MaterialMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_main);
        Button btn = findViewById(R.id.btn_tool_bar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MaterialMainActivity.this,ToolbarActivity.class));
            }
        });
        Button btn2 = findViewById(R.id.btn_drawer_layout);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MaterialMainActivity.this,DrawerLayoutActivity.class));
            }
        });
        Button btn3 = findViewById(R.id.btn_navigation_view);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MaterialMainActivity.this,NavigationViewActivity.class));
            }
        });
        Button btn4 = findViewById(R.id.btn_floating_button);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MaterialMainActivity.this,FloatingButtonActivity.class));
            }
        });
        Button btn5 = findViewById(R.id.btn_card_view);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MaterialMainActivity.this,CardViewActivity.class));
            }
        });
        Button btn6 = findViewById(R.id.btn_collapsing);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MaterialMainActivity.this,CollapsingActivity.class));
            }
        });
    }
}
