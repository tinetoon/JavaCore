package lesson1.HomeWork01;

/**
 * Класс полоса препятствий
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 18.09.2021
 * 3. Добавить класс Course (полоса препятствий), в котором будут находиться:
 * + массив препятствий;
 * - метод, который будет просить команду пройти всю полосу.
 */

public class Course {

    private int numberCourses; // Количество препятствий на полосе
    private Obstacles[] arrayObstacles;


    public Course(int number) {
        this.numberCourses = number;
        obstaclesBuilding();
        infoCourse();
    }

    // Метод для создания массива препятствий
    public void obstaclesBuilding() {
        arrayObstacles = new Obstacles[numberCourses];
        for (int i = 0; i < numberCourses; i++) {
            arrayObstacles[i] = new Obstacles(i + 1);
        }
    }

    // Метод вывода информации о полосе препятствий
    public void infoCourse() {
        System.out.println("===== Полоса препятствий =====");
        System.out.println("Количество препятствий: " + arrayObstacles.length);

        for (int i = 0; i < numberCourses; i++) {
            System.out.println("Препятствие № " + arrayObstacles[i].getCountCourses());
        }
        System.out.println("==============================");
    }

    // Метод, который просит команду пройти полосу препятствий
    public void doIt(Member[] team) {
        System.out.println("===== Соревнования =====");
        for (int i = 0; i < team.length; i++) {
            for (int j = 0; j < arrayObstacles.length; j++) {
                if (!team[i].goObstacles(j)) {
                    continue;
                } else System.out.println("Участник № " + team[i].getCountMember()
                        + " преодолел " + team[i].countObstacles(j + 1) + " препятствий");
            }

        }
    }
}
