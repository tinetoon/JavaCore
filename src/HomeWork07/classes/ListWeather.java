package HomeWork07.classes;

/**
 * Класс лист для ответа сервера
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 11.10.2021
 */

public class ListWeather {
    private float dt;
    Main MainObject;
    private String dt_txt;

    // Конструктор
    public ListWeather(float dt, Main mainObject, String dt_txt) {
        this.dt = dt;
        MainObject = mainObject;
        this.dt_txt = dt_txt;
    }

    // Getter Methods
    public float getDt() {
        return dt;
    }
    public Main getMain() {
        return MainObject;
    }
    public String getDt_txt() {
        return dt_txt;
    }
}
