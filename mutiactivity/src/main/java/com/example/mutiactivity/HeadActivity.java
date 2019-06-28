package com.example.mutiactivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * @date 2019-5-15
 */
public class HeadActivity extends AppCompatActivity {

    private int[] pics = new int[]{
            R.drawable.re1,
            R.drawable.re2,
            R.drawable.re3,
            R.drawable.re4,
            R.drawable.re5,
            R.drawable.re6,
            R.drawable.re7,
            R.drawable.re8,
            R.drawable.re9,
            R.drawable.re10,
            R.drawable.re11,


    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);

        GridView gridView = findViewById(R.id.gridview);


        gridView.setAdapter(new ImageAdapter(this));
        //为Item注册点击事件
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
    public class ImageAdapter extends BaseAdapter{

        private Context context;
        public ImageAdapter(Context context){
            this.context = context;
        }
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
            if (view == null) {
                imageView = new ImageView(context);
                //imageView.setLayoutParams(new GridView.LayoutParams(200,200));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            }else{
                imageView = (ImageView) view;
            }
            imageView.setImageResource(pics[i]);
            return imageView;
        }
    }
}
