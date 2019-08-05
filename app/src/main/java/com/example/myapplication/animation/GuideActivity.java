package com.example.myapplication.animation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
    }
    public void next(View v){
        startActivity(new Intent(GuideActivity.this,Guide2Activity.class));
        overridePendingTransition(R.anim.right_in,R.anim.left_out);
    }
}
