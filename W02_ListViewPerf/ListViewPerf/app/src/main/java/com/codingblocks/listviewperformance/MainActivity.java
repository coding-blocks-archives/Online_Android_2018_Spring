package com.codingblocks.listviewperformance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "LIST";
    ListView lvCourses;
    ArrayList<Course> courses = Course.generateNRandomCourses(100);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCourses = findViewById(R.id.lvCourses);
        CourseAdapter courseAdapter = new CourseAdapter();
        lvCourses.setAdapter(courseAdapter);
    }

    class CourseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return courses.size();
        }

        @Override
        public Course getItem(int position) {
            return courses.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Log.d(TAG, "getView: position=" + position + " convertView=" + convertView);
            CourseViewHolder holder;
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(
                        R.layout.list_item_course,
                        parent,
                        false
                );
                holder = new CourseViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (CourseViewHolder) convertView.getTag();
            }

            Course course = getItem(position);
            holder.tvCourseName.setText(course.getName());
            holder.tvTeacherName.setText(course.getTeacherName());
            holder.tvLectures.setText(String.valueOf(course.getLectures()));

            return convertView;
        }

        class CourseViewHolder {
            TextView tvCourseName, tvTeacherName, tvLectures;

            CourseViewHolder(View convertView) {
                tvCourseName = convertView.findViewById(R.id.tvCourseName);
                tvTeacherName = convertView.findViewById(R.id.tvTeacherName);
                tvLectures = convertView.findViewById(R.id.tvLectures);
            }
        }
    }
}
