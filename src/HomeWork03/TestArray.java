package HomeWork03;

import java.lang.reflect.Array;

/**
 * Класс параметризации объекта
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 23.09.2021
 */

public class TestArray<T> {

    private T obj;

    // Конструктор класса
    public TestArray(T оbj) {
        this.obj = оbj;
    }

    // Метод вывода информации о типе массива
    public void showType() {
        System.out.println("Тип T: " + obj.getClass().getName());
    }

    // Метод замены элемента массива
    public String[] swapElementsNew(String[] arr, int firstElementNum, int secondElementNum) {
        String[] temp = new String[2];

        temp[0] = arr[firstElementNum];
        temp[1] = arr[secondElementNum];

        arr[firstElementNum] = temp[1];
        arr[secondElementNum] = temp[0];

        return arr;
    }

    // Метод замены элемента массива
    public char[] swapElementsChar(char[] arr, int firstElementNum, int secondElementNum) {
        char[] temp = new char[2];

        temp[0] = arr[firstElementNum];
        temp[1] = arr[secondElementNum];

        arr[firstElementNum] = temp[1];
        arr[secondElementNum] = temp[0];

        return arr;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

}
