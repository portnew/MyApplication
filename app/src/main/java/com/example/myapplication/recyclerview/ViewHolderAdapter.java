package com.example.myapplication.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

import java.util.List;

public class ViewHolderAdapter extends RecyclerView.Adapter<ViewHolder> {

    List<String> stringList;
    onItemClickListener listener;
    public ViewHolderAdapter(List<String> list , onItemClickListener listener){
        this.stringList = list;
        this.listener = listener;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==0){
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_linear_item,viewGroup,false);
            Viewholder1 holder = new ViewHolder1(view);

            return holder;
        }else{
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_linear_item2,viewGroup,false);
            Viewholder2 holder = new ViewHolder2(view);

            return holder;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {


        viewHolder.textView.setText(stringList.get(i));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(i);
//                Toast.makeText(v.getContext(),"达达"+i,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return stringList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position/2==0){
            return 0;
        }else {
            return 1;
        }
    }

    public interface onItemClickListener{
       void onClick(int pos);
    }




    }
    class ViewHolder2 extends ViewHolder{

        TextView textView;
        ImageView imageView;
        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view_item);
            itemView = imageView.findViewById(R.id.image);
        }
    }

    class Viewholder1 extends ViewHolder{
        TextView textView;


        public Viewholder1(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view_item);

        }
    }
}
