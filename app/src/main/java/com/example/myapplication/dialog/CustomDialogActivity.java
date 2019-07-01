package com.example.myapplication.dialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class CustomDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
        Button button = findViewById(R.id.btn_test);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog dialog = new MyDialog(CustomDialogActivity.this);
                dialog.setTitle("请选择").setMsg("确定删除吗？").setCancle("取消", new MyDialog.MyOnCancelListener() {
                    @Override
                    public void OnCancel(MyDialog dialog) {
                        dialog.dismiss();
                    }
                }).setConfirm("确定", new MyDialog.MyOnConfirmListener() {
                    @Override
                    public void OnConfirm(MyDialog dialog) {
                        dialog.dismiss();
                    }
                }).show();
            }
        });
    }
}
