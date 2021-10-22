package HomeWork09;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 21.10.2021
 */

public class CourseGeekBrains implements Course {

    // Поле класса
    private String nameOfTheCourse;

    // Конструктор
    public CourseGeekBrains(String nameOfTheCourse) {
        this.nameOfTheCourse = nameOfTheCourse;
    }

    // Геттер
    public String getNameOfTheCourse() {
        return nameOfTheCourse;
    }
}
