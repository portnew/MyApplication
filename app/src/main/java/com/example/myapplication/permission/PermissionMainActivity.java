package com.example.myapplication.permission;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class PermissionMainActivity extends AppCompatActivity {

    Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_main);

        btn1 = findViewById(R.id.btn_permission_1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PermissionMainActivity.this,PermissionActivity.class);
                startActivity(intent);
            }
        });
        btn2 = findViewById(R.id.btn_permission_2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PermissionMainActivity.this,ContactsActivity.class);
                startActivity(intent);
            }
        });
    }
}
