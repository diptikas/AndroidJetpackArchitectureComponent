package com.poc.yml.newarchcomponentdemo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by diptika.shukla on 2/8/18.
 */
@Entity(tableName = "employee_table")
public class Employee {


    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "employee")
    private String employee;

    public Employee(String employee) {
        this.employee = employee;
    }

    @NonNull
    public String getEmployee() {
        return employee;
    }


}
