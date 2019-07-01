package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class PopActivity extends AppCompatActivity {
    Button button ;
    PopupWindow pop ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        button = findViewById(R.id.pop);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = getLayoutInflater().inflate(R.layout.layout_pop, null);
                pop = new PopupWindow(view,button.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                pop.setFocusable(true);
                pop.setOutsideTouchable(true);
                pop.showAsDropDown(button);
                //pop.showAtLocation();

            }
        });
    }
}
