package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.utils.ToastUtils;

public class ToastActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        btn1 = findViewById(R.id.btn_toast_1);
        btn2 = findViewById(R.id.btn_toast_2);
        btn3 = findViewById(R.id.btn_toast_3);
        btn4 = findViewById(R.id.btn_toast_4);

        btn1.setOnClickListener(new Onclick());
        btn2.setOnClickListener(new Onclick());
        btn3.setOnClickListener(new Onclick());
        btn4.setOnClickListener(new Onclick());

    }
    class Onclick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_toast_1:
                    Toast.makeText(getApplicationContext(),"Default", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.btn_toast_2:
                    Toast toast = Toast.makeText(getApplicationContext(),"Change Position", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER,0,0);
                    toast.show();
                    break;
                case R.id.btn_toast_3:
                    Toast toast2 = new Toast(getApplicationContext());
                    LayoutInflater inflater = LayoutInflater.from(ToastActivity.this);
                    View view = inflater.inflate(R.layout.layout_toast,null);
                    ImageView imageView = view.findViewById(R.id.imageview_toast);
                    imageView.setImageResource(R.drawable.exclamation_mark);

                    TextView textView = view.findViewById(R.id.textview_toast);
                    textView.setText("警告");
                    toast2.setView(view);
                    toast2.show();
                    break;
                case R.id.btn_toast_4:
                    ToastUtils.showMsg(getApplicationContext(),"我封装了");
                    break;
            }
        }
    }
}
