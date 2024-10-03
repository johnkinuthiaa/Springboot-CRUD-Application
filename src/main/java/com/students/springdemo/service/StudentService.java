package com.students.springdemo.service;

import com.students.springdemo.model.Student;
import com.students.springdemo.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;


@Service
public class StudentService implements StudentServiceInterface{
    private final StudentRepository repository;
    public StudentService(StudentRepository repository){
        this.repository=repository;
    }
    @Override
    public List<Student> getAllStudents(){
        return repository.findAll();
    }
    @Override
    public List<Student> getStudentsByName(String name){
        return repository.findAll().stream()
                .filter(student->student.getStudentName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
    @Override
    public List<Student> getStudentsFromParticularCourse(String course){
        return repository.findAll().stream()
                .filter(student->student.getCourse().toLowerCase().contains(course.toLowerCase()))
                .collect(Collectors.toList());
    }
    @Override
    public List<Student> getStudentByRegistrationNumber(String regNo){
        return repository.findAll().stream()
                .filter(student->student.getStudentRegistrationNumber().toLowerCase().contains(regNo.toLowerCase()))
                .collect(Collectors.toList());
    }
    @Override
    public List<Student> getStudentByEmail(String email){
        return repository.findAll().stream()
                .filter(student -> student.getStudentEmail().toLowerCase().contains(email.toLowerCase()))
                .collect(Collectors.toList());
    }
    @Override
    public Student createNewStudent(Student student) throws RuntimeException{
        if(repository.findById(student.getId()).isPresent()){
            throw new RuntimeException("student already exists");
        }
        return repository.save(student);

    }
    @Override
    public Student updateStudent(Student student,String regNo) throws RuntimeException{
        List<Student> regNoPresent =repository.findAll().stream()
                .filter(student1 -> student.getStudentRegistrationNumber().toLowerCase().contains(regNo.toLowerCase()))
                .collect(Collectors.toList());
        if(regNoPresent.isEmpty()){
            throw new RuntimeException("no student with given registration number was found");
        }
        else{
            repository.deleteById(student.getId());
        }
        return repository.save(student);
    }
}
