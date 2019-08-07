package com.example.myapplication.graphics;

import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.myapplication.R;

public class MatrixActivity extends AppCompatActivity {

    EditText editText1,editText2,editText3,editText4;
    ImageView imageView;
    Matrix matrix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);
        editText1 = findViewById(R.id.et_draw_1);
        editText2 = findViewById(R.id.et_draw_2);
        editText3 = findViewById(R.id.et_draw_3);
        editText4 = findViewById(R.id.et_draw_4);
        imageView = findViewById(R.id.image_draw_1);
        matrix = new Matrix();

    }
    public void scaleBitmap(View view){
        float scale = Float.parseFloat(editText1.getText().toString());
        matrix.reset();
        matrix.postScale(scale,scale);
        imageView.setImageMatrix(matrix);


    }
    public void rotateBitmap(View view){
        float degrees = Float.parseFloat(editText2.getText().toString());
        matrix.reset();
        matrix.postRotate(degrees);
        imageView.setImageMatrix(matrix);

    }
    public void translateBitmap(View view){
        float translateX = Float.parseFloat(editText3.getText().toString());
        float translateY = Float.parseFloat(editText4.getText().toString());
        matrix.reset();
        matrix.postTranslate(translateX,translateY);
        imageView.setImageMatrix(matrix);


    }
    public void clearBitmap(View view){
        matrix.reset();
        imageView.setImageMatrix(matrix);

    }

}
