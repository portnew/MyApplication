package com.example.myapplication.broadcast.offline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.utils.ToastUtils;


public class LoginActivity extends BaseActivity {
    private EditText usernameEdit;
    private EditText passwordEdit;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameEdit = findViewById(R.id.et_offline_1);
        passwordEdit = findViewById(R.id.et_offline_2);
        login = findViewById(R.id.btn_offline_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if (username.equals("admin")&&password.equals("123456")){
                    Intent intent = new Intent(LoginActivity.this,LoginSuccessActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    ToastUtils.showMsg(LoginActivity.this,"用户名或密码错误");
                }
            }
        });
    }
}
