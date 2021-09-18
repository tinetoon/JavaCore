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
    private int maxSkillObstacles; // максимальное количество препятствий, которое может преодолеть участник в результате тренировок
    private Member[] membersTeam;

    // Создаём конструктор
    public Team(String name, int number, int obstacles) {
        this.teamName = name;
        this.numberOfParticipants = number;
        this.maxSkillObstacles = obstacles;

//        membersTeam = new Member[5]; // Создаём массив из участников
        dreamTeamBuilding(); // Создаём массив из участников

//        membersTeam[0] = new Member(5);
//        membersTeam[1] = new Member(10);
//        membersTeam[2] = new Member(15);
//        membersTeam[3] = new Member(20);
//        membersTeam[4] = new Member(25);

        infoTeam();
    }

    // Метод для создания массива участников
    public void dreamTeamBuilding() {
        membersTeam = new Member[5];
        for (int i = 0; i < 5; i++) {
            membersTeam[i] = new Member(maxSkillObstacles);
//            membersTeam[i] = new Member(Tools.random.nextInt(maxSkillObstacles + maxSkillObstacles/2));
        }
//        return arr;
//        System.out.println("Длина массива участников: " + arr.length);
//
//        for (int i = 0; i < membersTeam.length; i++) {
//            System.out.println("Участник № " + membersTeam[i].getCountMember()
//                    + ", может преодолеть " + membersTeam[i].getNumberOfObstacles() + " препятствий");
//        }

//        infoTeam();
    }

    // Метод вывода информации о всех членах команды
    public void infoTeam() {
        System.out.println("===== Карточка участников =====");
        System.out.println("Длина массива участников: " + membersTeam.length);

        for (int i = 0; i < 5; i++) {
            System.out.println("Участник № " + membersTeam[i].getCountMember()
                    + ", может преодолеть " + membersTeam[i].getNumberOfObstacles() + " препятствий");
        }
        System.out.println("==============================");
    }

//    public Array[] getMembersTeam() {
//        return membersTeam;
//    }

    public String getTeamName() {
        return teamName;
    }
}
