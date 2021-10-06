package HomeWork04;

import java.util.ArrayList;

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

    private ArrayList<PhoneCard> phoneBook;

    // Конструктор класса
    public PhoneBook() {
        this.phoneBook = new ArrayList<>();
    }

    // Метод добавления записей в телефонную книгу
    public void add(String name, String phone) {
//        hashMap.put(name, phone);
        PhoneCard field = new PhoneCard();
        field.add(name, phone);
        phoneBook.add(field);
    }

    // Геттер
    public ArrayList<PhoneCard> getPhoneBook() {
        return phoneBook;
    }
}
