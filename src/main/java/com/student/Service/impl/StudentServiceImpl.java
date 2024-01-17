package com.student.Service.impl;

import com.student.Service.StudentService;
import com.student.entities.Student;
import com.student.exceptions.ResourceNotFoundException;
import com.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {
        String randomUserId = UUID.randomUUID().toString();
        student.setStudentId(randomUserId);
        return studentRepository.save(student);
    }

    @Override
    public Student getStudent(String studentId) {
        return studentRepository.findById(studentId).orElseThrow(
                ()->new ResourceNotFoundException("Student with given id is not found on server !! : "+studentId)
        );
    }

    @Override
    public ResponseEntity<String> deleteStudent(String studentId) {

        Optional<Student> optional = studentRepository.findById(studentId);
        if(!optional.isEmpty()){
            studentRepository.deleteById(studentId);
            return ResponseEntity.status(HttpStatus.OK).body("Student deleted");

        }else{
            throw new ResourceNotFoundException("Student with given id is not found on server !! : " + studentId);
        }

    }

    @Override
    public ResponseEntity<String> updateStudent(String studentId, Student student) {
        Optional<Student> optional = studentRepository.findById(studentId);
        if(!optional.isEmpty()){
            Student student1 = optional.get();
            student.setStudentId(student1.getStudentId());
            studentRepository.save(student);
            return ResponseEntity.status(HttpStatus.OK).body("Student Updated Successfully");
        }
        else {
            throw new ResourceNotFoundException("Student with given id is not found on server !! : " + studentId);
        }
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
}
