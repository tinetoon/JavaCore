package HomeWork05;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 02.10.2021
 */

public class HomeApp05 {

    public static void main(String[] args) {

        String[] value = new String[] {"value01", "value02", "value03"};
        int[][] intArr = new int[][] {{0,1,2}, {10,11,12}, {20,21,22}};

        AppData dataTest = new AppData(value, intArr);

        SaveCsv testCsv = new SaveCsv("Testfile.csv");

        testCsv.saveHeaderC(dataTest);
//        testCsv.saveDataB(dataTest);
    }
}
