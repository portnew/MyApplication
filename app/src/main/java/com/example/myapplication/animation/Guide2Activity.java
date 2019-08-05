package com.example.myapplication.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class Guide2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide2);
    }
    public void next(View v){
        startActivity(new Intent(Guide2Activity.this,Guide3Activity.class));
        overridePendingTransition(R.anim.right_in,R.anim.left_out);

    }
    public void pre(View v){
        finish();
        overridePendingTransition(R.anim.left_in,R.anim.right_out);
    }
}
