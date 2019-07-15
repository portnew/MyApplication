package com.example.myapplication.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.myapplication.R;
import com.example.myapplication.notification.Noti2Activity;
import com.example.myapplication.notification.NotificationActivity;

import java.io.File;

public class ForeService extends Service {
    public ForeService() {
    }
    private DownloadBinder binder = new DownloadBinder();

    class DownloadBinder extends Binder {
        public void startDownload() {
            Log.d("Myservice", "-----------startDownload executed----------");

        }

        public int getProgress() {
            Log.d("Myservice", "-----------getProgress executed----------");
            return 0;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {

        super.onCreate();
        Log.d("Foreservice", "-----------onCreate executed----------");
        NotificationChannel channel = new NotificationChannel("CHANNEL1","MY_NOTICE", NotificationManager.IMPORTANCE_HIGH);
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.createNotificationChannel(channel);

        Notification notification = new Notification.Builder(this,"CHANNEL1")
                .setContentTitle("前台服务")
                .setContentText("我是服务，但是我就要在前台运行，怎么着吧")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setOngoing(true)
                .setAutoCancel(true)
                .build();
        startForeground(1,notification);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
