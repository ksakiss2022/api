package com.example.api.controller;

import com.example.api.model.Student;
import com.example.api.servise.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("studdent")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("{id}") //GET http://localhost:8080/students/23
    public ResponseEntity<Student> getStudentInfo(@PathVariable long id) {
        Student student = studentService.findStudent(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @GetMapping //GET http://localhost:8080/students
    public ResponseEntity<Collection<Student>> getAllStudents() {

        ///////////////
        return ResponseEntity.ok(studentService.getAllStudents);
    }

    @GetMapping //GET http://localhost:8080/students/age
    public ResponseEntity<Student> filtrStudentAge(@PathVariable int age) {
        int ageStudentFilter;
        Student student = studentService.findStudentAge(age);
        if (age==0){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PostMapping //POST http://localhost:8080/students
    public Student createStudent(@RequestBody Student student) {
        return StudentService.createStudent(student);
    }

    @PutMapping //PUT http://localhost:8080/students
    public ResponseEntity<Student> editStudent(@RequestBody Student student) {
        Student foundStudent = StudentService.editStudent(student);
        if (foundStudent == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    @GetMapping("{id}") //DELETE http://localhost:8080/students/23
    public Student deleteStudent(@PathVariable Long id) {
        return studentService.deletStudent(id);
    }

}
