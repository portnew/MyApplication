package com.example.myapplication.animation;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.myapplication.R;

public class CleanActivity extends AppCompatActivity {
    ImageView scanning ;
    TextView scanText;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clean);
        scanning = findViewById(R.id.image_scanning);
        scanText = findViewById(R.id.tv_scanning);
        progressBar = findViewById(R.id.progressBar2);

        showScanning();
        showProgress();
    }
    private void showScanning() {
        Animation animation = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation.setDuration(1500);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(-1);
        scanning.startAnimation(animation);
    }
    @SuppressLint("StaticFieldLeak")
    private void showProgress() {
        //启动异步任务
        new AsyncTask<Void, Void, Void>() {
            //主线程显示提示视图
            @Override
            protected void onPreExecute() {
                scanText.setText("手机杀毒引擎正在扫描...");
            }
            //分线程，做长时间的工作
            @Override
            protected Void doInBackground(Void... voids) {
                int appCount = 60;
                //设置进度条的最大值
                progressBar.setMax(appCount);
                for (int i=0;i<appCount;i++){
                    SystemClock.sleep(50);
                    //扫描完一个
                    //发布进度
                    publishProgress();
                }
                return null;
            }

            //主线程
            @Override
            protected void onProgressUpdate(Void... values) {
                progressBar.incrementProgressBy(1);
            }

            //主线程，更新界面
            @Override
            protected void onPostExecute(Void aVoid) {
                //更新文本
                scanText.setText("扫描完成，没有病毒！恭喜！");
                //停止扫描
                scanning.clearAnimation();
                //隐藏进度条
                progressBar.setVisibility(View.GONE);

            }
        }.execute();
    }


}
