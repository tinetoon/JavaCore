package lesson1.HomeWork01;

import java.io.OptionalDataException;
import java.sql.Array;

/**
 * Класс команда
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 16.09.2021
 * 2. Добавить класс Team, который будет содержать:
 * + название команды;
 * + массив из четырех участников — в конструкторе можно сразу всех участников указывать);
 * + метод для вывода информации о членах команды, прошедших дистанцию;
 * + метод вывода информации обо всех членах команды.
 */

public class Team {

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

        dreamTeamBuilding(); // Создаём массив из участников

    }

    // Метод для создания массива участников
    public void dreamTeamBuilding() {
        membersTeam = new Member[numberOfParticipants];
        for (int i = 0; i < numberOfParticipants; i++) {
            membersTeam[i] = new Member(Tools.random.nextInt(maxSkillObstacles + maxSkillObstacles/2));
        }

    }

    // Метод вывода информации о членах команды, прошедших дистанцию
    public void infoTeamPassedDistance() {
        System.out.println("===== Итоги соревнований =====");
        System.out.println("Дистанцию успешно прошли следующие участники: ");
        for (int i = 0; i < numberOfParticipants; i++) {
            if (membersTeam[i].getWinMember() == 1) {
                continue;
            } else System.out.println("- участник № " + membersTeam[i].getCountMember());
        }
    }

    // Метод вывода информации о всех членах команды
    public void infoTeam() {
        System.out.println("===== Карточка участников =====");
        System.out.println("Количество участников: " + membersTeam.length);

        for (int i = 0; i < numberOfParticipants; i++) {
            System.out.println("Участник № " + membersTeam[i].getCountMember()
                    + ", может преодолеть " + membersTeam[i].getNumberOfObstacles() + " препятствий");
        }
    }

    // Геттеры на массив участников и имя команды
    public Member[] getMembersTeam() {
        return membersTeam;
    }
    public String getTeamName() {
        return teamName;
    }
}
