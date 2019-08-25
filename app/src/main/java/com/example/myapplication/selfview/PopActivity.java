package com.example.myapplication.selfview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.ArrayList;


public class PopActivity extends AppCompatActivity {

    private EditText editText;
    private ImageView arrow;
    private PopupWindow pop;
    private ListView listView;
    private MyAdapter myAdapter;
    private ArrayList<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop2);
        editText = findViewById(R.id.edit_text_pop);
        arrow = findViewById(R.id.iv_down_arrow);
        listView = new ListView(this);

        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pop==null){
                    pop = new PopupWindow(PopActivity.this);
                    pop.setWidth(editText.getWidth());
                    pop.setHeight(600);
                    pop.setContentView(listView);
                    pop.setFocusable(true);
                    pop.setBackgroundDrawable(getResources().getDrawable(R.drawable.listview_background));
                }
                pop.showAsDropDown(editText,0,0);

            }
        });
        itemList = new ArrayList<>();
        for (int i=0;i<100;i++){
            itemList.add("风起川流"+i);
        }
        myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editText.setText(itemList.get(position));
                if(pop!=null&&pop.isShowing()){
                    pop.dismiss();
                    pop = null;
                }
            }

        });
    }
    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return itemList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = View.inflate(PopActivity.this,R.layout.pop_item, null);
                viewHolder = new ViewHolder();
                viewHolder.text = convertView.findViewById(R.id.text_view_middle);
                viewHolder.delete = convertView.findViewById(R.id.delete2);
                convertView.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            //根据位置得到数据
            final String msg = itemList.get(position);
            viewHolder.text.setText(msg);
            //设置删除
            viewHolder.delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //从集合中删除
                    itemList.remove(position);
                    //刷新 适配器 getCount() getView()
                    myAdapter.notifyDataSetChanged();
                }
            });
            return convertView;
        }
    }
    static class ViewHolder{
        TextView text;
        ImageView delete;
    }
 }

