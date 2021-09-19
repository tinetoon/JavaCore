package lesson1.education;

import lesson1.HomeWork01.Member;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Random;

public class Team {

    public static Random random = new Random();

    // Создаём поля класса команда
    private String teamName; // название команды
    private int numberOfParticipants; // количество участников
    private int maxSkillObstacles; // максимальное количество препятствий, которое может преодолеть участник в результате тренировок
    private Athletes[] membersTeam;

    // Создаём конструктор
    public Team(String name, int number, int participants) {
        this.teamName = name;
        this.numberOfParticipants = number;
        this.maxSkillObstacles = participants;

        athletesBuilding();

//        membersTeam = new Athletes[4]; // создаём массив команды
//
//        membersTeam[0] = new Athletes(5);
//        membersTeam[1] = new Athletes(10);
//        membersTeam[2] = new Athletes(15);
//        membersTeam[3] = new Athletes(20);
    }

    // Метод для создания массива участников
    public void athletesBuilding() {
        membersTeam = new Athletes[numberOfParticipants];
        for (int i = 0; i < 4; i++) {
            membersTeam[i] = new Athletes(random.nextInt(maxSkillObstacles));
        }

//        System.out.println("Атлет № " + membersTeam[2].getCountAthletes() + " может пройти " + membersTeam[2].getNumberOfObstacles() + " препятствий");
    }

    // Вывод информации о наших атлетах
    public void dreamTeamBuilding() {
        System.out.println("==== Информация о нашей команде ===");
        System.out.println("Название команды: " + teamName);
        System.out.println("Количество атлетов: " + numberOfParticipants);
        for (int i = 0; i < numberOfParticipants; i++) {
            System.out.println("Мышонок с номером " + membersTeam[i].getCountAthletes()
                    + " может преодолеть " + membersTeam[i].getNumberOfObstacles() + " препятствий");
        }

    }

}
