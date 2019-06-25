package com.example.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.utils.ToastUtils;

public class AlertDialogActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        btn1 = findViewById(R.id.btn_dialog1);
        btn2 = findViewById(R.id.btn_dialog2);
        btn3 = findViewById(R.id.btn_dialog3);
        btn4 = findViewById(R.id.btn_dialog4);


        btn1.setOnClickListener(new OnClick());
        btn2.setOnClickListener(new OnClick());
        btn3.setOnClickListener(new OnClick());
        btn4.setOnClickListener(new OnClick());


    }

    class OnClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_dialog1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder.setTitle("请回答").setMessage("吃了吗？").setPositiveButton("吃了", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtils.showMsg(AlertDialogActivity.this,"好的");
                        }
                    }).setNegativeButton("没呢", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtils.showMsg(AlertDialogActivity.this,"饿死你");

                        }
                    }).show();
                    break;
                case R.id.btn_dialog2:
                    break;
                case R.id.btn_dialog3:
                    break;
                case R.id.btn_dialog4:
                    break;
            }
        }
    }
}
