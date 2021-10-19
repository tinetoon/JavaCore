package HomeWork07.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 19.10.2021
 */

@JsonIgnoreProperties(ignoreUnknown = true) // Игнорируем лишние поля из строки JSON
public class RootDto {

    // Поля класса
    @JsonProperty("list")
    private List<ListWeatherDto> listWeather;
    @JsonProperty("city")
    private CityDto city;

    // Пустой конструктор (для работы с библиотекой jackson)
    public RootDto() {
    }

    // Конструктор
    public RootDto(List<ListWeatherDto> listWeather, CityDto city) {
        this.listWeather = listWeather;
        this.city = city;
    }

    // Геттеры
    @JsonGetter("list")
    public List<ListWeatherDto> getListWeather() {
        return listWeather;
    }
    @JsonGetter("city")
    public CityDto getCity() {
        return city;
    }

    // Сеттеры
    @JsonSetter("list")
    public void setListWeather(List<ListWeatherDto> listWeather) {
        this.listWeather = listWeather;
    }
    @JsonSetter("city")
    public void setCity(CityDto city) {
        this.city = city;
    }
}
