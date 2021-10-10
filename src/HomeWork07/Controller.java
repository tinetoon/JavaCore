package HomeWork07;

import HomeWork07.enums.Functionality;
import HomeWork07.enums.Periods;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс управления запросами
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 09.10.2021
 */

public class Controller {

    // Создаём объект провайдера погоды (!!! описать конструктор в классе OpenWeatherMap)
    WeatherProvider weatherProvider = new OpenWeatherMap();

    // Поле класса для проверки вариантов ввода
    Map<Integer, Functionality> variantPeriodWeather = new HashMap<>();

    public Controller() {
        this.variantPeriodWeather.put(1, Functionality.GET_NOW_WEATHER);
        this.variantPeriodWeather.put(5, Functionality.GET_FIVE_DAYS_WEATHER);
    }

    public void onUserInput(String input) throws IOException {

        int period = Integer.parseInt(input);

        if (!variantPeriodWeather.containsKey(period)) {
            throw new IOException("Для ввода: " + period + " отсутствует прогноз погоды");
        }

        switch (variantPeriodWeather.get(period)) {
            case GET_NOW_WEATHER:
                getCurrentWeather();
                break;
            case GET_FIVE_DAYS_WEATHER:
                getWeatherIn5Days();
                break;
        }
    }

    // Метод устанавливающий значение периода равным единице??? (!!! проверить)
    public void getCurrentWeather() throws IOException {
        weatherProvider.getWeather(Periods.NOW);
    }

    public void getWeatherIn5Days() {
        throw new RuntimeException("Добавить в h/w");
    }
}
