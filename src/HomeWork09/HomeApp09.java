package HomeWork09;

import HomeWork09.enums.Faculty;

import java.util.*;
import java.util.stream.Collectors;

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

        // Создаём курсы
        Course Course01 = new CourseGeekBrains("Course01");
        Course Course02 = new CourseGeekBrains("Course02");
        Course Course03 = new CourseGeekBrains("Course03");
        Course Course04 = new CourseGeekBrains("Course04");
        Course Course05 = new CourseGeekBrains("Course05");

        // Создаём наборы курсов
        List<Course> qaList = new ArrayList<>(Arrays.asList(Course01, Course02, Course03, Course04, Course05));
        List<Course> programmerList = new ArrayList<>(Arrays.asList(Course01, Course02, Course03, Course04));
        List<Course> teamLeadList = new ArrayList<>(Arrays.asList(Course01, Course02, Course03));
        List<Course> directorList = new ArrayList<>(Arrays.asList(Course01, Course02));

        // Создаём список студентов
        List<Student> studentsGeekBrains = new ArrayList<>(Arrays.asList(
                new StudentGeekBrains("Anton", qaList, Faculty.QA),
                new StudentGeekBrains("Boris", programmerList, Faculty.PROGRAMMER),
                new StudentGeekBrains("Ivan", teamLeadList, Faculty.TEAM_LEAD),
                new StudentGeekBrains("Olga", directorList, Faculty.DIRECTOR)
        ));

        // Выводим в консоль список уникальных курсов
        System.out.println("===== Список уникальных курсов =====");
        uniqueCourse(studentsGeekBrains);

        // Выводим в консоль список из трёх (count) самых любознательных студентов
        System.out.println("===== Список трёх самых любознательных студентов =====");
        printListStudents(studentsGeekBrains, 3);

        // Выводим в консоль список студентов посещяющих курс
        System.out.println("===== Список студентов, посещающих курс Course04 =====");
        System.out.println(studentsAttendingTheCourse(studentsGeekBrains, Course04));
    }

    // Метод, возвращающий список уникальных курсов, на которые подписаны студенты
    public static void uniqueCourse (List<Student> student) {
        student.stream()
                .map(Student::getAllCourses)
                .flatMap(List::stream)
                .map(Course::getNameOfTheCourse)
                .distinct()
                .forEach(System.out::println)
                ;
    }

    // Метод, возвращающий список самых любознательных студенты
    public static List<String> curiousStudents (List<Student> student, int count) {
        return student.stream()
                .sorted((s1, s2) -> s2.getAllCourses().size() - s1.getAllCourses().size())
                .limit(count)
                .map(Student::getName)
                .collect(Collectors.toList())
                ;
    }

    // Метод печати в консоль списка любознательных студентов
    public static void printListStudents(List<Student> student, int count) {
        List<String> listStudentsTmp = curiousStudents(student, count);
        for (Student it: student) {
            for (String im: listStudentsTmp) {
                if (it.getName().equals(im)) {
                    System.out.println("Студент: " + it.getName() + ", записан на: " + it.getAllCourses().size() + " курса");
                }
            }
        }
    }

    // Метод, возвращающий список студентов посещающих определённый курс
    public static List<String> studentsAttendingTheCourse(List<Student> student, Course course) {
        return student.stream()
                .filter(s -> s.getAllCourses().contains(course))
                .map(Student::getName)
                .collect(Collectors.toList())
                ;
    }
}
