package com.example.myapplication.res.menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.utils.ToastUtils;

import org.w3c.dom.Text;

public class ContextMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);
        //为文本框注册上下文菜单
        TextView textView = findViewById(R.id.text_content);
        registerForContextMenu(textView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.mymenu2,menu);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item1:
                ToastUtils.showMsg(getApplicationContext(),"已复制");
                break;
        }
        return true;
    }

}
