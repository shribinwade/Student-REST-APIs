package com.student.controllers;


import com.student.Service.StudentService;
import com.student.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class studentController {

    @Autowired
    StudentService studentService;

    //ADD STUDENT
    @PostMapping(path="/savetudent")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
            Student student1 = studentService.saveStudent(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(student1);
    }


    //UPDATE SINGLE STUDENT
    @PostMapping(path="/updateStudent/{studentId}")
    public ResponseEntity<String> updateStudent(@PathVariable String studentId, @RequestBody Student student){
       return studentService.updateStudent(studentId,student);
    }

    //GET SINGLE STUDENT
    @GetMapping(path="/getStudent/{studentId}")
    public ResponseEntity<Student> getSingleStudent(@PathVariable String studentId){
        Student student = studentService.getStudent(studentId);
        return ResponseEntity.ok(student);
    }

    //DELETE STUDENT
    @DeleteMapping(path="/delete/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable String studentId){
        return studentService.deleteStudent(studentId);
    }

    //GET ALL STUDENT
    @GetMapping(path="getallStudent")
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> allStudent = studentService.getAllStudent();
        return ResponseEntity.ok(allStudent);
    }

}
