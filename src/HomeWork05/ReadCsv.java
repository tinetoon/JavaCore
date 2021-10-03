package HomeWork05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 02.10.2021
 *
 * 2. Реализовать загрузку данных из csv файла. Файл читается целиком.
 * Структура csv файла:
 * | Строка заголовок с набором столбцов |
 * | Набор строк с целочисленными значениями |
 * | * Разделитель между столбцами - символ точка с запятой (;) |
 *
 * Если выполняется save(AppData data), то старые данные в файле полностью перезаписываются.
 */

public class ReadCsv {

    private File file;

    // Конструктор класса
    public ReadCsv(String nameFile) {

        this.file = new File(nameFile);
    }

    // Метод чтения данных из файла
    public void readData() {

        ArrayList<String> headerList;
        ArrayList<Integer> dataList = new ArrayList<>();

        int numberOfLines = 0;
        int numberOfColumns = 0;

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String result = null;
            result = in.readLine(); // Читаем первую строку файла
            headerList = new ArrayList<>(Arrays.stream(result.split(";")).toList());

            // Печатаем хедер-лист
            System.out.print("headerList: ");
            for (int i = 0; i < headerList.size(); i++) {
                System.out.print(headerList.get(i) + ", ");
            }

            // Читаем остальные строки, после первой
            while ((result = in.readLine()) != null) {
                String[] tmp = result.split(";");
                for (int i = 0; i < tmp.length; i++) {
                    dataList.add(Integer.valueOf(tmp[i]));
                }
                numberOfLines++; // Считаем количество строк в файле
                numberOfColumns = tmp.length; // Считаем количество столбцов в файле
            }

            // Печатаем дата-лист
            System.out.print("dataList: ");
            for (int i = 0; i < dataList.size(); i++) {
                System.out.print(dataList.get(i) + ", ");
            }
            System.out.println();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод считающий строки в файле
    public int countLine() {

        int numberOfLines = 0;

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String result = null;

            // Читаем первую строку файла
            result = in.readLine();

            // Читаем остальные строки, после первой
            while ((result = in.readLine()) != null) {
                numberOfLines++; // Считаем количество строк в файле
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return numberOfLines;
    }

    // Метод считающий столбцы в файле
    public int countColumns() {

        ArrayList<String> headerList;

        int numberOfColumns = 0;

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String result = null;
            result = in.readLine(); // Читаем первую строку файла
            headerList = new ArrayList<>(Arrays.stream(result.split(";")).toList());
            numberOfColumns = headerList.size();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return numberOfColumns;
    }

    // Метод создающий массив заголовка
    public String[] headerArr() {

        ArrayList<String> headerList;

        String[] headerArr = new String[countColumns()];

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String result = null;
            result = in.readLine(); // Читаем первую строку файла
            headerList = new ArrayList<>(Arrays.stream(result.split(";")).toList());

            // Инициализируем массив заголовка
            for (String s: headerList) {
                headerArr[headerList.indexOf(s)] = s;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return headerArr;
    }

    // Метод создающий массив с данными
    public int[][] dataArr() {

        ArrayList<Integer> dataList = new ArrayList<>();

        int iMax = countLine();
        int jMax = countColumns();
        int[][] dataArr = new int[iMax][jMax];

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String result = null;
            result = in.readLine(); // Читаем первую строку файла

            // Инициализируем массив с данными
            while ((result = in.readLine()) != null) {
                for (int i = 0; i < iMax; i++) {
                    String[] tmp = result.split(";"); // Со строки берём временный массив
                    for (int j = 0; j < jMax; j++) {
                        dataArr[i][j] = Integer.valueOf(tmp[j]); // Инициализируем строку массива с данными временным массивом
                    }
                    result = in.readLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataArr;
    }

    // Метод сохранения данных
    public void save(AppData data) {
        data.setHeader(headerArr());
        data.setData(dataArr());
    }
}
