package com.example.myapplication.recyclerview;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class LinearRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView rvMain;
    List<String> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);
        initList();
        rvMain = findViewById(R.id.recycler_main);
        rvMain.setLayoutManager(new LinearLayoutManager(LinearRecyclerViewActivity.this));
        LinearAdapter adapter = new LinearAdapter(list, new LinearAdapter.onItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(LinearRecyclerViewActivity.this,"达达"+pos,Toast.LENGTH_SHORT).show();
            }
        });
        rvMain.addItemDecoration(new MyDecoration());
        rvMain.setAdapter(adapter);

    }
    void initList(){
        for (int i=0;i<30;i++){
            list.add("hello"+i);
        }

    }
    //自定义itemDecoration 添加下划线
    //下划线的颜色是背景的颜色，是recyclerview的背景，不是item 的背景，二者需要不一样才能显示
    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,getResources().getDimensionPixelOffset(R.dimen.divider));
        }
    }
}
