package com.example.myapplication.material;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.myapplication.R;
import com.example.myapplication.utils.ToastUtils;

public class ToolbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar);
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.backup:
                ToastUtils.showMsg(this,"You clicked Backup");
                break;
            case R.id.delete:
                ToastUtils.showMsg(this,"You clicked Delete");
                break;
            case R.id.settings:
                ToastUtils.showMsg(this,"You clicked Settings");
                break;
        }
        return true;
    }
}
