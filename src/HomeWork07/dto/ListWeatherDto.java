package HomeWork07.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 19.10.2021
 */

@JsonIgnoreProperties(ignoreUnknown = true) // Игнорируем лишние поля из строки JSON
public class ListWeatherDto {

    // Поля класса
    @JsonProperty("main")
    private MainDto mainDto;
    @JsonProperty("dt_txt")
    private String dataAndTime;

    // Пустой конструктор (для работы с библиотекой jackson)
    public ListWeatherDto() {
    }

    // Конструктор
    public ListWeatherDto(MainDto mainDto, String dataAndTime) {
        this.mainDto = mainDto;
        this.dataAndTime = dataAndTime;
    }

    // Геттеры
    @JsonGetter("main")
    public MainDto getMainDto() {
        return mainDto;
    }
    @JsonGetter("dt_txt")
    public String getDataAndTime() {
        return dataAndTime;
    }

    // Сеттеры
    @JsonSetter("main")
    public void setMainDto(MainDto mainDto) {
        this.mainDto = mainDto;
    }
    @JsonSetter("dt_txt")
    public void setDataAndTime(String dataAndTime) {
        this.dataAndTime = dataAndTime;
    }
}
