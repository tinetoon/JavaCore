package Test;

import java.util.Locale;

/**
 * Класс тестирования различных примеров кода
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 20.08.2021
 */

public class Main {
    public static void main(String[] args) {

//        example01();
//        example02();
        example03();

    }

    // 1 пример
    public static void example01() {
        byte а = 127;
        а++; // пределы byte от -128 до 127 (с учётом 0)
        System.out.println("Пример 1, ответ: " + а);
    }

    // 02 пример
    public static void example02() {
        String a = "java";
        a.toUpperCase(); // Не изменяет строку, а только возвращает строку в верхнем регистре
        System.out.println(a);
        System.out.println(a.toUpperCase());
    }

    // 03 пример
    public static void example03() {
        String s1 = "Java";
        String s2 = new String("Java");
        System.out.print(s1 == s2); // Сравнивает ссылки на объекты - false
        System.out.print(" ");
        System.out.print(s1.equals(s2)); // Сравнивает посимвольно - true
    }

    // 0 пример
    public static void example0() {

    }
}