package HomeWork07.classes;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 11.10.2021
 */

public class Main {
    private float temp;
    private float feelsLike;
    private float tempMin;
    private float tempMax;
    private float pressure;
    private float seaLevel;
    private float grndLevel;
    private float humidity;
    private float tempKf;
    private int day = 0;
    private int hour = 0;

    public static int contD = 0;
    public static int contH = 0;

    // Конструктор для счётчика объектов
    public Main() {
        this.day = contD;
        this.hour = contH;
        contH++;
        if (contH >= 24) {
            contD++;
        }
    }

    // Getter Methods
    public float getTemp() {
        return temp;
    }
    public float getFeelsLike() {
        return feelsLike;
    }
    public float getTempMin() {
        return tempMin;
    }
    public float getTempMax() {
        return tempMax;
    }
    public float getPressure() {
        return pressure;
    }
    public float getSeaLevel() {
        return seaLevel;
    }
    public float getGrndLevel() {
        return grndLevel;
    }
    public float getHumidity() {
        return humidity;
    }
    public float getTempKf() {
        return tempKf;
    }
    public int getDay() {
        return day;
    }
    public int getHour() {
        return hour;
    }

    // Setter Methods
    public void setTemp(float temp) {
        this.temp = temp;
    }
    public void setFeelsLike(float feelsLike) {
        this.feelsLike = feelsLike;
    }
    public void setTempMin(float tempMin) {
        this.tempMin = tempMin;
    }
    public void setTempMax(float tempMax) {
        this.tempMax = tempMax;
    }
    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
    public void setSeaLevel(float seaLevel) {
        this.seaLevel = seaLevel;
    }
    public void setGrndLevel(float grndLevel) {
        this.grndLevel = grndLevel;
    }
    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }
    public void setTempKf(float tempKf) {
        this.tempKf = tempKf;
    }
}
