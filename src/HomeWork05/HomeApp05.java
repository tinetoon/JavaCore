package HomeWork05;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 02.10.2021
 */

public class HomeApp05 {

    public static void main(String[] args) {

        // Готовим данные для записи в базу данных
        String[] value1 = new String[] {"value01", "value02", "value03"};
        int[][] intArr1 = new int[][] {{0,1,2}, {10,11,12}, {20,21,22}};

        String[] value2 = new String[] {"value01", "value02", "value03", "value04"};
        int[][] intArr2 = new int[][] {{0,1,2,3}, {10,11,12,13}, {20,21,22,23}, {30,31,32,33}};

        // Создаём базы данных
        AppData dataTest = new AppData(value1, intArr1);
        AppData dataBase01 = new AppData(value1, intArr1);
        AppData dataBase02 = new AppData(value2, intArr2);

        // Создаём файлы на диске и записываем в них данные из БД
        SaveCsv file01 = new SaveCsv("File01.csv");
        file01.saveDataInFile(dataBase01);

        SaveCsv file02 = new SaveCsv("File02.csv");
        file02.saveDataInFile(dataBase02);

        // Создаём объекты чтения файлов
        ReadCsv readFile01 = new ReadCsv("File01.csv");
        ReadCsv readFile02 = new ReadCsv("File02.csv");

        // Запишем данные из файла File01.csv в БД dataTest и сохраним их в файл File03.csv
        readFile01.save(dataTest);
        SaveCsv file03 = new SaveCsv("File03.csv");
        file03.saveDataInFile(dataTest);

        // Выведем в консоль данные из файла File03.csv
        ReadCsv readFile03 = new ReadCsv("File03.csv");
        printHeader(readFile03.headerArr());
        printData(readFile03.dataArr());

        // Заменим данные в тестовой БД на данные из файла File02.csv и перезапишем файл File03.csv
        readFile02.save(dataTest);
        file03.saveDataInFile(dataTest);

        // Заново выведем в консоль данные из файла File03.csv
        printHeader(readFile03.headerArr());
        printData(readFile03.dataArr());

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
