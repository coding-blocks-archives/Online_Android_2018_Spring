package com.codingblocks.listviewperformance;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter.CourseViewHolder> {

    ArrayList<Course> courses;

    public CourseRecyclerAdapter(ArrayList<Course> courses) {
        this.courses = courses;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = li.inflate(R.layout.list_item_course_card, parent, false);

        return new CourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {
        Course course = courses.get(position);
        holder.tvLectures.setText(String.valueOf(course.getLectures()));
        holder.tvCourseName.setText(course.getName());
        holder.tvTeacherName.setText(course.getTeacherName());
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    class CourseViewHolder extends RecyclerView.ViewHolder {
        TextView tvCourseName, tvTeacherName, tvLectures;

        public CourseViewHolder(View itemView) {
            super(itemView);
            tvCourseName = itemView.findViewById(R.id.tvCourseName);
            tvTeacherName = itemView.findViewById(R.id.tvTeacherName);
            tvLectures = itemView.findViewById(R.id.tvLectures);
        }
    }

}
