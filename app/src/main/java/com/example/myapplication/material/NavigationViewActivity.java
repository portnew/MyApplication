package com.example.myapplication.material;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.myapplication.R;

public class NavigationViewActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_view);
        Toolbar toolbar = findViewById(R.id.drawer_tool_bar_2);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout_2);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_launcher);
        }
        navigationView.setCheckedItem(R.id.nav_call);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                drawerLayout.closeDrawers();
                return true;
            }
        });



    }
}
