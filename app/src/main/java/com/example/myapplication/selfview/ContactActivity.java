package com.example.myapplication.selfview;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.selfview.entity.Person;
import com.example.myapplication.selfview.myview.IndexView;
import com.example.myapplication.utils.ToastUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

    private ArrayList<Person> persons;
    ListView listView;
    TextView bigLetter;
    IndexView indexView;
    Handler handler;
    private IndexAdapter adapter;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        listView = findViewById(R.id.lv_contact);
        bigLetter = findViewById(R.id.tv_letter);
        indexView = findViewById(R.id.index_view);
        handler = new Handler();
        initData();
        adapter = new IndexAdapter();
        listView.setAdapter(adapter);


        indexView.setOnLetterChangeListener(new IndexView.OnLetterChangeListener() {
            @Override
            public void OnLetterChange(String letter) {

                update(letter);
                updateListView(letter);

            }
        });
    }

    private void updateListView(String word) {
        for(int i=0;i<persons.size();i++){
            String listWord = persons.get(i).getPinyin().substring(0,1);//YANGGUANGFU-->Y
            if (word.equals(listWord)) {
                //i是listView中的位置
                listView.setSelection(i);//定位到ListVeiw中的某个位置
                return;
            }
        }
    }

    class IndexAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return persons.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if(convertView ==null){
                convertView = View.inflate(ContactActivity.this,R.layout.item_contact,null);
                viewHolder = new ViewHolder();
                viewHolder.tv_pinyin =  convertView.findViewById(R.id.tv_pinyin);
                viewHolder.tv_name =  convertView.findViewById(R.id.tv_name);
                convertView.setTag(viewHolder);
            }else{
                viewHolder = (ViewHolder) convertView.getTag();
            }

            String name = persons.get(position).getName();//阿福
            String letter = persons.get(position).getPinyin().substring(0,1);//AFU->A
            viewHolder.tv_pinyin.setText(letter);
            viewHolder.tv_name.setText(name);
            if(position ==0){
                viewHolder.tv_pinyin.setVisibility(View.VISIBLE);
            }else{
                //得到前一个位置对应的字母，如果当前的字母和上一个相同，隐藏；否则就显示
                String preWord = persons.get(position-1).getPinyin().substring(0,1);//A~Z
                if(letter.equals(preWord)){
                    viewHolder.tv_pinyin.setVisibility(View.GONE);
                }else{
                    viewHolder.tv_pinyin.setVisibility(View.VISIBLE);
                }


            }


            return convertView;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


    }
    static class ViewHolder{
        TextView tv_pinyin;
        TextView tv_name;
    }


    private void update(String letter) {
        bigLetter.setVisibility(View.VISIBLE);
        bigLetter.setText(letter);

        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(new Runnable() {//还是在主线程中
            @Override
            public void run() {
                bigLetter.setVisibility(View.INVISIBLE);
            }
        }, 500);
    }

    /**
     * 初始化数据
     */
    private void initData() {

        persons = new ArrayList<>();
        persons.add(new Person("张晓飞"));
        persons.add(new Person("杨光福"));
        persons.add(new Person("胡继群"));
        persons.add(new Person("刘畅"));
        persons.add(new Person("崔晓飞"));
        persons.add(new Person("崔器"));
        persons.add(new Person("懂杰"));
        persons.add(new Person("冯远征"));

        persons.add(new Person("钟泽兴"));
        persons.add(new Person("尹革新"));
        persons.add(new Person("安传鑫"));
        persons.add(new Person("张骞壬"));

        persons.add(new Person("温松"));
        persons.add(new Person("李凤秋"));
        persons.add(new Person("刘甫"));
        persons.add(new Person("娄全超"));
        persons.add(new Person("张猛"));

        persons.add(new Person("王英杰"));
        persons.add(new Person("李振南"));
        persons.add(new Person("孙仁政"));
        persons.add(new Person("唐春雷"));
        persons.add(new Person("牛鹏伟"));
        persons.add(new Person("姜宇航"));

        persons.add(new Person("刘挺"));
        persons.add(new Person("张洪瑞"));
        persons.add(new Person("张建忠"));
        persons.add(new Person("侯亚帅"));
        persons.add(new Person("刘帅"));

        persons.add(new Person("乔竞飞"));
        persons.add(new Person("徐雨健"));
        persons.add(new Person("吴亮"));
        persons.add(new Person("王兆霖"));

        persons.add(new Person("阿三"));
        persons.add(new Person("李博俊"));

        persons.add(new Person("蔡如梦"));
        persons.add(new Person("徐方"));
        persons.add(new Person("DDC"));


    //排序
        Collections.sort(persons, new Comparator<Person>() {
        @Override
        public int compare(Person lhs, Person rhs) {
            return lhs.getPinyin().compareTo(rhs.getPinyin());
        }
    });

}


}
