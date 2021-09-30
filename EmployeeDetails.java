package com.flendzzinterview.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.flendzzinterview.myapplication.domain.Employee;
import com.google.android.material.textview.MaterialTextView;

public class EmployeeDetails extends AppCompatActivity {

    private static final String TAG = EmployeeDetails.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_details);

        Employee employee = (Employee) getIntent().getSerializableExtra("employee");

        Log.i(TAG, "onCreate: "+employee.toString());
        MaterialTextView employeeId = findViewById(R.id.flendzz_activity_employee_id_materialtextview);
        employeeId.setText(String.valueOf(employee.getId()));
        MaterialTextView employeeName = findViewById(R.id.flendzz_activity_employee_name_materialtextview);
        employeeName.setText(employee.getName());
        MaterialTextView email = findViewById(R.id.flendzz_activity_employee_email_materialtextview);
        email.setText(employee.getEmail());
        MaterialTextView suite = findViewById(R.id.flendzz_activity_employee_suite_materialtextview);
        suite.setText(employee.getAddress().getSuite());
        MaterialTextView street = findViewById(R.id.flendzz_activity_employee_street_materialtextview);
        street.setText(employee.getAddress().getStreet());
        MaterialTextView city = findViewById(R.id.flendzz_activity_employee_city_materialtextview);
        city.setText(employee.getAddress().getCity());
        MaterialTextView zipcode = findViewById(R.id.flendzz_activity_employee_zipcode_materialtextview);
        zipcode.setText(employee.getAddress().getZipcode());
        MaterialTextView phone = findViewById(R.id.flendzz_activity_employee_phonenumber_materialtextview);
        phone.setText(employee.getPhone());
        MaterialTextView companyName = findViewById(R.id.flendzz_activity_companyname_materialtextview);
        companyName.setText(employee.getCompany().getName());
        MaterialTextView website = findViewById(R.id.flendzz_activity_website_materialtextview);
        website.setText(employee.getWebsite());

    }
}