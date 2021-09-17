package lesson1.HomeWork01;

import java.io.OptionalDataException;
import java.sql.Array;

/**
 * Класс команда
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 16.09.2021
 * 2. Добавить класс Team, который будет содержать:
 * - название команды;
 * - массив из четырех участников — в конструкторе можно сразу всех участников указывать);
 * - метод для вывода информации о членах команды, прошедших дистанцию;
 * - метод вывода информации обо всех членах команды.
 */

public class Team {

    public OptionalDataException getMembersTeam;
    // Создаём поля класса команда
    private String teamName; // название команды
    private int numberOfParticipants; // количество участников
    private int maxObstacles; // максимальное количество препятствий
    private Array membersTeam[];

    // Создаём конструктор
    public Team(String name, int number, int obstacles) {
        this.teamName = name;
        this.numberOfParticipants = number;
        this.maxObstacles = obstacles;

        dreamTeamBuilding(); // Создаём массив из участников
    }

    // Метод для создания массива участников
    public void dreamTeamBuilding() {
        Member[] membersTeam = new Member[5];
//        for (int i = 0; i < 5; i++) {
//            membersTeam[i] = new Member(Tools.random.nextInt(maxObstacles));
//        }

        membersTeam[0] = new Member(5);
        membersTeam[1] = new Member(4);
        membersTeam[2] = new Member(3);
        membersTeam[3] = new Member(2);
        membersTeam[4] = new Member(1);
//        membersTeam[5] = new Member(0);

        System.out.println(membersTeam.length);

        for (int i = 0; i < membersTeam.length; i++) {
            System.out.println("Участник № " + membersTeam[i].getCountMember()
                    + ", может преодолеть " + membersTeam[i].getNumberOfObstacles());
        }
    }

    // Метод вывода информации о членах команды
    public void infoTeam(int i) {
        System.out.println("===== Карточка участника =====");
        for (int i = 0; i < membersTeam.length; i++) {
            System.out.println("Участник № " + membersTeam[i].getCountMember()
                    + ", может преодолеть " + membersTeam[i].getNumberOfObstacles());
        }
        System.out.println("==============================");
    }

    public void print() {
        System.out.println(membersTeam[0].getC);
    }

    public Array[] getMembersTeam() {
        return membersTeam;
    }
}
