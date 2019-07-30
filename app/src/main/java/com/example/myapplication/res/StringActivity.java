package com.example.myapplication.res;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myapplication.R;

public class StringActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string);

        TextView textView1 = findViewById(R.id.res_textview_1);
        textView1.setText(getResources().getString(R.string.myname));
       // textView1.setTextColor(getResources().getColor(R.color.red));
        textView1.setTextColor(getColor(R.color.red));
        textView1.setTextSize(getResources().getDimension(R.dimen.font));

        String[] arr = getResources().getStringArray(R.array.array);

    }
}
