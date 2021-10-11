package HomeWork05;

/**
 * Класс для хранения данных
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 02.10.2021
 */

public class AppData {

    private String[] header;
    private int[][] data;

    // Конструктор класса
    public AppData(String[] header, int[][] data) {
        this.header = header;
        this.data = data;
    }

    // Геттеры
    public String[] getHeader() {
        return header;
    }
    public int[][] getData() {
        return data;
    }

    // Сеттеры
    public void setHeader(String[] header) {
        this.header = header;
    }
    public void setData(int[][] data) {
        this.data = data;
    }
}
