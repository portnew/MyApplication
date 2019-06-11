package com.example.myapplication.listview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.myapplication.R;

public class ListViewActivity extends AppCompatActivity {
    private ListView listView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView1 = findViewById(R.id.list_view1);
        listView1.setAdapter(new MyListAdapter(ListViewActivity.this));
    }
}
