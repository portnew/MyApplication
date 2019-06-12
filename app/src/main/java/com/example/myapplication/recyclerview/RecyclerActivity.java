package com.example.myapplication.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class RecyclerActivity extends AppCompatActivity {

    private Button btn_linear;

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
    }
}
