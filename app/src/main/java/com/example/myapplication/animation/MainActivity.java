package com.example.myapplication.animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.utils.ToastUtils;

public class MainActivity extends AppCompatActivity {

    EditText username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        username = findViewById(R.id.et_username);
    }
    public void submit(View v){
        String string = username.getText().toString();
        Log.d("++++++",string.trim());
//        if ("".equals(string.trim())) {
            if (TextUtils.isEmpty(string)) {
            Animation shake = AnimationUtils.loadAnimation(this,R.anim.shake);
            username.startAnimation(shake);
        }else {
            ToastUtils.showMsg(this,"Submit");
        }
    }
}
