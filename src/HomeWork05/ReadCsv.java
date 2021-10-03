package HomeWork05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 02.10.2021
 *
 * 2. Реализовать загрузку данных из csv файла. Файл читается целиком.
 * Структура csv файла:
 * | Строка заголовок с набором столбцов |
 * | Набор строк с целочисленными значениями |
 * | * Разделитель между столбцами - символ точка с запятой (;) |
 */

public class ReadCsv {

    private File file;

    // Конструктор класса
    public ReadCsv(String nameFile) {

        this.file = new File(nameFile);
    }

    // Метод чтения данных из файла
    public void saveData() {

        AppData tmpData;
        ArrayList<String> headerList;
        ArrayList<Integer> dataList;

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String result = null;
            in.readLine(); // Читаем первую строку файла
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
