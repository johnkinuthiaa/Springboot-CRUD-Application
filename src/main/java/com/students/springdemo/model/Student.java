package com.students.springdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private Long id;
    private String studentRegistrationNumber;
    private String studentName;
    private String studentEmail;
    private String course;
    private Float level;

    public Student(){}
    public Student(String studentRegistrationNumber,String studentName,String studentEmail,String course,Float level){
        this.studentRegistrationNumber=studentRegistrationNumber;
        this.studentName=studentName;
        this.studentEmail=studentEmail;
        this.course=course;
        this.level=level;
    }
    public void setId(Long id){
        this.id=id;
    }
    public Long getId(){
        return id;
    }
    public void setStudentRegistrationNumber(String studentRegistrationNumber){
        this.studentRegistrationNumber=studentRegistrationNumber;
    }
    public String getStudentRegistrationNumber(){
        return studentRegistrationNumber;
    }
    public void setStudentName(String studentName){
        this.studentName=studentName;
    }
    public String getStudentName(){
        return studentName;
    }
    public void setStudentEmail(String studentEmail){
        this.studentEmail=studentEmail;
    }
    public String getStudentEmail(){
        return studentEmail;
    }
    public void setCourse(String course){
        this.course=course;
    }
    public String getCourse(){
        return course;
    }
    public void setLevel(Float level){
        this.level=level;
    }

    public Float getLevel() {
        return level;
    }
}
