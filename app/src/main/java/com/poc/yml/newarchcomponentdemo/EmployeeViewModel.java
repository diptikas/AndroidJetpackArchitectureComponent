package com.poc.yml.newarchcomponentdemo;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

/**
 * Created by diptika.shukla on 2/8/18.
 */
public class EmployeeViewModel extends AndroidViewModel {

    private EmployeeRepository employeeRepository;

    private LiveData<List<Employee>> allWordList;

    public EmployeeViewModel(Application application) {
        super(application);
        employeeRepository = new EmployeeRepository(application);
        allWordList = employeeRepository.getAllEmployeeList();
    }

    LiveData<List<Employee>> getAllWords() { return allWordList; }

    public void insert(Employee employee) { employeeRepository.insert(employee); }
}