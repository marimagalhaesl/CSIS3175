package com.example.lec8demo.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lec8demo.R;
import com.example.lec8demo.model.Student;

import java.util.List;

public class StudentAdapter extends BaseAdapter {
    List<Student> StudentsList;

    //String[] - can be used to store header info

    public StudentAdapter(List<Student> studentsList) {
        StudentsList = studentsList;
    }

    @Override
    public int getCount() {
        return StudentsList.size();
    }

    @Override
    public Student getItem(int i) {
        return StudentsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_student, viewGroup, false);
        }

        TextView txtViewStudId = view.findViewById(R.id.txtViewStudId);
        TextView txtViewStudName = view.findViewById(R.id.txtViewStudName);
        TextView txtViewStudDept = view.findViewById(R.id.txtViewStudDept);

        if (i == 0) {
            txtViewStudId.setTextColor(Color.RED);
            txtViewStudName.setTextColor(Color.RED);
            txtViewStudDept.setTextColor(Color.RED);
            //txtViewStudId.setText(HeaderLine[0]; //use HeaderLine as String[] data in the adapter
            txtViewStudId.setText("StudId");
            txtViewStudName.setText("StudName");
            txtViewStudDept.setText("StudDept");
        } else {
            txtViewStudId.setTextColor(Color.BLACK);
            txtViewStudName.setTextColor(Color.BLACK);
            txtViewStudDept.setTextColor(Color.BLACK);
            txtViewStudId.setText(StudentsList.get(i-1).getStudentId());
            txtViewStudName.setText(StudentsList.get(i-1).getStudentName());
            txtViewStudDept.setText(StudentsList.get(i-1).getStudentDept());
        }


        return view;
    }
}
