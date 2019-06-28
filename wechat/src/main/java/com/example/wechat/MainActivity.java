package com.example.wechat;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        OnClick onClick = new OnClick();
        btn1.setOnClickListener(onClick);
        btn2.setOnClickListener(onClick);
        btn3.setOnClickListener(onClick);
        btn4.setOnClickListener(onClick);

    }
        class OnClick implements View.OnClickListener {

            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                Fragment fragment = null;
                switch (view.getId()) {
                    case R.id.btn1:
                        fragment = new Fragment_1();
                        break;
                    case R.id.btn2:
                        fragment = new Fragment_2();

                        break;
                    case R.id.btn3:
                        fragment = new Fragment_3();

                        break;
                    case R.id.btn4:
                        fragment = new Fragment_4();

                        break;

                }
                transaction.replace(R.id.fragment_base,fragment);
                transaction.commit();
            }
        }
    }

