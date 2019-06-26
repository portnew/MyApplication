package com.example.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.myapplication.utils.ToastUtils;

public class AlertDialogActivity extends AppCompatActivity {

    private Button btn1, btn2, btn3, btn4,btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        btn1 = findViewById(R.id.btn_dialog1);
        btn2 = findViewById(R.id.btn_dialog2);
        btn3 = findViewById(R.id.btn_dialog3);
        btn4 = findViewById(R.id.btn_dialog4);
        btn5 = findViewById(R.id.btn_dialog5);



        btn1.setOnClickListener(new OnClick());
        btn2.setOnClickListener(new OnClick());
        btn3.setOnClickListener(new OnClick());
        btn4.setOnClickListener(new OnClick());
        btn5.setOnClickListener(new OnClick());


    }

    class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_dialog1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder.setTitle("请回答")
                            .setIcon(R.drawable.user)
                            .setMessage("吃了吗？").setPositiveButton("吃了", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtils.showMsg(AlertDialogActivity.this, "好的");
                        }
                    }).setNegativeButton("没呢", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtils.showMsg(AlertDialogActivity.this, "饿死你");

                        }
                    }).show();
                    break;
                case R.id.btn_dialog2:
                    //单选
                    final String[] array = new String[]{"男", "女"};
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder1.setTitle("选择性别").setItems(array, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtils.showMsg(AlertDialogActivity.this, array[which]);

                        }
                    }).show();

                    break;
                case R.id.btn_dialog3:
                    //单选
                    final String[] array2 = new String[]{"男", "女"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder2.setTitle("选择性别").setSingleChoiceItems(array2, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtils.showMsg(AlertDialogActivity.this, array2[which]);
                            dialog.dismiss();

                        }
                    }).setCancelable(false).show();//点击旁边不会消失
                    break;
                case R.id.btn_dialog4:
                    //多选
                    final String[] array3 = new String[]{"吃", "喝", "嫖"};
                    boolean[] isSelected = new boolean[]{false, false, true};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder3.setTitle("选择爱好").setMultiChoiceItems(array3, isSelected, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtils.showMsg(AlertDialogActivity.this, array3[which]);

                        }

                    }).setPositiveButton("OK",null).show();
                    break;
                case R.id.btn_dialog5:
                    //自定义
                    final AlertDialog.Builder builder4 = new AlertDialog.Builder(AlertDialogActivity.this);
                    View view = LayoutInflater.from(AlertDialogActivity.this).inflate(R.layout.layout_dialog,null);
                    EditText username = view.findViewById(R.id.dialog_username);
                    EditText password = view.findViewById(R.id.dialog_password);
                    final Button login = view.findViewById(R.id.login);
                    ImageButton close = view.findViewById(R.id.dialog_imagebutton);
                    //注意show方法，返回的是AlertDialog对象，获取对象，便于进一步处理
                    final AlertDialog dialog = builder4.setView(view).setCancelable(false).show();
                    close.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    login.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    break;

            }

        }
    }
}
