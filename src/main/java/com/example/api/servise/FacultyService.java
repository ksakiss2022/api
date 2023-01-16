package com.example.api.servise;

import com.example.api.model.Faculty;
import com.example.api.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class FacultyService {

    private static final HashMap<Long, Faculty> facultys = new HashMap<>();

    /////////         ///////////////
    public Collection<Faculty> getAllfacultys;


    private static long lastId;

    public static Faculty createFaculty(Faculty faculty) {
        faculty.setId(++lastId);
        facultys.put(lastId, faculty);
        return faculty;
    }
    public Faculty findFaculty(long id) {
        return facultys.get(id);

    }

    public static Faculty editFaculty(Faculty faculty) {
        facultys.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty deletFaculty(long id) {
        return facultys.remove(id);
    }

    public Faculty findFacultyColor(String color) {
        return facultys.get(color);
    }
}
