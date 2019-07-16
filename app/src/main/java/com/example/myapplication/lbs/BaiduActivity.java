package com.example.myapplication.lbs;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.example.myapplication.R;
import com.example.myapplication.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;

public class BaiduActivity extends AppCompatActivity {
    public LocationClient client;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baidu);

        client = new LocationClient(this);
        client.registerLocationListener(new BDAbstractLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation bdLocation) {
                StringBuilder currentPosition = new StringBuilder();
                currentPosition.append("纬度：").append(bdLocation.getLatitude()).append("\n");
                currentPosition.append("经度：").append(bdLocation.getLongitude()).append("\n");
                currentPosition.append("定位方式：");
                if (bdLocation.getLocType()==BDLocation.TypeGpsLocation){
                    currentPosition.append("GPS");
                }else if(bdLocation.getLocType()==BDLocation.TypeNetWorkLocation){
                    currentPosition.append("网络");
                }
                textView.setText(currentPosition);
            }
        });
        textView = findViewById(R.id.textview_position);
        List<String> permissionList = new ArrayList<>();
        if (ContextCompat.checkSelfPermission(BaiduActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)!=
                PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(BaiduActivity.this, Manifest.permission.READ_PHONE_STATE)!=
                PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if (ContextCompat.checkSelfPermission(BaiduActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)!=
                PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (!permissionList.isEmpty()){
            String[] permissions = permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(BaiduActivity.this,permissions,1);
        }else {
            requestLocation();
        }

    }
    private void requestLocation(){
        client.start();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if (grantResults.length > 0){
                    for (int result : grantResults){
                        if (result!=PackageManager.PERMISSION_GRANTED){
                            ToastUtils.showMsg(this,"需要同意所有权限才能使用本程序");
                            finish();
                            return;
                        }
                    }
                    requestLocation();
                }else {
                    ToastUtils.showMsg(this,"发生未知错误");
                    finish();
                }
                break;
        }
    }


}












