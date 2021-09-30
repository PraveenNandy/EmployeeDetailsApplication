package com.flendzzinterview.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.flendzzinterview.myapplication.domain.Employee;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.MyHolderView> {

    private static final String TAG = EmployeeAdapter.class.getName();

    List<Employee>employees;
    Activity mContext;

    public EmployeeAdapter(List<Employee> employees, Activity mContext) {
        this.employees = employees;
        this.mContext = mContext;
    }



    @NonNull
    @Override
    public EmployeeAdapter.MyHolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recylerview,parent,false);
        MyHolderView myHolderView = new MyHolderView(view);

        return myHolderView;
    }


    @Override
    public void onBindViewHolder(@NonNull EmployeeAdapter.MyHolderView holder, int position) {

        Employee employee = employees.get(holder.getAdapterPosition());
        holder.name.setText(employee.getName());
        holder.email.setText(String.valueOf(employee.getEmail()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                Intent i = new Intent(mContext, EmployeeDetails.class);
                i.putExtra("employee",employee);
                mContext.startActivity(i);
            }
        });

    }


    @Override
    public int getItemCount() {
        return employees.size();
    }

    public class MyHolderView extends RecyclerView.ViewHolder {


        public MaterialTextView name;
        public MaterialTextView email;

        public MyHolderView(View view) {
            super(view);

            name = view.findViewById(R.id.flendzz_employeename_materialtextview);
            email = view.findViewById(R.id.flendzz_employeemail_materialtextview);

        }

    }




}






