package HomeWork07.classes;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 11.10.2021
 */

public class Main<T extends Number> {
    private T temp;
    private T feelsLike;
    private T tempMin;
    private T tempMax;
    private T pressure;
    private T seaLevel;
    private T grndLevel;
    private T humidity;
    private T tempKf;
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
    public T getTemp() {
        return temp;
    }
    public T getFeelsLike() {
        return feelsLike;
    }
    public T getTempMin() {
        return tempMin;
    }
    public T getTempMax() {
        return tempMax;
    }
    public T getPressure() {
        return pressure;
    }
    public T getSeaLevel() {
        return seaLevel;
    }
    public T getGrndLevel() {
        return grndLevel;
    }
    public T getHumidity() {
        return humidity;
    }
    public T getTempKf() {
        return tempKf;
    }
    public int getDay() {
        return day;
    }
    public int getHour() {
        return hour;
    }

    // Setter Methods
    public void setTemp(T temp) {
        this.temp = temp;
    }
    public void setFeelsLike(T feelsLike) {
        this.feelsLike = feelsLike;
    }
    public void setTempMin(T tempMin) {
        this.tempMin = tempMin;
    }
    public void setTempMax(T tempMax) {
        this.tempMax = tempMax;
    }
    public void setPressure(T pressure) {
        this.pressure = pressure;
    }
    public void setSeaLevel(T seaLevel) {
        this.seaLevel = seaLevel;
    }
    public void setGrndLevel(T grndLevel) {
        this.grndLevel = grndLevel;
    }
    public void setHumidity(T humidity) {
        this.humidity = humidity;
    }
    public void setTempKf(T tempKf) {
        this.tempKf = tempKf;
    }
}
