package home2;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 18.09.2021
 *
 * - 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
 * - При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 *
 * - 2. Далее метод должен пройтись по всем элементам массива,
 * - преобразовать в int и просуммировать.
 * - Если в каком-то элементе массива преобразование не удалось
 * - (например, в ячейке лежит символ или текст вместо числа),
 * - должно быть брошено исключение MyArrayDataException с детализацией,
 * - в какой именно ячейке лежат неверные данные.
 *
 * - 3. В методе main() вызвать полученный метод,
 * - обработать возможные исключения MyArraySizeException и MyArrayDataException
 * - и вывести результат расчета.
 */

public class HomeApp02 {

    private static String[][] testArray44;
    private static String[][] testArray66;
    private static String[][] testArray22;

    public static void main(String[] args) {

        testArray44 = new String[4][4];
        testArray66 = new String[6][6];
        testArray66 = new String[2][2];

        try {
            printArray(testArray44);
        } catch (ArrayIndexOutOfBoundsException MyArraySizeException) {
//            MyArraySizeException.printStackTrace();
            System.out.println("Ошибка размера массива");
        } catch (NullPointerException Ex) {
            System.out.println("Ошибка элемента массива");
        }

        try {
            printArray(testArray66);
        } catch (ArrayIndexOutOfBoundsException MyArraySizeException) {
//            MyArraySizeException.printStackTrace();
            System.out.println("Ошибка размера массива");
        } catch (NullPointerException Ex) {
            System.out.println("Ошибка элемента массива");
        }

        try {
            printArray(testArray22);
        } catch (ArrayIndexOutOfBoundsException MyArraySizeException) {
//            MyArraySizeException.printStackTrace();
            System.out.println("Ошибка размера массива");
        } catch (NullPointerException Ex) {
            System.out.println("Ошибка элемента массива");
        }

//        printArray(testArray44);
//        printArray(testArray66);
//        printArray(testArray22);
    }

    // Метод печати элементов массива
    public static void printArray(String[][] testTable) throws ArrayIndexOutOfBoundsException, NullPointerException {

        System.out.println("===== Новый массив =====");

        for (int y = 0; y < testTable.length; y++) {
            for (int x = 0; x < testTable[y].length; x++) {
                testTable[y][x] = String.valueOf(y + x);
            }
        }

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                System.out.print(testTable[y][x] + "\t");
            }
            System.out.println();
        }

    }
}
