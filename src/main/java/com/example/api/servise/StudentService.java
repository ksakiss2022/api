package com.example.api.servise;

import com.example.api.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class StudentService {
    private static final HashMap<Long, Student> students = new HashMap<>();


    //////////
    public Collection<Student> getAllStudents;


    private static long lastId;

    public static Student createStudent(Student student) {
        student.setId(++lastId);
        students.put(lastId, student);
        return student;
    }

    public Student findStudent(long id) {
        return students.get(id);

    }

    public static Student editStudent(Student student) {
        students.put(student.getId(), student);
        return student;
    }

    public Student deletStudent(long id) {
        return students.remove(id);
    }


    public Student findStudentAge(int age) {
        return students.get(age);
    }
}
