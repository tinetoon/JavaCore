package HomeWork03;

import java.lang.reflect.Array;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 23.09.2021
 *
 * 1. Написать метод, который меняет два элемента массива местами
 * (массив может быть любого ссылочного типа);
 */

public class HomeApp03 {

    public static void main(String[] args) {

        int[] testIntArr = new int[5]; // Объявляем массив из 5 элементов
        Tools.fillArray(testIntArr,0,20);
        System.out.println("1.1 Оригинальный массив");
        Tools.printArray(testIntArr);
//        testIntArr = swapElements(testIntArr, 2, 4);
        String[] testStrArr = new String[] {"Каждый", "Охотник", "Желает", "Знать", "Где", "Сидит", "Фазан"};
//        testStrArr[1] = "Фазан";
//        testStrArr[6] = "Охотник";

        System.out.println("1.2 Оригинальный массив");
        Tools.printStrArray(testStrArr);
//        testStrArr = swapElements(testStrArr, 2, 4);

        TestArray<String> genStr = new TestArray<>("Hello");
        genStr.showType();
        System.out.println("genStr.getObject(): " + genStr.getObj());

        TestArray<String[]> newArr = new TestArray<>(testStrArr);
        newArr.showType();
        System.out.println("1.3 Оригинальный массив");
        Tools.printStrArray(newArr.getObj());

        // операции для метода
//        String[] temp = new String[2];
//        temp[0] = testStrArr[1];
//        temp[1] = testStrArr[6];
//
//        testStrArr[1] = temp[1];
//        testStrArr[6] = temp[0];
//
//        System.out.println("1.3 Новый массив");
//        Tools.printStrArray(testStrArr);

        // операции для ссылочного метода
        String[] temp = new String[2];
        temp[0] = newArr.getObj()[1];
        temp[1] = newArr.getObj()[6];

        TestArray<String[]> newTempArr = new TestArray<>(temp);

        System.out.println("1.3 Новый массив");
        Tools.printStrArray(testStrArr);
    }

    //Метод, который меняет два элемента массива местами
    public static TestArray[] swapElements(TestArray[] arr, int firstElementNum, int secondElementNum) {
        TestArray[] temp = new TestArray[2];
        temp[1] = arr[firstElementNum];
        temp[2] = arr[secondElementNum];

        arr[firstElementNum] = temp[2];
        arr[secondElementNum] = temp[1];

        return arr;
    }
}
