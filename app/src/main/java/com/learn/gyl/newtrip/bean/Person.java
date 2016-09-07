package com.learn.gyl.newtrip.bean;

import cn.bmob.v3.BmobObject;

/**
 * Created by admin on 2016/9/7.
 */
public class Person extends BmobObject{
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
