package HomeWork04;

import java.util.HashMap;
import java.util.Map;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 01.10.2021
 */

public class PhoneCard  {

    private HashMap<String, String> hashCard;

    // Конструктор класса
    public PhoneCard() {
        this.hashCard = new HashMap<>();
    }

    // Метод добавления записей в телефонную книгу
    public void add(String name, String phone) {
        hashCard.put(name, phone);
    }

    // Метод печати карточки в консоль
    public void printCard() {
        for (Map.Entry card : hashCard.entrySet()) {
            System.out.println("Абонент /" + card.getKey() + "/\t тел.: " + card.getValue());
        }
    }

    // Геттер
    public HashMap<String, String> getHashCard() {
        return hashCard;
    }
}
