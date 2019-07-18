package com.example.myapplication.material;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CardViewActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private Fruit[] fruits = {
            new Fruit("Apple", R.drawable.re1),
            new Fruit("Banana", R.drawable.re2),
            new Fruit("Orange", R.drawable.re3),
            new Fruit("Pear", R.drawable.re4),
            new Fruit("Grape", R.drawable.re5),
            new Fruit("Strawberry", R.drawable.re6),
            new Fruit("Cherry", R.drawable.re7),
            new Fruit("Mango", R.drawable.re8),
    };
    private List<Fruit> fruitList = new ArrayList<>();
    private FruitAdapter adapter;
    private SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        initFruits();
        RecyclerView recyclerView = findViewById(R.id.recycler_view_card);
        GridLayoutManager manager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);
        adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
        swipe = findViewById(R.id.swipe);
        swipe.setColorSchemeResources(R.color.colorPrimary);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshFruits();
            }
        });

        Toolbar toolbar = findViewById(R.id.drawer_tool_bar_4);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout_4);
        NavigationView navigationView = findViewById(R.id.nav_view_4);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
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
        FloatingActionButton fab = findViewById(R.id.floating_btn_4);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ToastUtils.showMsg(getApplicationContext(),"FloatingActionButton clicked");
                Snackbar.make(v, "Data deleted", Snackbar.LENGTH_SHORT)
                        .setAction("Undo", new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                ToastUtils.showMsg(getApplicationContext(), "Data restored");
                            }
                        }).show();
            }
        });
    }
    private void initFruits(){
        fruitList.clear();
        for (int i=0;i<50;i++){
            Random random = new Random();
            int index = random.nextInt(fruits.length);
            fruitList.add(fruits[index]);
        }
    }
    private void refreshFruits(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initFruits();
                        adapter.notifyDataSetChanged();
                        swipe.setRefreshing(false);
                    }
                });
            }
        }).start();
    }





}
