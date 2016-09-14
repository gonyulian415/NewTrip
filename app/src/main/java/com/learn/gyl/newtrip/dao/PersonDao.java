package com.learn.gyl.newtrip.dao;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.learn.gyl.newtrip.bean.Person;
import com.learn.gyl.newtrip.utils.DatabaseHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/9/14.
 */
public class PersonDao {
    private Context context;
    private Dao<Person,Integer> dao;
    private DatabaseHelper databaseHelper;

    public PersonDao(Context context){      //初始化Dao
        this.context = context;
        databaseHelper = DatabaseHelper.getDatabaseHelper(context);
        dao = databaseHelper.getDao(Person.class);
    }

    //以下是具体的操作
    public void addPerson(Person person){
        try {
            dao.create(person);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Person> findAllPerson(){
        List<Person> list = null;
        try {
            list = dao.queryBuilder().query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (list == null){
            list = new ArrayList<Person>();
        }
        return list;
    }
}
