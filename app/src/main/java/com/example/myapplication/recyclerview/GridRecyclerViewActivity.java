package com.example.myapplication.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class GridRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView gridRecyclerView;
    List<String> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_recycler_view);
        initList();
        gridRecyclerView = findViewById(R.id.rv_grid);
        gridRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        gridRecyclerView.setAdapter(new GridAdapter(list, new GridAdapter.onItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(GridRecyclerViewActivity.this,"达达"+pos,Toast.LENGTH_SHORT).show();

            }
        }));
    }
    void initList(){
        for (int i=0;i<50;i++){
            list.add("hello"+i);
        }

    }
}
