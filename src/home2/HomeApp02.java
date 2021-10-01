package home2;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 18.09.2021
 *
 * + 1. Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
 * + При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 *
 * + 2. Далее метод должен пройтись по всем элементам массива,
 * + преобразовать в int и просуммировать.
 * + Если в каком-то элементе массива преобразование не удалось
 * + (например, в ячейке лежит символ или текст вместо числа),
 * + должно быть брошено исключение MyArrayDataException с детализацией,
 * + в какой именно ячейке лежат неверные данные.
 *
 * - 3. В методе main() вызвать полученный метод,
 * - обработать возможные исключения MyArraySizeException и MyArrayDataException
 * - и вывести результат расчета.
 */

public class HomeApp02 {

    private static String[][] testArray44;
    private static String[][] testArray66;
    private static String[][] testArray22;
    private static String[][] testArraySymbol22;
    private static String[][] testArraySymbol44;

    public static void main(String[] args) {

        testArray44 = new String[4][4];
        testArray66 = new String[6][6];
        testArray22 = new String[2][2];
        testArraySymbol22 = new String[2][2];
        testArraySymbol44 = new String[4][4];

        arrayEx(testArray44);
        arrayEx(testArray66);
        arrayEx(testArray22);

        testArraySymbol22[0][0] = "1";
        testArraySymbol22[0][1] = "2";
        testArraySymbol22[1][0] = "3";
        testArraySymbol22[1][1] = "@";

        testArraySymbol44[0][0] = "1";
        testArraySymbol44[0][1] = "1";
        testArraySymbol44[0][2] = "1";
        testArraySymbol44[0][3] = "1";
        testArraySymbol44[1][0] = "2";
        testArraySymbol44[1][1] = "2";
        testArraySymbol44[1][2] = "2";
        testArraySymbol44[1][3] = "@";
        testArraySymbol44[2][0] = "3";
        testArraySymbol44[2][1] = "3";
        testArraySymbol44[2][2] = "3";
        testArraySymbol44[2][3] = "3";
        testArraySymbol44[3][0] = "4";
        testArraySymbol44[3][1] = "4";
        testArraySymbol44[3][2] = "4";
        testArraySymbol44[3][3] = "4";

        stringToIntArr(testArray22);
        stringToIntArr(testArraySymbol22);
        stringToIntArr(testArraySymbol44);

        for (int y = 0; y < testArraySymbol44.length; y++) {
            for (int x = 0; x < testArraySymbol44[y].length; x++) {
                System.out.print(testArraySymbol44[y][x] + "\t");
            }
            System.out.println();
        }

//        try {
//            printArray(testArray44);
//        } catch (ArrayIndexOutOfBoundsException MyArraySizeException) {
////            MyArraySizeException.printStackTrace();
//            System.out.println("Ошибка размера массива");
//        } catch (NullPointerException Ex) {
//            System.out.println("Ошибка элемента массива");
//        }
//
//        try {
//            printArray(testArray66);
//        } catch (ArrayIndexOutOfBoundsException MyArraySizeException) {
////            MyArraySizeException.printStackTrace();
//            System.out.println("Ошибка размера массива");
//        } catch (NullPointerException Ex) {
//            System.out.println("Ошибка элемента массива");
//        }
//
//        try {
//            printArray(testArray22);
//        } catch (ArrayIndexOutOfBoundsException MyArraySizeException) {
////            MyArraySizeException.printStackTrace();
//            System.out.println("Ошибка размера массива");
//        } catch (NullPointerException Ex) {
//            System.out.println("Ошибка элемента массива");
//        }

//        printArray(testArray44);
//        printArray(testArray66);
//        printArray(testArray22);
    }

    // Метод инициализации массива
    public static void creationArray(String[][] arr) {

        System.out.println("===== Новый массив =====");

        for (int y = 0; y < arr.length; y++) {
            for (int x = 0; x < arr[y].length; x++) {
                arr[y][x] = String.valueOf(y + x);
            }
        }
    }

    // Метод печати элементов массива
    public static void printArray(String[][] arr) throws ArrayIndexOutOfBoundsException, NullPointerException {

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                System.out.print(arr[y][x] + "\t");
            }
            System.out.println();
        }

    }

    // Метод обработки исключений массива
    public static void arrayEx(String[][] arr) {
        try {
            creationArray(arr);
            printArray(arr);
        } catch (ArrayIndexOutOfBoundsException MyArraySizeException) {
            System.out.println("Ошибка размера массива");
        } catch (NullPointerException Ex) {
            System.out.println("Ошибка элемента массива");
        }
    }

    // Метод преобразования элементов массива
    public static void stringToIntArr(String[][] arr) throws NumberFormatException {
        int tmp = 0;
        int currentY = 0;
        int currentX = 0;
        try {
            for (int y = 0; y < arr.length; y++) {
                currentY = y;
                for (int x = 0; x < arr[y].length; x++) {
                    currentX = x;
                    tmp += Integer.valueOf(arr[y][x]);
                }
            }
            System.out.println("Сумма чисел массива: " + tmp);
        } catch (NumberFormatException MyArrayDataException) {
            System.out.println("Неверный формат элемента массива в ячейке: " + currentY + ":" + currentX);
        }
    }

}
