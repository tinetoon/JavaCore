package HomeWork09;

import HomeWork09.enums.Faculty;

import java.util.List;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 21.10.2021
 */

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
        return name;
    }

    @Override
    public List<Course> getAllCourses() {
        return allCourses;
    }
}
