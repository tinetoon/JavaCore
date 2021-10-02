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

//        String[] Lorem = new String[] {"Lorem", "ipsum", "dolor", "sit", "amet", "consectetur", "adipiscing", "elit.",
//                "Quisque", "mollis", "suscipit", "felis", "hendrerit", "auctor.",
//                "Quisque", "ac", "mi", "viverra", "pretium", "tortor"};

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
//        System.out.println("Сергей, тел.: " + directory.get("Сергей"));
//        System.out.println("Антон, тел.: " + directory.get("Антон"));

        get2(directory, "Антон");
        get2(directory, "Иван");

        PhoneBook directory2 = new PhoneBook();
        get2(directory2, "Иван");

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
    public static PhoneCard get(PhoneBook book, String name) {
//        return hashMap.get(name);

        PhoneCard tempCard = new PhoneCard(); // Объявляем временную карточку

        tempCard.add(name, "Номер неизвестен"); // Значение по умолчанию

        if (!book.getPhoneBook().isEmpty()) { // Проверяем пустоту телефонной книги

            for (PhoneCard card : book.getPhoneBook()) { // Бежим по всем элементам телефонной книги
//                System.out.println(card.containsKey(name));
                if (card.getHashCard().containsKey(name)) { // Проверяем наличие ключа с именем
                    tempCard.add(name, card.getHashCard().get(name)); // Если всё ОК, присваиваем номер во временную карточку и возвращаем её
                    return card;
                } else {
                    return tempCard;
                }
            }
        } else {
            System.out.println("Телефонная книга пуста");
        }
        return tempCard;
    }

    // Метод поиска телефона
    public static void get2(PhoneBook book, String name) {
//        return hashMap.get(name);

        PhoneCard tempCard = new PhoneCard(); // Объявляем временную карточку

        tempCard.add(name, "Номер неизвестен"); // Значение по умолчанию
        int tmpGood = 0;

        if (!book.getPhoneBook().isEmpty()) { // Проверяем пустоту телефонной книги

            for (PhoneCard card : book.getPhoneBook()) { // Бежим по всем элементам телефонной книги
//                System.out.println(card.containsKey(name));
                if (card.getHashCard().containsKey(name)) { // Проверяем наличие ключа с именем
//                    tempCard.add(name, card.getHashCard().get(name)); // Если всё ОК, присваиваем номер во временную карточку и возвращаем её
                    card.printCard();
                    tmpGood = 1;
                }
            }

            if (tmpGood == 0) {
                    tempCard.printCard();
            }
        } else {
            System.out.println("Телефонная книга пуста");
        }
//        tempCard.printCard();
    }

}
