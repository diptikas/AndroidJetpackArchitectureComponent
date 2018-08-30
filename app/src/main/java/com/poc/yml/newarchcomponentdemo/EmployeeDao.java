package com.poc.yml.newarchcomponentdemo;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by diptika.shukla on 2/8/18.
 */
@Dao
public interface EmployeeDao {

    @Insert
    void insert(Employee employee);

    @Query("DELETE FROM employee_table")
    void deleteAll();

    @Query("SELECT * from employee_table")
    LiveData<List<Employee>> getAllWords();
}
