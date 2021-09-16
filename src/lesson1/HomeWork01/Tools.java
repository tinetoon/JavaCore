package lesson1.HomeWork01;

import java.util.Random;

/**
 * Класс вспомогательных инструментов
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 16.09.2021
 */

public class Tools {

    public static Random random = new Random();

    // Метод возвращающий любое целое число
    public static int randomValue(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }
}
