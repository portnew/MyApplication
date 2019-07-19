package com.example.myapplication.material;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private Context context;
    private List<Fruit> fruits;

    //ViewHolder是一个静态内部类 处理recycler的item子项
    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = (CardView) itemView;
            fruitImage = itemView.findViewById(R.id.fruit_image);
            fruitName = itemView.findViewById(R.id.fruit_name);
        }
    }

    //构造方法，需要传入要显示的数据
    public FruitAdapter(List<Fruit> fruitList) {
        fruits = fruitList;
    }

    @NonNull
    @Override
    public FruitAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (context == null) {
            context = viewGroup.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.fruit_item, viewGroup, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = fruits.get(position);
                Intent intent = new Intent(context,CollapsingActivity.class);
                intent.putExtra(CollapsingActivity.FRUIT_NAME,fruit.getName());
                intent.putExtra(CollapsingActivity.FRUIT_IMAGE_ID,fruit.getImageId());
                context.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FruitAdapter.ViewHolder viewHolder, int i) {
        Fruit fruit = fruits.get(i);
        viewHolder.fruitName.setText(fruit.getName());
        Glide.with(context).load(fruit.getImageId()).into(viewHolder.fruitImage);
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }
}
