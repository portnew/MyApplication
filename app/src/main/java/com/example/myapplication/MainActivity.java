package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.broadcast.BroadcastMainActivity;
import com.example.myapplication.data.DataMainActivity;
import com.example.myapplication.dialog.DialogActivity;
import com.example.myapplication.event.EventMainActivity;
import com.example.myapplication.gesture.GestureMainActivity;
import com.example.myapplication.gridview.GridViewActivity;
import com.example.myapplication.handler.HandlerActivity;
import com.example.myapplication.lbs.LBSMainActivity;
import com.example.myapplication.listview.ListViewActivity;
import com.example.myapplication.material.MaterialMainActivity;
import com.example.myapplication.media.MediaMainActivity;
import com.example.myapplication.network.NetworkMainActivity;
import com.example.myapplication.notification.NotiMainActivity;
import com.example.myapplication.permission.PermissionMainActivity;
import com.example.myapplication.recyclerview.RecyclerActivity;
import com.example.myapplication.res.ResMainActivity;
import com.example.myapplication.service.ServiceMainActivity;

public class MainActivity extends AppCompatActivity {
    private Button button_1, button_2, button_3, button_4, button_5, button_6, button_7,
            button_8, button_10, button_11, button_12, button_13, button_14,button_15,
            button_16,button_17,button_18,button_19,button_20,button_21,button_22,
            button_23,button_24,button_25,button_26,button_27;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button_1 = findViewById(R.id.btn_1);
        button_2 = findViewById(R.id.btn_2);
        button_3 = findViewById(R.id.btn_3);
        button_4 = findViewById(R.id.btn_4);
        button_5 = findViewById(R.id.btn_5);
        button_6 = findViewById(R.id.btn_6);
        button_7 = findViewById(R.id.btn_7);
        button_8 = findViewById(R.id.btn_8);
        button_10 = findViewById(R.id.btn_10);
        button_11 = findViewById(R.id.btn_11);
        button_12 = findViewById(R.id.btn_12);
        button_13 = findViewById(R.id.btn_13);
        button_14 = findViewById(R.id.btn_14);
        button_15 = findViewById(R.id.btn_15);
        button_16 = findViewById(R.id.btn_16);
        button_17 = findViewById(R.id.btn_17);
        button_18 = findViewById(R.id.btn_18);
        button_19 = findViewById(R.id.btn_19);
        button_20 = findViewById(R.id.btn_20);

        button_21 = findViewById(R.id.btn_21);
        button_22 = findViewById(R.id.btn_22);
        button_23 = findViewById(R.id.btn_23);
        button_24 = findViewById(R.id.btn_24);
        button_25 = findViewById(R.id.btn_25);
        button_26 = findViewById(R.id.btn_26);
        button_27 = findViewById(R.id.btn_27);








        setListeners();

        /*button_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SharedActivity.this,ButtonActivity.class);
                startActivity(intent);
            }
        });
        button_2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SharedActivity.this,EditTextActivity.class);
                startActivity(intent);
            }
        });
        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SharedActivity.this,RadioButtonActivity.class);
                startActivity(intent);
            }
        });*/

    }

    private void setListeners() {
        OnClick onClick = new OnClick();
        button_1.setOnClickListener(onClick);
        button_2.setOnClickListener(onClick);
        button_3.setOnClickListener(onClick);
        button_4.setOnClickListener(onClick);
        button_5.setOnClickListener(onClick);
        button_6.setOnClickListener(onClick);
        button_7.setOnClickListener(onClick);
        button_8.setOnClickListener(onClick);
        button_10.setOnClickListener(onClick);
        button_11.setOnClickListener(onClick);
        button_12.setOnClickListener(onClick);
        button_13.setOnClickListener(onClick);
        button_14.setOnClickListener(onClick);
        button_15.setOnClickListener(onClick);
        button_16.setOnClickListener(onClick);
        button_17.setOnClickListener(onClick);
        button_18.setOnClickListener(onClick);
        button_19.setOnClickListener(onClick);
        button_20.setOnClickListener(onClick);
        button_21.setOnClickListener(onClick);
        button_22.setOnClickListener(onClick);
        button_23.setOnClickListener(onClick);
        button_24.setOnClickListener(onClick);
        button_25.setOnClickListener(onClick);
        button_26.setOnClickListener(onClick);
        button_27.setOnClickListener(onClick);




    }

    public class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_1:
                    intent = new Intent(MainActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_2:
                    intent = new Intent(MainActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_3:
                    intent = new Intent(MainActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_4:
                    intent = new Intent(MainActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn_5:
                    intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse("http://www.baidu.com"));
                    break;
                case R.id.btn_6:
                    intent = new Intent(MainActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_7:
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_8:
                    intent = new Intent(MainActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_10:
                    intent = new Intent(MainActivity.this, RecyclerActivity.class);
                    break;
                case R.id.btn_11:
                    intent = new Intent(MainActivity.this, WebViewActivity.class);
                    break;
                case R.id.btn_12:
                    intent = new Intent(MainActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_13:
                    intent = new Intent(MainActivity.this, DialogActivity.class);
                    break;
                case R.id.btn_14:
                    intent = new Intent(MainActivity.this, EventMainActivity.class);
                    break;
                case R.id.btn_15:
                    intent = new Intent(MainActivity.this, PopActivity.class);
                    break;
                case R.id.btn_16:
                    intent = new Intent(MainActivity.this, HandlerActivity.class);
                    break;
                case R.id.btn_17:
                    intent = new Intent(MainActivity.this, DataMainActivity.class);
                    break;
                case R.id.btn_18:
                    intent = new Intent(MainActivity.this, GestureMainActivity.class);
                    break;
                case R.id.btn_19:
                    intent = new Intent(MainActivity.this, ResMainActivity.class);
                    break;
                case R.id.btn_20:
                    intent = new Intent(MainActivity.this, PermissionMainActivity.class);
                    break;
                case R.id.btn_21:
                    intent = new Intent(MainActivity.this, BroadcastMainActivity.class);
                    break;
                case R.id.btn_22:
                    intent = new Intent(MainActivity.this, NotiMainActivity.class);
                    break;
                case R.id.btn_23:
                    intent = new Intent(MainActivity.this, MediaMainActivity.class);
                    break;
                case R.id.btn_24:
                    intent = new Intent(MainActivity.this, NetworkMainActivity.class);
                    break;
                case R.id.btn_25:
                    intent = new Intent(MainActivity.this, ServiceMainActivity.class);
                    break;
                case R.id.btn_26:
                    intent = new Intent(MainActivity.this, LBSMainActivity.class);
                    break;
                case R.id.btn_27:
                    intent = new Intent(MainActivity.this, MaterialMainActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //为菜单注册事件
        int id = item.getItemId();
        switch (id) {
            case R.id.action_settings:
                Toast.makeText(this, "You click settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You click remove", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
