package com.example.lab7.Controller;

import com.example.lab7.Api.ApiRespons;
import com.example.lab7.Model.Course;
import com.example.lab7.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    @GetMapping("/get")
    public ResponseEntity getCourses(){
        ArrayList<Course> courses = courseService.getCourses();
        return ResponseEntity.status(200).body(courses);

    }
    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course, Errors errors){
        if(errors.hasErrors()){
          String msg=errors.getFieldError().getDefaultMessage();
          return ResponseEntity.status(400).body(msg);
        }
        courseService.addCourse(course);
        return ResponseEntity.status(200).body(new ApiRespons("course added successfully"));


    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable int id,@Valid @RequestBody Course course, Errors errors){
        if(errors.hasErrors()){
            String msg=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(msg);
        }
        boolean result = courseService.updateCourse(id, course);
        if(result){
            return ResponseEntity.status(200).body(new ApiRespons("course updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiRespons("course not found"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable int id){
        boolean result = courseService.deleteCourse(id);
        if(result){
            return ResponseEntity.status(200).body(new ApiRespons("course deleted successfully"));
        }
        return ResponseEntity.status(400).body(new ApiRespons("course not found"));
    }
    @GetMapping("/getc/{id}")
    public ResponseEntity findCourseById(@PathVariable int id){
        Course course = courseService.getCourseById(id);
        if(course==null){
            return ResponseEntity.status(400).body(new ApiRespons("course not found"));
        }
        return ResponseEntity.status(200).body(course);

    }
    @GetMapping("/getn/{name}")
    public ResponseEntity getCourseByName(@PathVariable String name){
        ArrayList<Course> courses = courseService.getCourseByName(name);
        if(courses==null){
            return ResponseEntity.status(400).body(new ApiRespons("course not found"));
        }
        return ResponseEntity.status(200).body(courses);
    }
    @GetMapping("/getnum/{numberOfStudent}")
    public ResponseEntity getCourseBynumberOfStudent(@PathVariable int numberOfStudent){
        ArrayList<Course> courses = courseService.getCourseBynumberOfStudent(numberOfStudent);
        if(courses==null){
            return ResponseEntity.status(400).body(new ApiRespons("course not found"));
        }
        return ResponseEntity.status(200).body(courses);

    }
    @GetMapping("/getno")
public ResponseEntity getCourseWithNoStudents (){
        ArrayList<Course> courses = courseService.getCourseWithNoStudents();
        if(courses==null){
            return ResponseEntity.status(400).body(new ApiRespons("course not found"));
        }
        return ResponseEntity.status(200).body(courses);

}
}
