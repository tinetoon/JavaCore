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

        int[] testIntArr = new int[5]; // Объявляем целочисленный массив из 5 элементов
        Tools.fillArray(testIntArr,0,20); // Наполняем массив случайными числами
        System.out.println("1.1 Оригинальный целочисленный массив");
        Tools.printArray(testIntArr);
//        testIntArr = swapElements(testIntArr, 2, 4);
        String[] testStrArr = new String[] {"Каждый", "Охотник", "Желает", "Знать", "Где", "Сидит", "Фазан"}; // Объявляем и инициализируем массив строкового типа
//        testStrArr[1] = "Фазан";
//        testStrArr[6] = "Охотник";

        System.out.println("1.2 Оригинальный строковый массив"); // Выводим массив в консоль
        Tools.printStrArray(testStrArr);
//        testStrArr = swapElements(testStrArr, 2, 4);

        TestArray<String> genStr = new TestArray<>("Hello"); // Создаём ссылочный массив из строки
        genStr.showType(); // Выводим в консоль информацию о типе массива
        System.out.println("Массив genStr[]: " + genStr.getObj()); // Выводим массив в консоль

        TestArray<String[]> newArr = new TestArray<>(testStrArr); // Создаём ссылочный массив из массива строкового типа

        newArr.showType(); // Выводим в консоль информацию о типе массива
        System.out.println("1.3 Оригинальный ссылочный массив");
        System.out.println("Длина массива (кол-во элементов): " + newArr.getObj().length);
        System.out.println("Максимальный номер элемента массива: " + (newArr.getObj().length - 1));

        Tools.printStrArray(newArr.getObj());
        for (int i = 0; i < newArr.getObj().length; i++) {
            System.out.println("Элемент массива № " + i + " : " + newArr.getObj()[i]);
        }

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
//        newArr.setObj(newArr.swapElementsNew(testStrArr, 1, 6));
        newArr.setObj(newArr.swapElementsNew(newArr.getObj(), 1, 6));


//        TestArray<String[]> newTempArr = new TestArray<>(temp);

        // TestArray<String[]> newArr = new TestArray<String[]>(testStrArr)
//        newArr = swapElements(newArr, 1, 6);
        System.out.println("1.4 Новый ссылочный массив");
        Tools.printStrArray(newArr.getObj());
    }

    //Метод, который меняет два элемента массива местами
//    public static TestArray[] swapElements(TestArray[] arr, int firstElementNum, int secondElementNum) {
//        TestArray[] temp = new TestArray[2];
//        TestArray[] tempArr = new TestArray[arr.length];
//        temp[1] = arr[firstElementNum];
//        temp[2] = arr[secondElementNum];
//
//        for (int i = 0; i < arr.length; i++) {
//            tempArr[i] = arr[i];
//        }
//
//        arr[firstElementNum] = temp[2];
//        arr[secondElementNum] = temp[1];
//
//        return arr;
//    }
}
