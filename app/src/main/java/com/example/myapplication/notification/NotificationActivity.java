package com.example.myapplication.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

import java.io.File;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        Button btn1 = findViewById(R.id.btn_send_noti);
        btn1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                NotificationChannel channel = new NotificationChannel("CHANNEL1","MY_NOTICE",NotificationManager.IMPORTANCE_HIGH);
                channel.setDescription("通知渠道");
                channel.enableLights(true);
                channel.setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Luna.ogg")),null);
                channel.enableVibration(true);
                channel.setVibrationPattern(new long[]{0,1000,1000,1000});
                channel.enableLights(true);
                channel.setLightColor(Color.RED);
                channel.setImportance(NotificationManager.IMPORTANCE_MIN);

                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                manager.createNotificationChannel(channel);

                Intent intent = new Intent(NotificationActivity.this,Noti2Activity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(NotificationActivity.this,0,intent,0);

                Notification notification = new Notification.Builder(NotificationActivity.this,"CHANNEL1")
                        .setContentTitle("天气通知")
                        .setContentText("明日有强降雨，请不要穿内裤")
                        .setWhen(System.currentTimeMillis())
                        .setCategory(Notification.CATEGORY_MESSAGE)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .setStyle(new Notification.BigTextStyle().bigText("" +
                                "明日有强降雨，请不要穿内裤，请带好浴巾洗发水出门，换洗衣物就不要带了，谢谢合作，请大家积极转发，转发者有奖，奖品为海飞丝一袋"))
                        .build();
                manager.notify(1,notification);

            }
        });
    }
}
