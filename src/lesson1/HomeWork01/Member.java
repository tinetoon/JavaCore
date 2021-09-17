package lesson1.HomeWork01;

import java.lang.reflect.Array;

/**
 * Класс участников
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 16.09.2021
 */

public class Member {

    // Поля класса
    private int numberOfObstacles; // Количество препятствий, которое может преодолеть участник
    private int countMember = 0; // Номер участник

    // Конструктор
    public Member(int number) {
        this.numberOfObstacles = number;
        ++countMember;
    }

    public int getNumberOfObstacles() {
        return numberOfObstacles;
    }

    public int getCountMember() {
        return countMember;
    }
}