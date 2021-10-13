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

    // Создаём объект провайдера погоды
    WeatherProvider weatherProvider = new OpenWeatherMap();

    // Поле класса для проверки вариантов ввода
    Map<Integer, Functionality> variantPeriodWeather = new HashMap<>();

    public Controller() {
        this.variantPeriodWeather.put(0, Functionality.GET_NOW_WEATHER);
        this.variantPeriodWeather.put(1, Functionality.GET_CUSTOM_WEATHER);
        this.variantPeriodWeather.put(2, Functionality.GET_CUSTOM_WEATHER);
        this.variantPeriodWeather.put(3, Functionality.GET_CUSTOM_WEATHER);
        this.variantPeriodWeather.put(4, Functionality.GET_CUSTOM_WEATHER);
        this.variantPeriodWeather.put(5, Functionality.GET_FIVE_DAYS_WEATHER);
    }

    // Проверка ввода пользователя (!!! код взят с урока, разобраться с логикой)
    public void onUserInput(String input) throws IOException {

        int period = Integer.parseInt(input);

        if (!variantPeriodWeather.containsKey(period)) {
            throw new IOException("Для ввода: " + period + " отсутствует прогноз погоды");
        }

        switch (variantPeriodWeather.get(period)) {
            case GET_NOW_WEATHER:
                getCurrentWeather();
                break;
            case GET_CUSTOM_WEATHER:
                getWeatherCustomDays();
                break;
            case GET_FIVE_DAYS_WEATHER:
                getWeatherIn5Days();
                break;
        }
    }

    // Метод устанавливающий значение периода равным нулю
    public void getCurrentWeather() throws IOException {
        weatherProvider.getWeather(Periods.NOW);
    }

    // Метод устанавливающий значение периода равным значению от 1 до 4
    public void getWeatherCustomDays() throws IOException {
        weatherProvider.getWeather(Periods.CUSTOM);
    }

    // Метод устанавливающий значение периода равным пяти
    public void getWeatherIn5Days() throws IOException {
        weatherProvider.getWeather(Periods.FIVE_DAYS);
    }
}
