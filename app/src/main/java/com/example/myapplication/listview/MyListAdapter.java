package com.example.myapplication.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class MyListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater layoutInflater;

    public MyListAdapter(Context context){
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        private ImageView imageView;
        private TextView tvTitle,tvTime,tvContent;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item,null);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.image_view);
            holder.tvContent = convertView.findViewById(R.id.text_view_content);
            holder.tvTime = convertView.findViewById(R.id.text_view_time);
            holder.tvTitle = convertView.findViewById(R.id.text_view_title);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        //给控件赋值
        holder.tvTitle.setText("This is Title") ;
        holder.tvTime.setText("This is Time");
        holder.tvContent.setText("This is Content");

        return convertView;
    }
}
