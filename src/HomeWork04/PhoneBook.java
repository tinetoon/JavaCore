package HomeWork04;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 01.10.2021
 *
 * 2. Написать простой класс «Телефонный Справочник», который хранит в себе список фамилий и телефонных номеров.
 * В этот телефонный справочник с помощью метода add() можно добавлять записи,
 * а с помощью метода get() искать номер телефона по фамилии.
 * Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 * тогда при запросе такой фамилии должны выводиться все телефоны.
 */

public class PhoneBook {

    private ArrayList<String> phoneBook;
    private HashMap<String, String> hashMap;

    public PhoneBook() {
        this.phoneBook = new ArrayList<>();
        this.hashMap = new HashMap<>();
    }

    // Метод добавления записей в телефонную книгу
    public void add(String name, String phone) {
        hashMap.put(name, phone);
    }

    // Метод поиска телефона
    public String get(String name) {
        return hashMap.get(name);
    }

    public void get2(String name) {
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println("Пользователь: " + entry.getKey() + ", тел.: " + entry.getValue() + " раз");
        }
    }
}
