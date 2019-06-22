package com.example.fragmentapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewsTitleFragment extends Fragment {

    private boolean isTwoPane;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag,container,false);

        RecyclerView newsTitleRecycler =  view.findViewById(R.id.news_title_recycler);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        newsTitleRecycler.setLayoutManager(manager);

        NewsAdapter adapter = new NewsAdapter(getNews());
        newsTitleRecycler.setAdapter(adapter);

        return view;
    }

    private  List<News> getNews(){
        List<News> list = new ArrayList<>();


        for (int i = 0;i<=50;i++){
            News news = new News();
            news.setTitle("This is news title "+i);

            String content = "this is news content "+i;
            news.setContent(content);
            list.add(news);
        }

        return list;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getActivity().findViewById(R.id.news_content)!=null){
            isTwoPane = true;//可以找到news_content布局时，为双页模式

        }else {
            isTwoPane = false;
        }
    }


    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
        private List<News> newsList;

        public NewsAdapter(List<News> newsList){
            this.newsList = newsList;
        }
        class ViewHolder extends RecyclerView.ViewHolder {
            TextView newsTitleText;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
               // newsTitleText = itemView.findViewById(R.id.news_title);
                newsTitleText = itemView.findViewById(R.id.news_title_item);
            }
        }
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                    R.layout.news_item,viewGroup,false
            );

            final ViewHolder holder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    News news = newsList.get(holder.getAdapterPosition());
                    if(isTwoPane){
                        NewsContentFragment fragment = (NewsContentFragment) getFragmentManager()
                                .findFragmentById(R.id.news_content_fragment);
                        fragment.refresh(news.getTitle(),news.getContent());
                    }else{
                        NewsContentActivity.actionStart(getActivity(),news.getTitle(),news.getContent());
                    }
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            News news = newsList.get(i);
            viewHolder.newsTitleText.setText(news.getTitle());


        }

        @Override
        public int getItemCount() {
            return newsList.size();
        }
    }



}
