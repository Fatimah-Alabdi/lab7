package com.example.lab7.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Course {
    @NotNull(message = "id cannot be null")
    private int id;
    @NotEmpty(message = "course name cannot be empty")
    @Size(min = 5,message = "the name must be more than 4 character")
    private String name;
    @NotEmpty(message = "course description cannot be empty")
    @Size(min = 50,message = "the description must be more than 49 character")
    private String description;
    @NotNull(message = "number of students cannot be null")
    @PositiveOrZero
    private int numberOfStudents;
    private Date startDate;
    private Date endDate;
}
