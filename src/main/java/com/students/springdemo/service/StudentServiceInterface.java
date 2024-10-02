package com.students.springdemo.service;


import com.students.springdemo.model.Student;

import java.util.List;

public interface StudentServiceInterface {
    List<Student> getAllStudents();
    List<Student> getStudentsByName(String name);
    List<Student> getStudentsFromParticularCourse(String course);
    List<Student> getStudentByRegistrationNumber(String regNo);
    List<Student> getStudentByEmail(String email);

}
