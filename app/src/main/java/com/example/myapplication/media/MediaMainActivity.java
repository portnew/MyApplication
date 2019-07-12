package com.example.myapplication.media;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class MediaMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_main);
        Button button = findViewById(R.id.btn_media_photo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaMainActivity.this,PhotoActivity.class);
                startActivity(intent);
            }
        });
        Button button2 = findViewById(R.id.btn_media_music);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaMainActivity.this,MediaActivity.class);
                startActivity(intent);
            }
        });
        Button button3 = findViewById(R.id.btn_media_video);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaMainActivity.this,VideoActivity.class);
                startActivity(intent);
            }
        });
    }
}
