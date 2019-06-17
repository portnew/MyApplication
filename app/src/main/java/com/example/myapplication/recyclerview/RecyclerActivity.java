package com.example.myapplication.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class RecyclerActivity extends AppCompatActivity {

    private Button btn_linear,btn_horizontal,btn_grid,btn_stagger,btn_viewholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        btn_linear = findViewById(R.id.btn_linear);
        btn_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerActivity.this,LinearRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        btn_horizontal = findViewById(R.id.btn_horizontal);
        btn_horizontal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerActivity.this,HorizontalRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        btn_grid = findViewById(R.id.btn_grid);
        btn_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerActivity.this,GridRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        btn_stagger = findViewById(R.id.btn_stagger);
        btn_stagger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerActivity.this,StaggerActivity.class);
                startActivity(intent);
            }
        });
        btn_viewholder = findViewById(R.id.btn_viewholder);
        btn_viewholder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerActivity.this,StaggerActivity.class);
                startActivity(intent);
            }
        });
    }
}
