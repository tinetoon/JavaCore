package lesson1.HomeWork01;

/**
 * Класс участников
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 16.09.2021
 */

public class Member {

    // Поля класса
    private int numberOfObstacles; // Количество препятствий, которое может преодолеть участник
    private int countMember = 0; // Номер участник

    // Конструктор
    public Member(int number) {
        this.numberOfObstacles = number;
        ++countMember;
    }

    // Метод вывода информации о членах команды
//    public void infoTeam() {
//        System.out.println("===== Карточка участника =====");
//        for (int i = 0; i < numberOfParticipants; i++) {
//        System.out.println("Участник № " + getCountMember()
//                + ", может преодолеть " + getNumberOfObstacles() + " препятствий.");
//        }
//        System.out.println("==============================");
//    }

    public int getNumberOfObstacles() {
        return numberOfObstacles;
    }

    public int getCountMember() {
        return countMember;
    }
}
