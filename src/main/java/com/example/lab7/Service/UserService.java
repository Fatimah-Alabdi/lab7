package com.example.lab7.Service;

import com.example.lab7.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    ArrayList<User> users = new ArrayList<>();
    public ArrayList<User> getUsers() {
        return users;
    }
    public void addUser(User user) {
        users.add(user);

    }
    public boolean deleteUser(int id){
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.remove(i);
                return true;
            }

        }
        return false;

    }
    public boolean updateUser(int id, User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.set(i, user);
                return true;
            }
        }
        return false;
    }
    public User getUserById(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                return users.get(i);

            }
        }
        return null;
    }
    public boolean applyCourse (int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                if(users.get(i).isCourseEnroll()==false){
                    users.get(i).setCourseEnroll(true);
                    return true;
                }

            }
        }
        return false;
    }
    public ArrayList<User> getUserWithNoCourse() {
        ArrayList<User> cusers = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).isCourseEnroll()==false&&users.get(i).getNumberOfCourses()==0){
                cusers.add(users.get(i));


            }
        }
        if (users.isEmpty()){
            return null;
        }
        return cusers;
    }
    public ArrayList<User> getUsersByRole(String role) {
        ArrayList<User> rusers = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            if ( users.get(i).getRole().equalsIgnoreCase("teacher")||users.get(i).getRole().equalsIgnoreCase("student")) {
                if(users.get(i).getRole().equalsIgnoreCase(role)){
                    rusers.add(users.get(i));

                }

            }
        }
        if (rusers.isEmpty()){
            return null;
        }
        return rusers;
    }
}
