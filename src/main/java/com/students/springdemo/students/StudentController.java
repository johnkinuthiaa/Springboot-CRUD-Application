package com.students.springdemo.students;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")

public class StudentController {
    @GetMapping("/names")
    public List<String> findAllStudents(){
        return List.of(
                "john",
                "james",
                "peter",
                "andrew"
        );
    }
}



