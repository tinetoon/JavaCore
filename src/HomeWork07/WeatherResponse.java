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

    private String stringWeatherResponse;

    ObjectMapper objectMapper = new ObjectMapper();

    public double getTemperatureNow() throws JsonProcessingException {

        JsonNode temperatureNode = objectMapper.readTree(stringWeatherResponse).at("/main/temp");
        return temperatureNode.asDouble();
    }

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