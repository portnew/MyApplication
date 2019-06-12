package com.example.myapplication.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myapplication.R;

public class LinearRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView rvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);
        rvMain = findViewById(R.id.recycler_main);
        rvMain.setLayoutManager(new LinearLayoutManager(LinearRecyclerViewActivity.this));
//        rvMain.setAdapter();
    }
}
