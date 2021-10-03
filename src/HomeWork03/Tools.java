package HomeWork03;

import java.util.Random;

/**
 * Класс вспомогательных инструментов
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 23.09.2021
 */

public class Tools {

    public static Random random = new Random();

    // Метод возвращающий любое целое число
    public static int randomValue(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    // Метод для создания одномерного массива из случайных целых чисел
    public static void fillArray(int[] inputArray, int min, int max) {
        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = randomValue(min, max);
        }
    }

    // Метод для вывода одномерного int массива в консоль
    public static void printArray(int[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + "\t");
        }
        System.out.println();
    }

    // Метод для вывода одномерного int массива в консоль
    public static void printStrArray(String[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + "\t");
        }
        System.out.println();
    }

    // Метод для вывода одномерного char массива в консоль
    public static void printCharArray(char[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + "\t");
        }
        System.out.println();
    }

    // Метод для вывода одномерного массива в консоль
    public static void printArray(NewArray[] inputArray) {
        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(inputArray[i] + "\t");
        }
        System.out.println();
    }
}
