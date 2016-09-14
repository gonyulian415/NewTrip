package com.learn.gyl.newtrip.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.learn.gyl.newtrip.bean.Person;

import java.sql.SQLException;

/**
 * Created by admin on 2016/9/14.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
    private static final String DATABASE_NAME = "superhammer.db";
    private static final int DATABASE_VERSION = 1;
    private static DatabaseHelper databaseHelper;
    private static Dao dao = null;

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            //初始化的建表操作
            TableUtils.createTable(connectionSource,Person.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            //数据库升级时销毁所有表,再进行初始化操作
            TableUtils.dropTable(connectionSource,Person.class,true);
            onCreate(database, connectionSource);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized DatabaseHelper getDatabaseHelper(Context context){
        context = context.getApplicationContext();
        if (databaseHelper == null){
            synchronized (DatabaseHelper.class){
                if (databaseHelper == null){
                    databaseHelper = new DatabaseHelper(context);
                }
            }
        }
        return databaseHelper;
    }

    public synchronized Dao getDao(Class clazz){
        if (dao == null){
            try {
                dao = super.getDao(clazz);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return dao;
    }

    @Override
    public void close() {
        super.close();
        dao = null;
    }
}
