package com.poc.yml.newarchcomponentdemo;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by diptika.shukla on 2/8/18.
 */
public class EmployeeRepository {

    private EmployeeDao employeeDao;
    private LiveData<List<Employee>> allEmployeeList;

    EmployeeRepository(Application application) {
        EmployeeRoomDatabase db = EmployeeRoomDatabase.getDatabase(application);
        employeeDao = db.wordDao();
        allEmployeeList = employeeDao.getAllWords();
    }

    LiveData<List<Employee>> getAllEmployeeList() {
        return allEmployeeList;
    }


    public void insert (Employee employee) {
        new InsertAsyncTask(employeeDao).execute(employee);
    }

    private static class InsertAsyncTask extends AsyncTask<Employee, Void, Void> {

        private EmployeeDao asyncTaskDao;

        InsertAsyncTask(EmployeeDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Employee... params) {
            asyncTaskDao.insert(params[0]);
            return null;
        }
    }
}
