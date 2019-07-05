package com.example.myapplication.data;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.utils.ToastUtils;

public class PasswordActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private EditText usernameEdit;
    private EditText passwordEdit;
    private Button login;
    private CheckBox remember;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        usernameEdit = findViewById(R.id.et_data_1);
        passwordEdit = findViewById(R.id.et_data_1);
        remember = findViewById(R.id.checkbox_data);
        login = findViewById(R.id.btn_data_login);

        //判断是否已经登录并选择过保存密码
        boolean isRemember = preferences.getBoolean("remember_password",false);
        if (isRemember){

            String username = preferences.getString("username","");
            String password = preferences.getString("password","");
            usernameEdit.setText(username);
            passwordEdit.setText(password);
            remember.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if (username.equals("admin")&&password.equals("123456")){
                    editor = preferences.edit();
                    if (remember.isChecked()){
                        editor.putBoolean("remember_password",true);
                        editor.putString("username",username);
                        editor.putString("password",password);
                    }else{
                        editor.clear();
                    }
                    editor.apply();

                    Intent intent = new Intent(PasswordActivity.this,DataMainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    ToastUtils.showMsg(PasswordActivity.this,"username or password is invalid");
                }
            }
        });

    }
}











