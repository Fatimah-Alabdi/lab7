package com.example.lab7.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @NotNull(message = "id canot be null")
    private int id;

    @NotEmpty(message = "name cannot be empty")
    @Size(min = 4, message = "name must be more than 3 character")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Name must contain only characters")
    private String name;

    @NotEmpty(message = "password cannot be empty")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
    private String password;

    @NotEmpty(message = "email cannot be empty")
    @Email
    private String email;

    @Pattern(regexp = "student|teacher", message = "role must be either 'student' or 'teacher' only")
    @NotEmpty(message = "role cannot be empty")
    private String role;

    @NotNull(message = "number of course cannot ba null")
    @PositiveOrZero
    private int numberOfCourses;

    @AssertFalse
    private boolean courseEnroll;
}
