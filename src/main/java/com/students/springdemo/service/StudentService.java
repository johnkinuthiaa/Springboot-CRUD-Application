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
    public Student updateStudent(Student student,Long id) throws RuntimeException{
        if(repository.findById(id).isEmpty()){
            throw new RuntimeException("student not found");
        }
        else {
            repository.deleteById(id);
        }
        return repository.save(student);
    }
    @Override
    public String deleteStudentById(Long id) throws RuntimeException{
        if(repository.findById(id).isEmpty()){
            throw new RuntimeException("student does not exist");
        }
        else {
            repository.deleteById(id);
        }
        return "student with id"+id+"deleted";
    }
}
