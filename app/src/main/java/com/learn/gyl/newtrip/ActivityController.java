package com.learn.gyl.newtrip;

import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/9/13.
 */
public class ActivityController {
    public static List<AppCompatActivity> list = new ArrayList<AppCompatActivity>();

    public static void addActivity(AppCompatActivity activity){
        list.add(activity);
    }

    public static void removeAcitivity(AppCompatActivity activity){
        list.remove(activity);
    }

    public static void finishAll(){
        for (AppCompatActivity activity : list){
            if (!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
