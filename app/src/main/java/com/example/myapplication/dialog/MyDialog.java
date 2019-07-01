package com.example.myapplication.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class MyDialog extends Dialog implements View.OnClickListener {
    TextView tv_title, tv_msg;
    Button btn_cancle, btn_confirm;
    String title, msg, cancle, confirm;

    private MyOnCancelListener cancelListener;
    private MyOnConfirmListener confirmListener;


    public MyDialog(@NonNull Context context) {
        super(context);
    }

    public MyDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);
        //设置宽度
        WindowManager manager = getWindow().getWindowManager();
        Display display = manager.getDefaultDisplay();
        WindowManager.LayoutParams params = getWindow().getAttributes();
        Point size = new Point();
        display.getSize(size);
        params.width = (int) (size.x*0.8);
        getWindow().setAttributes(params);
        //设置宽度结束 设置为屏幕的80%


        tv_title = findViewById(R.id.textview_dialog_title);
        tv_msg = findViewById(R.id.textview_dialog_msg);
        btn_cancle = findViewById(R.id.btn_cancel);
        btn_confirm = findViewById(R.id.btn_confirm);

        if (!TextUtils.isEmpty(title)) {
            tv_title.setText(title);
        }
        if (!TextUtils.isEmpty(msg)) {
            tv_msg.setText(msg);
        }
        if (!TextUtils.isEmpty(cancle)) {
            btn_cancle.setText(cancle);
        }
        if (!TextUtils.isEmpty(confirm)) {
            btn_confirm.setText(confirm);
        }

        btn_confirm.setOnClickListener(this);
        btn_cancle.setOnClickListener(this);


    }

    public MyDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public MyDialog setMsg(String msg) {
        this.msg = msg;
        return this;

    }

    public MyDialog setCancle(String cancle, MyOnCancelListener listener) {
        this.cancle = cancle;
        this.cancelListener = listener;
        return this;

    }

    public MyDialog setConfirm(String confirm, MyOnConfirmListener listener) {
        this.confirm = confirm;
        this.confirmListener = listener;
        return this;

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cancel:
                if (cancelListener != null) {
                    cancelListener.OnCancel(this);
                }
                break;
            case R.id.btn_confirm:
                if (confirmListener != null) {
                    confirmListener.OnConfirm(this);
                }
                break;
        }
    }

    public interface MyOnCancelListener {
        void OnCancel(MyDialog dialog);
    }

    public interface MyOnConfirmListener {
        void OnConfirm(MyDialog dialog);
    }
}
