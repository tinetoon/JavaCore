package HomeWork04;

import java.util.*;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 01.10.2021
 *
 * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 * Посчитать, сколько раз встречается каждое слово.
 */

public class HomeApp04 {

    public static void main(String[] args) {

        System.out.println("===== Задание № 1 =====");

        String[] Lorem = new String[] {"Сегодня", "отличный", "день", "я", "пошёл", "сегодня", "домой", "после",
                "работы", "дома", "меня", "ждал", "кот", "я", "люблю", "своего", "кота",
                "и", "сегодня", "у", "моего", "кота", "тоже", "отличный", "день"};

        Set<String> uniqWord = new HashSet<>(Arrays.asList(Lorem));
        for (int i = 0; i < Lorem.length; i++) {
            System.out.print(Lorem[i] + " ");
        }

        // Выводим на печать количество слов в массиве
        System.out.println("\nВсего слов: " + Lorem.length);

        // Подсчитываем уникальные слова и выводим их на печать
        System.out.println("Количество уникальных слов: " + uniqWord.size());
        System.out.println(uniqWord);

        // Подсчитываем и выводим в консоль количество повторений слов
        Map<String, Integer> letters = wordCount(Lorem);
        printCollection(letters);

        System.out.println("===== Задание № 2 =====");

        // Создаём новую телефонную книгу
        PhoneBook directory = new PhoneBook();
        directory.add("Антон", "+79991234567(1)");
        directory.add("Сергей", "+79991234567");
        directory.add("Борис", "+79991234567");
        directory.add("Антон", "+79991234567(2)");

        // Ищем в телефонной книге directory абонентов
        get(directory, "Антон");
        get(directory, "Иван");

        // Создадим пустую телефонную книгу и проведём по ней поиск
        PhoneBook directory2 = new PhoneBook();
        get(directory2, "Иван");

    }

    // Метод подсчёта уникальных слов
    public static Map<String, Integer> wordCount (String[] arr) {
        Map<String, Integer> collection = new HashMap<String, Integer>();

        for (int i = 0; i < Arrays.asList(arr).size(); i++) {
            String tempChar = Arrays.asList(arr).get(i);

            if (!collection.containsKey(tempChar)) {
                collection.put(tempChar, 1);
            } else {
                collection.put(tempChar, collection.get(tempChar) + 1);
            }
        }
        return collection;
    }

    // Метод печати в консоль коллекции
    public static void printCollection (Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Слово /" + entry.getKey() + "/\t повторяется " + entry.getValue() + " раз");
        }
    }

    // Метод поиска телефона
    public static void get(PhoneBook book, String name) {

        PhoneCard tempCard = new PhoneCard(); // Объявляем временную карточку

        tempCard.add(name, "Номер неизвестен"); // Значение по умолчанию
        int tmpGood = 0; // Временный ключ проверки поиска имени (0 - имя не найдено, 1 - имя найдено)

        if (!book.getPhoneBook().isEmpty()) { // Проверяем пустоту телефонной книги

            for (PhoneCard card : book.getPhoneBook()) { // Бежим по всем элементам телефонной книги
                if (card.getHashCard().containsKey(name)) { // Проверяем наличие ключа с именем
                    card.printCard(); // Если всё ОК, печатаем карточку
                    tmpGood = 1; // Меняем ключ проверки поиска имени
                }
            }

            if (tmpGood == 0) {
                    tempCard.printCard();
            }
        } else {
            System.out.println("Телефонная книга пуста");
        }
    }

}
