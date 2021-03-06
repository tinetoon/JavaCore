package HomeWork07;

import HomeWork07.classes.City;
import HomeWork07.classes.ListWeather;
import HomeWork07.classes.Main;
import HomeWork07.classes.Root;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс ответа от сервера
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 10.10.2021
 */

public class WeatherResponse {

    // Временная переменная для хранения String ответа от сервера
    private String stringWeatherResponse;

    // Финальные переменные для доступа к полям Json строки
    public static final String TAG_COD = "cod";
    public static final String TAG_LIST = "list";
    public static final String TAG_LIST_DT = "dt";
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
    public static final String TAG_CITY = "city";
    public static final String TAG_CITY_NAME = "name";

    // Создаём объект с помощью библиотеки jackson для доступа к данным Json строки по ключу
    ObjectMapper objectMapper = new ObjectMapper();

    // Метод, возвращающий текущую погоду
    public double getTemperatureNow() throws JsonProcessingException {

        JsonNode temperatureNode = objectMapper.readTree(stringWeatherResponse).at("/main/temp");
        return temperatureNode.asDouble(); // возвращаем полученное значение, приведённое к типу double
    }

    // Метод парсинга и возврата ответа сервера в виде объекта
    public Root getTemperature() {

        Root root = new Root(); // Создаём объект класса Root
        JSONParser parser = new JSONParser(); // Объект парсера

        try {
            JSONObject rootJsonObject = (JSONObject) parser.parse(stringWeatherResponse); // Главный объект ответа сервера

            String cod = (String) rootJsonObject.get(TAG_COD);
            root.setCod(cod);

            JSONArray listWeatherJArr = (JSONArray) rootJsonObject.get(TAG_LIST);
            List<ListWeather> listWeatherList = new ArrayList<>(); // Объект погодного листа
            for (Object it: listWeatherJArr) {
                JSONObject listWeatherJObject = (JSONObject) it;

                long dt = (long) listWeatherJObject.get(TAG_LIST_DT);

                JSONObject mainJObject = (JSONObject) listWeatherJObject.get(TAG_LIST_MAIN);
                Main main = new Main();
                main.setTemp((Number) mainJObject.get(TAG_LIST_MAIN_TEMP));
                main.setFeelsLike((Number) mainJObject.get(TAG_LIST_MAIN_FEELS_LIKE));
                main.setTempMin((Number) mainJObject.get(TAG_LIST_MAIN_TEMP_MIN));
                main.setTempMax((Number) mainJObject.get(TAG_LIST_MAIN_TEMP_MAX));
                main.setPressure((Number) mainJObject.get(TAG_LIST_MAIN_PRESSURE));
                main.setSeaLevel((Number) mainJObject.get(TAG_LIST_MAIN_SEA_LEVEL));
                main.setGrndLevel((Number) mainJObject.get(TAG_LIST_MAIN_GRND_LEVEL));
                main.setHumidity((Number) mainJObject.get(TAG_LIST_MAIN_HUMIDITY));
                main.setTempKf((Number) mainJObject.get(TAG_LIST_MAIN_TEMP_KF));

                String dtTXt = (String) listWeatherJObject.get(TAG_LIST_DT_TXT);

                ListWeather listWeatherObject = new ListWeather(dt, main, dtTXt);
                listWeatherList.add(listWeatherObject);
            }
            root.setList((ArrayList) listWeatherList);

            JSONObject cityJObject = (JSONObject) rootJsonObject.get(TAG_CITY);
            City city = new City();
            String cityName = (String) cityJObject.get(TAG_CITY_NAME);
            city.setName(cityName);
            root.setCity(city);

            return root;
        } catch (Exception e) {
            System.out.println("Ошибка парсинга!!!" + e.toString());
            return null;
        }
    }

    // Геттер (!!! не используется в приложении)
    public String getStringWeatherResponse() {
        return stringWeatherResponse;
    }

    // Сеттер
    public void setStringWeatherResponse(String stringWeatherResponse) {
        this.stringWeatherResponse = stringWeatherResponse;
    }
}