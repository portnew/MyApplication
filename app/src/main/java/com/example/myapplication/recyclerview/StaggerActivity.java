package com.example.myapplication.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class StaggerActivity extends AppCompatActivity {

    private List<String> list = new ArrayList<>();
    private RecyclerView staggerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stagger);
        staggerView = findViewById(R.id.rv_stagger);
        staggerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        initList();
        staggerView.setAdapter(new StaggeredAdapter(list, new StaggeredAdapter.onItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(StaggerActivity.this,"达达"+pos,Toast.LENGTH_SHORT).show();

            }
        }));

    }
    void initList(){
        for (int i=0;i<20;i++){

            list.add("hello"+i);
            list.add("hello"+i+i+i+i+i+i+i+i+i+i);
        }

    }
}
