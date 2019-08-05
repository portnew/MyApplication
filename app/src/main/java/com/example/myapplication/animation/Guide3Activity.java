package com.example.myapplication.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class Guide3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide3);
    }
    public void confirm(View v){
        startActivity(new Intent(Guide3Activity.this,MainActivity.class));
        overridePendingTransition(R.anim.up,R.anim.dismiss);
    }
    public void pre(View v){
        finish();
        overridePendingTransition(R.anim.left_in,R.anim.right_out);

    }
}
