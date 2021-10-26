package HomeWork07.classes;

import java.util.ArrayList;

/**
 * Главный класс для ответа сервера
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 11.10.2021
 */

public class Root {

    private String cod;
    ArrayList<Object> list = new ArrayList<>();
    City CityObject;


    // Getter Methods
    public String getCod() {
        return cod;
    }
    public ArrayList<Object> getList() {
        return list;
    }
    public City getCity() {
        return CityObject;
    }

    // Setter Methods
    public void setCod(String cod) {
        this.cod = cod;
    }
    public void setList(ArrayList<Object> list) {
        this.list = list;
    }
    public void setCity(City cityObject) {
        this.CityObject = cityObject;
    }
}
