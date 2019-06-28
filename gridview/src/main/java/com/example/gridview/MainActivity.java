package com.example.gridview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @date 2019-5-15
 */
public class MainActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_main);

        GridView gridView = findViewById(R.id.gridview);
//        List<Map<String,Object>> list = new ArrayList<>();

       /* for (int i=0;i<pics.length;i++){
            Map<String,Object> map = new HashMap<>();
            map.put("image",pics[i]);
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                list,
                R.layout.cell,
                new String[]{"image"},
                new int[]{R.id.image}
        );
*/

        gridView.setAdapter(new ImageAdapter(this));

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
