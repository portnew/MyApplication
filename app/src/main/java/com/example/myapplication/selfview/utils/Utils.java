package com.example.myapplication.selfview.utils;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

public  class Utils {

   public static void Hidden(View view){

       Hidden(view,0);
   }
    public static void Hidden(View view,long i){

        RotateAnimation anim = new RotateAnimation(0,180f,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,1f);
        anim.setDuration(1500);
        anim.setFillAfter(true);
        anim.setStartOffset(i);//延迟动画
        view.startAnimation(anim);
//       view.setVisibility(View.INVISIBLE);
    }
    public static void Show(View view){

        RotateAnimation anim = new RotateAnimation(180,360,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,1f);
        anim.setDuration(1500);
        view.startAnimation(anim);
        anim.setFillAfter(true);
//        view.setVisibility(View.VISIBLE);
    }
}
