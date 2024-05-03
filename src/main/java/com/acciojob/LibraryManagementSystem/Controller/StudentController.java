package com.acciojob.LibraryManagementSystem.Controller;

import com.acciojob.LibraryManagementSystem.Models.Student;
import com.acciojob.LibraryManagementSystem.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("student")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @GetMapping("/findAllStudents")
    public List<Student> findAllStudents(){
        return studentService.findAllStudents();
    }
}
