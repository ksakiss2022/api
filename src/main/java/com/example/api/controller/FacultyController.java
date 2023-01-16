package com.example.api.controller;

import com.example.api.model.Faculty;
import com.example.api.servise.FacultyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("{id}") //GET http://localhost:8080/facultys
    public ResponseEntity<Faculty> getfacultyInfo(@PathVariable long id){
        Faculty faculty= facultyService.findFaculty(id);
        if (faculty==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }
    @GetMapping //GET http://localhost:8080/facultys
    public  ResponseEntity<Collection<Faculty>> getAllfacultys(){

        /////////        ///////////////
        return ResponseEntity.ok(facultyService.getAllfacultys);
    }

    @GetMapping //GET http://localhost:8080/facultys/color
    public ResponseEntity<Faculty> filtrcolorColor(@PathVariable String color) {
        String colorFacultyFilter;
        Faculty faculty = facultyService.findFacultyColor(color);
        if (color==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faculty);
    }

    @PostMapping //POST http://localhost:8080/facultys
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return FacultyService.createFaculty(faculty);
    }

    @PutMapping //PUT http://localhost:8080/facultys
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty) {
        Faculty foundFaculty = FacultyService.editFaculty(faculty);
        if (foundFaculty == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(foundFaculty);
    }
    @GetMapping("{id}") //GET http://localhost:8080/facultys/23
    public Faculty deletFaculty(@PathVariable Long id){
        return facultyService.deletFaculty(id);
    }
}
