package HomeWork09;

import HomeWork09.enums.Faculty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 21.10.2021
 *
 * 1. Написать функцию, принимающую список Student и возвращающую список уникальных курсов, на которые подписаны студенты.
 *
 * 2. Написать функцию, принимающую на вход список Student и возвращающую список из трех самых любознательных
 * (любознательность определяется количеством курсов).
 *
 * 3. Написать функцию, принимающую на вход список Student и экземпляр Course, возвращающую список студентов, которые посещают этот курс.
 */

public class HomeApp09 {

    public static void main(String[] args) {

        // Создаём наборы курсов
        List<Course> qaList = new ArrayList<>(Arrays.asList(
                new CourseGeekBrains("Course01"),
                new CourseGeekBrains("Course02"),
                new CourseGeekBrains("Course03"),
                new CourseGeekBrains("Course04"),
                new CourseGeekBrains("Course05")
        ));
        List<Course> programmerList = new ArrayList<>(Arrays.asList(
                new CourseGeekBrains("Course01"),
                new CourseGeekBrains("Course02"),
                new CourseGeekBrains("Course03"),
                new CourseGeekBrains("Course04")
        ));
        List<Course> teamLeadList = new ArrayList<>(Arrays.asList(
                new CourseGeekBrains("Course01"),
                new CourseGeekBrains("Course02"),
                new CourseGeekBrains("Course03")
        ));
        List<Course> directorList = new ArrayList<>(Arrays.asList(
                new CourseGeekBrains("Course01"),
                new CourseGeekBrains("Course02")
        ));

        // Создаём список студентов
        List<Student> studentsGeekBrains = new ArrayList<>(Arrays.asList(
                new StudentGeekBrains("Anton", qaList, Faculty.QA),
                new StudentGeekBrains("Boris", programmerList, Faculty.PROGRAMMER),
                new StudentGeekBrains("Ivan", teamLeadList, Faculty.TEAM_LEAD),
                new StudentGeekBrains("Olga", directorList, Faculty.DIRECTOR)
        ));

        // Выводим в консоль список уникальных курсов
        uniqueCourse(studentsGeekBrains);
    }

    // Метод возвращающий список уникальных курсов, на которые подписаны студенты
    public static void uniqueCourse (List<Student> student) {
        student.stream()
                .map(Student::getAllCourses)
                .distinct()
                ;
        student.forEach(System.out::println);
    }
}
