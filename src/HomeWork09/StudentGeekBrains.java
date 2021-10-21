package HomeWork09;

import HomeWork09.enums.Faculty;

import java.util.List;

public class StudentGeekBrains implements Student {

    private String name;
    private List<Course> allCourses;
    private Faculty faculty;

    public StudentGeekBrains(String name, List<Course> courses, Faculty faculty) {
        this.name = name;
        this.allCourses = courses;
        this.faculty = faculty;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<Course> getAllCourses() {
        return null;
    }
}
