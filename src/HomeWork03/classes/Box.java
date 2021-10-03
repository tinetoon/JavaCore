package HomeWork03.classes;

import java.util.ArrayList;

/**
 * Класс коробка
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 25.09.2021
 *
 * + В класс Box можно складывать фрукты.
 * + Коробки условно сортируются по типу фрукта,
 * + поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
 * + Для хранения фруктов внутри коробки можно использовать ArrayList;
 *
 * + Сделать метод getWeight(), который высчитывает вес коробки,
 * + зная вес одного фрукта и их количество:
 * + вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
 *
 * + Внутри класса Box сделать метод compare(),
 * + который позволяет сравнить текущую коробку с той,
 * + которую подадут в compare() в качестве параметра.
 * + true – если их массы равны,
 * + false в противоположном случае.
 * + Можно сравнивать коробки с яблоками и апельсинами;
 */

public class Box<T extends Fruit> {

    private T fruit;
    private ArrayList<T> listBox;

    // Конструктор класса для пустой коробки
    public Box(Class<T> obj) {
        listBox = new ArrayList<>();
    }

    // Перегруженный конструктор класса для одного фрукта
    public Box(Class<T> obj, T Fruit) {
        listBox = new ArrayList<>();
        addFruit(Fruit);
    }

    // Метод добавления фруктов в коробку
    public void addFruit(T fruit) {
        listBox.add(fruit);
    }

    // Метод вычисления веса коробки
    public float getWeight(ArrayList<T> list, float fruitWeight) {
        float weight = 0;

        weight = (float) list.size() * fruitWeight;

        return weight;
    }

    // Метод сравнения коробок
    public boolean compare(ArrayList<?> list) {
        return listBox.size() == list.size();
    }

    public T getFruit() {
        return fruit;
    }

    public ArrayList<T> getListBox() {
        return listBox;
    }
}
