package com.learn.gyl.newtrip.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


/**
 * Created by admin on 2016/9/7.
 */
@DatabaseTable
public class Person{
    @DatabaseField(generatedId = true)
    int personId;
    @DatabaseField
    String name;
    @DatabaseField
    int age;

    public Person(){

    }

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

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
