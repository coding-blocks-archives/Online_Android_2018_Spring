package com.codingblocks.listviewcustomadapter;

import java.util.ArrayList;

public class Teacher {
    String name;
    String course;

    public Teacher(String name, String course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public static ArrayList<Teacher> get8RandomTeachers() {
        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("Arnav", "Android"));
        teachers.add(new Teacher("Prateek", "C++"));
        teachers.add(new Teacher("Rishab", "Java"));
        teachers.add(new Teacher("Garima", "Java"));
        teachers.add(new Teacher("Harshit", "Android"));
        teachers.add(new Teacher("Aayush", "NodeJS"));
        teachers.add(new Teacher("Arnav", "NodeJS"));
        teachers.add(new Teacher("Prateek", "Python"));
        return teachers;
    }
}
