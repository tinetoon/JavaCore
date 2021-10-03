package HomeWork05;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 02.10.2021
 */

public class HomeApp05 {

    public static void main(String[] args) {

        String[] value1 = new String[] {"value01", "value02", "value03"};
        int[][] intArr1 = new int[][] {{0,1,2}, {10,11,12}, {20,21,22}};

//        AppData dataTest = new AppData(value1, intArr1); // Используем временный объект с данными для реализации сохранения их в файл
//        SaveCsv testCsv = new SaveCsv("Testfile.csv"); // Создаём тестовый файл
//        testCsv.saveDataInFile(dataTest); // Записываем данные в тестовый файл

//        ReadCsv readTest = new ReadCsv("Testfile.csv"); // Создаём новый объект чтения файла Testfile.csv
//        readTest.readData(); // Проверяем данные в файле (отладочная операция)
//        System.out.println("Количество столбцов в файле: " + readTest.countColumns()); // отладка
//        System.out.println("Количество строк в файле, без учёта строки заголовка: " + readTest.countLine()); // отладка
//        printHeader(readTest.headerArr()); // отладка
//        printData(readTest.dataArr());// отладка

        String[] value2 = new String[] {"value01", "value02", "value03", "value04"};
        int[][] intArr2 = new int[][] {{0,1,2,3}, {10,11,12,13}, {20,21,22,23}, {30,31,32,33}};

    }

    // Метод печати заголовка в консоль
    public static void printHeader(String[] arr) {
        System.out.println("\nМассив headerArr: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    // Метод печати данных в консоль
    public static void printData(int[][] arr) {
        System.out.println("\nМассив dataArr: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
