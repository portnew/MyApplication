package com.example.myapplication.data;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;
import com.example.myapplication.data.entity.Book;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class LitePalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_pal);
        LitePal.initialize(this);
        Button btn1 =findViewById(R.id.create_database2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector.getDatabase();
            }
        });
        Button btn2 = findViewById(R.id.add_data2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("倚天屠龙记");
                book.setAuthor("金庸");
                book.setPages(600);
                book.setPrice(16.33);
                book.setPress("中华书局");
                book.save();
            }
        });
        Button btn3 = findViewById(R.id.update_data2);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setPrice(14.95);
                book.setPress("Anchor");
                book.updateAll("name=? and author = ?","倚天屠龙记","金庸");
               /* Book book = new Book();
                book.setName("天龙八部");
                book.setAuthor("金庸");
                book.setPages(500);
                book.setPrice(60);
                book.setPress("中华书局");
                book.save();
                book.setPrice(30);
                book.save();*/
            }
        });
        Button btn4 = findViewById(R.id.delete_data2);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.deleteAll(Book.class,"price<?","15");
            }
        });
        Button btn5 = findViewById(R.id.query_data2);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> books = LitePal.findAll(Book.class);
                for (Book book:books) {
                    Log.d("LITEPAL________","book name is"+book.getName());
                    Log.d("LITEPAL________","book author is"+book.getAuthor());
                    Log.d("LITEPAL________","book pages is"+book.getPages());
                    Log.d("LITEPAL________","book price is"+book.getPrice());
                    Log.d("LITEPAL________","book press is"+book.getPress());
                }
            }
        });


    }
}
