package com.example.lec8demo.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lec8demo.model.Grade;
import com.example.lec8demo.R;

import java.util.List;

public class GradeAdapter extends BaseAdapter {
    List<Grade> GradesList;

    public GradeAdapter(List<Grade> gradesList) {
        GradesList = gradesList;
    }

    @Override
    public int getCount() {
        return GradesList.size();
    }

    @Override
    public Grade getItem(int i) {
        return GradesList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {

            view = LayoutInflater.from(view.getContext()).inflate(R.layout.layout_grade, viewGroup, false);

        }
        TextView txtViewCourseId = view.findViewById(R.id.txtViewCourseId);
        TextView txtViewStudId = view.findViewById(R.id.txtViewStudId2);
        TextView txtViewGrade = view.findViewById(R.id.txtViewStudGrade);

        if (i == 0) {
            txtViewStudId.setTextColor(Color.RED);
            txtViewCourseId.setTextColor(Color.RED);
            txtViewGrade.setTextColor(Color.RED);

            txtViewCourseId.setText("CourseId");
            txtViewStudId.setText("StudId");
            txtViewGrade.setText("StudGrade");
        }
        else {
            txtViewStudId.setTextColor(Color.BLACK);
            txtViewCourseId.setTextColor(Color.BLACK);
            txtViewGrade.setTextColor(Color.BLACK);

            txtViewCourseId.setText(GradesList.get(i-1).getCourseId());
            txtViewStudId.setText(GradesList.get(i-1).getStudId());
            txtViewGrade.setText(String.format("%.2f", GradesList.get(i-1).getStudGrade()));
        }

        return view;
    }
}
