package HomeWork03;

import HomeWork03.classes.Apple;
import HomeWork03.classes.Box;
import HomeWork03.classes.Fruit;
import HomeWork03.classes.Orange;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 23.09.2021
 *
 * 1. Написать метод, который меняет два элемента массива местами
 * (массив может быть любого ссылочного типа);
 */

public class HomeApp03 {

    public static void main(String[] args) {

        // Объявляем и инициализируем новый строковый массив
        NewArray<String> newStringArr2 = new NewArray<>(String.class,
                "Каждый", "Охотник", "Желает", "Знать", "Где", "Сидит", "Фазан");

        // Печатаем информацию о массиве в консоль
        System.out.println("1.1 Оригинальный ссылочный массив");
        newStringArr2.printArray();

        // Вызываем метод замены элементов (меняем местами первый и шестой элементы)
        newStringArr2.swapElements(newStringArr2.getNewArray(), 1, 6);

        // Проверяем работу метода повторным выводом в консоль информации о массиве
        System.out.println("1.2 Новый ссылочный массив");
        newStringArr2.printArray();

//        // Создаём коробку с апельсинами
//        Orange orange01 = new Orange();
//        Box<Orange> boxOrange01 = new Box<>(Orange.class, orange01);
//
//        // Добавляем в коробку второй апельсин
//        Orange orange02 = new Orange();
//        boxOrange01.addFruit(orange02);
        // Выводим в консоль информацию о выполнении второго задания
        System.out.println("====== 2. Магазин фруктов ======");

        // Создаём коробку с апельсинами
        Box<Orange> boxOrange01 = new Box<>(Orange.class);
        multiplicationOrange(boxOrange01, 2);
        System.out.println("Вес коробки с апельсинами: "
                + boxOrange01.getWeight(boxOrange01.getListBox(), boxOrange01.getListBox().get(0).getWeight()));

        // Создаём коробку с пятью яблоками
        Box<Apple> boxApple01 = new Box<>(Apple.class);
        multiplicationApple(boxApple01, 5);
        System.out.println("Вес коробки с яблоками № 1: " + boxApple01.getWeight(boxApple01.getListBox(),
                boxApple01.getListBox().get(0).getWeight()));
//        Apple apple01 = new Apple();
//        Apple apple02 = new Apple();
//        Apple apple03 = new Apple();
//        boxApple01.addFruit(apple01);
//        boxApple01.addFruit(apple02);
//        boxApple01.addFruit(apple03);
//        for (int i = 0; i < 5; i++) {
//            Apple[] appleArr = new Apple[5];
//            appleArr[i] = new Apple();
//            boxApple01.addFruit(appleArr[i]);
//        }

        // Создаём коробку с двумя яблоками
        Box<Apple> boxApple02 = new Box<>(Apple.class);
        multiplicationApple(boxApple02, 2);
        System.out.println("Вес коробки с яблоками № 2: " + boxApple02.getWeight(boxApple02.getListBox(),
                boxApple02.getListBox().get(0).getWeight()));

        // Выводим информацию в консоль о количестве фруктов в коробках
        System.out.println("В коробке с апельсинами: " + boxOrange01.getListBox().size() + " апельсина");
        System.out.println("В коробке с яблоками № 1: " + boxApple01.getListBox().size() + " яблок");
        System.out.println("В коробке с яблоками № 2: " + boxApple02.getListBox().size() + " яблока");

//        System.out.println("В коробке с апельсинами и яблоками № 1 одинаковое количество фруктов: "
//                + boxOrange01.compare(boxApple01.getListBox()));
//        System.out.println("В коробке с апельсинами и яблоками № 2 одинаковое количество фруктов: "
//                + boxOrange01.compare(boxApple02.getListBox()));
//        System.out.println("Коробка с апельсинами: " + boxOrange01.getListBox().get(0));
//        System.out.println("Коробка с яблоками № 1: " + boxApple01.getListBox().get(0));
//        System.out.println("Коробка с яблоками № 2: " + boxApple02.getListBox().get(0));
//        System.out.println("Проверка наличия в коробке апельсинов: " + (boxOrange01.getListBox().get(0) instanceof Orange));
//        System.out.println("Проверка наличия в коробке апельсинов: " + (boxOrange01 instanceof Box<Orange>));

        reMultiplicationApple(boxApple01, boxApple02);
        System.out.println("Пересыпаем яблоки из коробки № 1 в коробку № 2.");
        System.out.println("В коробке с яблоками № 1: " + boxApple01.getListBox().size() + " яблок");
        System.out.println("В коробке с яблоками № 2: " + boxApple02.getListBox().size() + " яблок");
    }

    // Метод для наполнения коробки апельсинами
    public static void multiplicationOrange(Box<Orange> box, int contOrange) {
        for (int i = 0; i < contOrange; i++) {
            Orange[] orangeArr = new Orange[contOrange];
            orangeArr[i] = new Orange();
            box.addFruit(orangeArr[i]);
        }
    }

    // Метод для наполнения коробки яблоками
    public static void multiplicationApple(Box<Apple> box, int contApple) {
        for (int i = 0; i < contApple; i++) {
            Apple[] appleArr = new Apple[contApple];
            appleArr[i] = new Apple();
            box.addFruit(appleArr[i]);
        }
    }

    // Метод для пересыпания фруктов из одной коробки в другую
    public static void reMultiplicationApple(Box<? extends Fruit> box1, Box<? extends Fruit> box2) {
        if (box1.getListBox().get(0) instanceof Orange && box1.getListBox().get(0) instanceof Orange) {
            multiplicationOrange((Box<Orange>) box2, box1.getListBox().size());
            box1.getListBox().removeAll(box1.getListBox());
        }
        if (box1.getListBox().get(0) instanceof Apple && box1.getListBox().get(0) instanceof Apple) {
            multiplicationApple((Box<Apple>) box2, box1.getListBox().size());
            box1.getListBox().removeAll(box1.getListBox());
        }
    }

}
