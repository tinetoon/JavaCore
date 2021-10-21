package HomeWork09;

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
