package com.example.myapplication.selfview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.selfview.entity.MyBean;
import com.example.myapplication.selfview.myview.SlideLayout;
import com.example.myapplication.utils.ToastUtils;

import java.util.ArrayList;


public class SlideDeleteActivity extends AppCompatActivity {

    ListView listView ;
    private ArrayList<MyBean> myBeans;
    private SlideAdapter slideAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_delete);
        listView = findViewById(R.id.lv_slide);
        //准备数据
        myBeans = new ArrayList<>();
        for (int i = 0;i<100;i++){
            MyBean bean = new MyBean("content"+i);
            myBeans.add(bean);
        }
        slideAdapter = new SlideAdapter();
        listView.setAdapter(slideAdapter);

    }
    class SlideAdapter extends BaseAdapter{


        @Override
        public int getCount() {
            return myBeans.size();
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
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView==null){
                viewHolder = new ViewHolder();
                convertView = View.inflate(getApplicationContext(),R.layout.item_main,null);
                viewHolder.content = convertView.findViewById(R.id.item_content);
                viewHolder.menu = convertView.findViewById(R.id.item_menu);
                convertView.setTag(viewHolder);

            }else{
                viewHolder = (ViewHolder) convertView.getTag();
            }
            final MyBean myBean = myBeans.get(position);
            viewHolder.content.setText(myBean.getName());
            viewHolder.content.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ToastUtils.showMsg(getApplicationContext(),myBean.getName());
                }
            });
            viewHolder.menu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SlideLayout layout = (SlideLayout) v.getParent();
                    layout.closeMenu();

                    myBeans.remove(myBean);

                    slideAdapter.notifyDataSetChanged();
                }
            });

            SlideLayout slideLayout = (SlideLayout) convertView;
            slideLayout.setOnStateChangeListenter(new MyOnStateChangeListener());

            return convertView;
        }
    }
    static class ViewHolder{
        TextView content;
        TextView menu;
    }
    private SlideLayout slideLayout;

    class MyOnStateChangeListener implements SlideLayout.OnStateChangeListenter {

        @Override
        public void onClose(SlideLayout layout) {
            if(slideLayout ==layout){
                slideLayout = null;
            }
        }

        @Override
        public void onDown(SlideLayout layout) {
            if(slideLayout != null && slideLayout!=layout){
                slideLayout.closeMenu();
            }

        }

        @Override
        public void onOpen(SlideLayout layout) {
            slideLayout = layout;
        }
    }
}

