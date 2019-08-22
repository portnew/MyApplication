package com.example.myapplication.selfview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.myapplication.R;
import com.example.myapplication.selfview.utils.Utils;

public class YoukuActivity extends AppCompatActivity {
    ImageView icon_home;
    ImageView icon_menu;
    RelativeLayout level1;
    RelativeLayout level2;
    RelativeLayout level3;

    boolean isShowLevel3 = true;
    boolean isShowLevel2 = true;
    boolean isShowLevel1 = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youku);
        icon_home = findViewById(R.id.icon_home);
        icon_menu = findViewById(R.id.icon_menu);
        level1 = findViewById(R.id.level1);
        level2 = findViewById(R.id.level2);
        level3 = findViewById(R.id.level3);

        icon_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShowLevel2){
                    isShowLevel2 = false;
                    if (isShowLevel3){
                        isShowLevel3 = false;
                        Utils.Hidden(level2);
                        Utils.Hidden(level3,250);
                    }else{
                        Utils.Hidden(level2);
                    }

                }else {
                    isShowLevel2 = true;
                    Utils.Show(level2);
                }
            }
        });
        icon_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShowLevel3){
                    isShowLevel3 = false;
                    Utils.Hidden(level3);
                }else {
                    isShowLevel3 = true;
                    Utils.Show(level3);
                }

            }
        });

    }
}
