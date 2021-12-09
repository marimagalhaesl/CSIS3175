package com.example.finalpracticehard.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.finalpracticehard.R;
import com.example.finalpracticehard.model.Student;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends BaseAdapter {
    List<Student> studentList;
    String[] header = {"user_id", "user_name"};

    public UserAdapter(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public int getCount() {
        return studentList.size()+1;
    }

    @Override
    public Object getItem(int i) {
        return studentList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_users, viewGroup, false);
        }

        TextView txtViewStudentId = view.findViewById(R.id.txtViewStudentId);
        TextView txtViewStudentName = view.findViewById(R.id.txtViewStudentName);

        if (i == 0) {
            txtViewStudentId.setText(header[0]);
            txtViewStudentId.setTextColor(Color.WHITE);
            txtViewStudentId.setBackgroundColor(Color.DKGRAY);

            txtViewStudentName.setText(header[1]);
            txtViewStudentName.setTextColor(Color.WHITE);
            txtViewStudentName.setBackgroundColor(Color.DKGRAY);

        } else {
            txtViewStudentId.setText(studentList.get(i-1).getUserid());
            txtViewStudentName.setText(studentList.get(i-1).getName());
        }


        return view;
    }
}
