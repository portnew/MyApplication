package com.example.myapplication.graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class MyViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyView(this));
    }
    class MyView extends View{
        private ShapeDrawable shapeDrawable;
        private Paint paint;

        public MyView(Context context) {
            super(context);
            shapeDrawable = new ShapeDrawable(new OvalShape());
            shapeDrawable.getPaint().setColor(Color.RED);
            shapeDrawable.setBounds(10,10,600,300);

            paint = new Paint();
            paint.setColor(Color.BLUE);//字体颜色
            paint.setTextSize(30);//大小
            paint.setTypeface(Typeface.DEFAULT_BOLD);
            paint.setAntiAlias(true);//消除锯齿
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            //画背景
            canvas.drawColor(Color.GREEN);
            //画椭圆
            shapeDrawable.draw(canvas);
            //画文本 坐标为左下坐标
            canvas.drawText("1111",210f,210f,paint);

        }
    }
}
