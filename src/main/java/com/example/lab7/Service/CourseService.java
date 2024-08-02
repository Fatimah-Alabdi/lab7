package com.example.lab7.Service;


import com.example.lab7.Model.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseService {
    ArrayList<Course> courses = new ArrayList<>();
    public ArrayList<Course> getCourses() {
        return courses;
    }
    public void addCourse(Course course) {
        courses.add(course);

    }
    public boolean updateCourse(int id ,Course course) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                courses.set(i, course);
                return true;
            }
        }
        return false;
    }
    public boolean deleteCourse(int id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                courses.remove(i);
                return true;
            }
        }
        return false;
    }
    public Course getCourseById(int id) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                return courses.get(i);

            }
        }
        return null;
    }
    public ArrayList<Course> getCourseByName(String name) {
        ArrayList<Course>  ncourses = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getName().equals(name)) {
                ncourses.add(courses.get(i));

            }
        }
        if(ncourses.isEmpty()){
            return null;
        }
        return ncourses;
    }
    public ArrayList<Course> getCourseBynumberOfStudent(int numberOfStudent) {
        ArrayList<Course>  numberOfStudentlist = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getNumberOfStudents()>=numberOfStudent){
                numberOfStudentlist.add(courses.get(i));

            }
        }
        if(numberOfStudentlist.isEmpty()){
            return null;
        }
        return numberOfStudentlist;

    }
    public ArrayList<Course> getCourseWithNoStudents() {
        ArrayList<Course>  noStudentlist = new ArrayList<>();
        for (int i = 0; i < courses.size(); i++) {
            if(courses.get(i).getNumberOfStudents()==0){
                noStudentlist.add(courses.get(i));
            }
        }
        if(noStudentlist.isEmpty()){
            return null;
        }
        return noStudentlist;
    }
}
