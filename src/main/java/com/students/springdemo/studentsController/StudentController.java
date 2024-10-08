package com.students.springdemo.studentsController;

import com.students.springdemo.model.Student;
import com.students.springdemo.service.StudentServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")

public class StudentController {
    private final StudentServiceInterface service;
    public StudentController(StudentServiceInterface service){
        this.service=service;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Student>> findAllStudents(){
        return new ResponseEntity<>(service.getAllStudents(), HttpStatus.OK);
    }
    @GetMapping("/get/name")
    public ResponseEntity<List<Student>> getStudentsByName( @RequestParam String name){
        return new ResponseEntity<>(service.getStudentsByName(name),HttpStatus.OK);
    }
    @GetMapping("/get/{course}")
    public ResponseEntity<List<Student>> getStudentsByCourse(@PathVariable("course") @RequestParam String course){
        return new ResponseEntity<>(service.getStudentsFromParticularCourse(course),HttpStatus.OK);
    }
    @GetMapping("/get/email")
    public ResponseEntity<List<Student>> getStudentByEmail(@RequestParam String email){
        return new ResponseEntity<>(service.getStudentByEmail(email),HttpStatus.OK);

    }
    @PostMapping("/create/new")
    public ResponseEntity<Student> createNewStudent(@RequestBody Student student){
        return new ResponseEntity<>(service.createNewStudent(student),HttpStatus.OK);
    }
    @PutMapping("/update/reg-number")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@RequestParam Long id){
        return new ResponseEntity<>(service.updateStudent(student,id),HttpStatus.OK);
    }
    @DeleteMapping("/delete/by/id")
    public ResponseEntity<String> deleteStudentById(@RequestParam Long id){
        return new ResponseEntity<>(service.deleteStudentById(id),HttpStatus.OK);
    }
}



