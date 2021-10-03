package HomeWork03;

import java.lang.reflect.Array;

/**
 * Класс параметризации объекта
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 25.09.2021
 */

public class NewArray<T> {

    private T[] newArray;

    // Конструктор класса
    public NewArray(Class<T> obj, T... element) {

        this.newArray = (T[]) Array.newInstance(obj, element.length);

        for (int i = 0; i < element.length; i++) {
            newArray[i] = element[i];
//            System.out.println(newArray[i]);
        }
    }

    public T[] getNewArray() {
        return newArray;
    }

    // Метод печати в консоль элементов массива
    public void printArray() {
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + "\t");
        }
        System.out.println();
    }

    // Метод замены элемента массива
    public String[] swapElements(String[] arr, int firstElementNum, int secondElementNum) {
        String[] temp = new String[2];

        temp[0] = arr[firstElementNum];
        temp[1] = arr[secondElementNum];

        arr[firstElementNum] = temp[1];
        arr[secondElementNum] = temp[0];

        return arr;
    }
}
