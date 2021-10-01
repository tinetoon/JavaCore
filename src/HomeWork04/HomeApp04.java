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

        String[] Lorem = new String[] {"Сегодня", "отличный", "день", "я", "пошёл", "сегодня", "домой", "после",
                "работы", "дома", "меня", "ждал", "кот", "я", "люблю", "своего", "кота",
                "и", "сегодня", "у", "моего", "кота", "тоже", "отличный", "день"};

        Set<String> uniqWord = new HashSet<>(Arrays.asList(Lorem));
        System.out.println("Всего слов: " + Lorem.length);
        System.out.println("Количество уникальных слов: " + uniqWord.size());
        System.out.println(uniqWord);

        Map<String, Integer> letters = collection(Lorem);
        printCollection(letters);

        PhoneBook directory = new PhoneBook();
        directory.add("Антон", "+79991234567(1)");
        directory.add("Сергей", "+79991234567");
        directory.add("Борис", "+79991234567");
        directory.add("Антон", "+79991234567(2)");
        System.out.println("Сергей, тел.: " + directory.get("Сергей"));
        System.out.println("Антон, тел.: " + directory.get("Антон"));

    }

    // Метод подсчёта уникальных слов
    public static Map<String, Integer> collection (String[] arr) {
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

}
