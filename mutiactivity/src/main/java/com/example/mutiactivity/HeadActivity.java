package com.example.mutiactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class HeadActivity extends AppCompatActivity {

    int[] pics = new int[]{
            R.drawable.boy,
            R.drawable.girl,
            R.drawable.man,
            R.drawable.user
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);
        GridView gridView = findViewById(R.id.gridview);
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return pics.length;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                ImageView imageView;
                if(view == null){
                    imageView = new ImageView(HeadActivity.this);
                   // imageView.setAdjustViewBounds(true);
//                    imageView.setMaxHeight(150);
//                    imageView.setMaxWidth(158);
//                    imageView.setPadding(5,5,5,5);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }else {
                    imageView = (ImageView) view;
                }
                return imageView;
            }
        };

        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = getIntent();
                Bundle bundle = new Bundle();
                bundle.putInt("imageId",pics[i]);
                //intent.putExtra("imageId",pics[i]);
                intent.putExtras(bundle);
                setResult(1,intent);
                finish();


            }
        });

    }
}
