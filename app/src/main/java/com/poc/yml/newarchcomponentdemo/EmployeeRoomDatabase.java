package com.poc.yml.newarchcomponentdemo;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

/**
 * Created by diptika.shukla on 2/8/18.
 */
@Database(entities = {Employee.class}, version = 1)
public abstract class EmployeeRoomDatabase extends RoomDatabase {

    public abstract EmployeeDao wordDao();

    private static EmployeeRoomDatabase INSTANCE;


    static EmployeeRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (EmployeeRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            EmployeeRoomDatabase.class, "word_database")
                            .build();

                }
            }
        }
        return INSTANCE;
    }


}
