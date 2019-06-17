package com.example.myapplication.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class HorizontalRecyclerViewActivity extends AppCompatActivity {
    List<String> list = new ArrayList<>();
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_recycler_view);

        recyclerView = findViewById(R.id.recycler_horizontal);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        initList();

        recyclerView.setAdapter(new HorizontalAdapter(list, new HorizontalAdapter.onItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(HorizontalRecyclerViewActivity.this,"达达"+pos,Toast.LENGTH_SHORT).show();

            }
        }));
    }
    void initList(){
        for (int i=0;i<30;i++){
            list.add("hello"+i);
        }

    }
}
