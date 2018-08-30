package com.poc.yml.newarchcomponentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by diptika.shukla on 2/8/18.
 */
public class NewEmployeeActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "Employee";

    private EditText employeeEt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_employee);
        employeeEt = findViewById(R.id.employee_et);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(employeeEt.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String employee = employeeEt.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, employee);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
