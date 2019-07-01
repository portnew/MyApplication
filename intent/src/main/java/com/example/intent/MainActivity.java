package com.example.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);

        Onclick onclick = new Onclick();
        btn1.setOnClickListener(onclick);
        btn2.setOnClickListener(onclick);
        btn3.setOnClickListener(onclick);
        btn4.setOnClickListener(onclick);
        btn5.setOnClickListener(onclick);




    }
    class Onclick implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Intent intent=null;
            switch (view.getId()){
                case R.id.btn1:

                    intent = new Intent(MainActivity.this,ComponentNameActivity.class);
                    break;
                case R.id.btn2:
                    intent = new Intent(MainActivity.this,ActionActivity.class);
                    break;
                case R.id.btn3:
                    intent = new Intent(MainActivity.this,CategoryActivity.class);
                    break;
                case R.id.btn4:
                    intent = new Intent(MainActivity.this,FlagsActivity.class);
                    break;
                case R.id.btn5:
                    intent = new Intent(MainActivity.this,FilterActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}
