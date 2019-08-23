package com.example.myapplication.selfview.utils;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

public  class Utils {

   public static void Hidden(ViewGroup view){

       Hidden(view,0);
   }
    public static void Hidden(ViewGroup view, long millis){

        RotateAnimation anim = new RotateAnimation(0,180f,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,1f);
        anim.setDuration(1000);
        anim.setFillAfter(true);
        anim.setStartOffset(millis);//延迟动画
        view.startAnimation(anim);
        //作为layout的view不可点，但其中的子view还可以点击，
        //这里要把函数的参数都设为ViewGroup
        view.setEnabled(false);
        for (int i = 0;i<view.getChildCount();i++){
            view.getChildAt(i).setEnabled(false);
        }

    }

    public static void Show(ViewGroup view){

       Show(view,0);
    }
    public static void Show(ViewGroup view,long millis){

        RotateAnimation anim = new RotateAnimation(180,360,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,1f);
        anim.setDuration(1000);
        anim.setStartOffset(millis);
        anim.setFillAfter(true);
        view.startAnimation(anim);
        view.setEnabled(true);
        for (int i = 0;i<view.getChildCount();i++){
            view.getChildAt(i).setEnabled(true);
        }
    }
}

