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
    private int countMember; // Номер участника
    private int winMember = 0; // Признак провала дистанции (дистанция провалена, если признак = 1)
    public static int count = 0; // Номер участник

    // Конструктор
    public Member(int number) {
        this.numberOfObstacles = number;
        ++count;
        this.countMember = count;
    }

    // Метод возвращающий, результат преодоления препятствий участником
    public boolean goObstacles(int obstacles) {
        return  (obstacles <= numberOfObstacles);
    }

    // Метод возвращающий, сколько препятствий преодолел участник
    public int countObstacles(int valueObstacles) {
        if (!goObstacles(valueObstacles)) {
            printGoObstaclesError();
            return numberOfObstacles;
        } else {
//            System.out.println("Участник № " + Integer.toString(countMember) + " преодолел препятствие");
            return valueObstacles;
        }
    }

    // Метод возвращающий ошибку при попытке количество препятствий, превышающих возможности участника
    public void printGoObstaclesError() {
        winMember = 1;
        System.out.println("Внимание! Участник № " + Integer.toString(countMember) + " не справился, он может преодолеть не более " + Integer.toString(numberOfObstacles) + " препятствий");
    }

    // Создаём геттеры на количество участников и количество препятствий, которое может пройти каждый участник
    public int getCountMember() {
        return countMember;
    }
    public int getNumberOfObstacles() {
        return numberOfObstacles;
    }
    public int getWinMember() {
        return winMember;
    }

}