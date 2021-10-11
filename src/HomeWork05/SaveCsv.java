package HomeWork05;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 02.10.2021
 *
 * 1. Реализовать сохранение данных в csv файл;
 */

public class SaveCsv {

    private File file;

    // Конструктор класса
    public SaveCsv(String nameFile) {

        this.file = new File(nameFile);
    }

    // Метод записи байт данных в файл
    public void saveDataInFile (AppData data) {
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(file))) {

            for (int i = 0; i < data.getHeader().length; i++) {
                out.write((data.getHeader()[i] + ";").getBytes(StandardCharsets.UTF_8));
            }

            out.write("\n".getBytes(StandardCharsets.UTF_8));

            for (int i = 0; i < data.getData().length; i++) {
                for (int j = 0; j < data.getData()[i].length; j++) {
                    out.write((Integer.toString(data.getData()[i][j]) + ";").getBytes(StandardCharsets.UTF_8));
                }
                out.write("\n".getBytes(StandardCharsets.UTF_8));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
