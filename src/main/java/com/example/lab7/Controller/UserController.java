package com.example.lab7.Controller;

import com.example.lab7.Api.ApiRespons;
import com.example.lab7.Model.User;
import com.example.lab7.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping("/get")
    public ResponseEntity getAllUsers() {
        ArrayList<User> users1 = userService.getUsers();
        return ResponseEntity.status(200).body(users1);

    }
    @PostMapping("/add")
    public ResponseEntity addUser(@Valid@RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String mmsg=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(mmsg);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiRespons("user added successfully"));

    }
    @DeleteMapping("/delet/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted) {
            return ResponseEntity.status(200).body(new ApiRespons("user deleted successfully"));
        }
        return ResponseEntity.status(404).body(new ApiRespons("user not found"));

    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@PathVariable int id,@Valid @RequestBody User user, Errors errors) {
        if (errors.hasErrors()) {
            String mmsg=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(mmsg);
        }
        boolean isUpdated = userService.updateUser(id,user);
        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiRespons("user updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiRespons("user not found"));
    }
    @GetMapping("getuserbyid/{id}")
    public ResponseEntity GetUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.status(400).body(new ApiRespons("user not found"));
        }
        return ResponseEntity.status(200).body(user);

    }
    @PutMapping("/apply/{id}")
    public ResponseEntity applyCourse(@PathVariable int id) {
        boolean isAplly = userService.applyCourse(id);
        if (isAplly) {
            return ResponseEntity.status(200).body(new ApiRespons("user Apply successfully"));
        }
        return ResponseEntity.status(400).body(new ApiRespons("user not found"));

    }
    @GetMapping("/getwith")
    public ResponseEntity getUserWithNoCourse(){
        ArrayList<User> users = userService.getUserWithNoCourse();
        if(users==null){
            return ResponseEntity.status(404).body(new ApiRespons("user not found"));
        }
        return ResponseEntity.status(200).body(users);

    }
    @GetMapping("/getrole/{role}")
    public ResponseEntity getUsersByRole(@PathVariable String role){
        ArrayList<User> users = userService.getUsersByRole(role);
        if(users==null){
            return ResponseEntity.status(400).body(new ApiRespons("user not found"));
        }
        return ResponseEntity.status(200).body(users);


    }
}
