package HomeWork07;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Класс ответа от сервера
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 10.10.2021
 */

public class WeatherResponse {

    // Временная переменная для хранения String ответа от сервера
    private String stringWeatherResponse;

    // Финальные переменные для доступа к полям Json строки
    public static final String TAG_LIST = "list";
    public static final String TAG_LIST_DT = "";
    public static final String TAG_LIST_MAIN = "main";
    public static final String TAG_LIST_MAIN_TEMP = "temp";
    public static final String TAG_LIST_MAIN_FEELS_LIKE = "feels_like";
    public static final String TAG_LIST_MAIN_TEMP_MIN = "temp_min";
    public static final String TAG_LIST_MAIN_TEMP_MAX = "temp_max";
    public static final String TAG_LIST_MAIN_PRESSURE = "pressure";
    public static final String TAG_LIST_MAIN_SEA_LEVEL = "sea_level";
    public static final String TAG_LIST_MAIN_GRND_LEVEL = "grnd_level";
    public static final String TAG_LIST_MAIN_HUMIDITY = "humidity";
    public static final String TAG_LIST_MAIN_TEMP_KF = "temp_kf";
    public static final String TAG_LIST_DT_TXT = "dt_txt";

    // Создаём объект с помощбю билиотеки jackson для доступа к данным Json строки по ключу
    ObjectMapper objectMapper = new ObjectMapper();

    // Создаём массив данных

    // Метод, возврашающий текущую погоду
    public double getTemperatureNow() throws JsonProcessingException {

        JsonNode temperatureNode = objectMapper.readTree(stringWeatherResponse).at("/main/temp");
        return temperatureNode.asDouble(); // возвращаем полученое значение, приведённое к типу double
    }

    // Метод, возвращающий температуру за пять дней (!!! требуется описание логики)
    public double getTemperature() throws JsonProcessingException {

        JsonNode temperatureNode = objectMapper.readTree(stringWeatherResponse).at("/list/main/temp");

        return temperatureNode.asDouble();
    }

    public String getStringWeatherResponse() {
        return stringWeatherResponse;
    }

    public void setStringWeatherResponse(String stringWeatherResponse) {
        this.stringWeatherResponse = stringWeatherResponse;
    }
}