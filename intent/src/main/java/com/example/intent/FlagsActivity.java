package com.example.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FlagsActivity extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flags);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FlagsActivity.this,DetailActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                //不在历史栈中保留，一旦离开就关闭
                startActivity(intent);
            }
        });
    }
}
