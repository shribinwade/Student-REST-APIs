package com.student.Service;

import com.student.entities.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {

    public Student saveStudent(Student student);

    Student getStudent(String studentId);

    ResponseEntity<String> deleteStudent(String studentId);

    ResponseEntity<String> updateStudent(String studentId, Student student);

    List<Student> getAllStudent();
}
