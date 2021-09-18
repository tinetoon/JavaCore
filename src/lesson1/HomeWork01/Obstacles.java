package lesson1.HomeWork01;

/**
 * Класс препятствий
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 18.09.2021
 */

public class Obstacles {

    // Поля класса
    private int countCourses; // Номер препятствия
    public static int count = 0; // Номер препятствия

    // Конструктор
    public Obstacles(int number) {
        ++count;
        this.countCourses = count;
    }

    public int getCountCourses() {
        return countCourses;
    }
}
