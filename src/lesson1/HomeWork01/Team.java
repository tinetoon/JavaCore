package lesson1.HomeWork01;

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

    // Создаём поля класса команда
    private String teamName; // название команды
    private int numberOfParticipants; // количество участников
    private int maxObstacles; // максимальное количество препятствий

    // Создаём конструктор
    public Team(String name, int number, int obstacles) {
        this.teamName = name;
        this.numberOfParticipants = number;
        this.maxObstacles = obstacles;

        dreamTeamBuilding(); // Создаём массив из участников
    }

    // Метод для создания массива участников
    private void dreamTeamBuilding() {
        Member[] membersTeam = new Member[numberOfParticipants];
        for (int i = 0; i < numberOfParticipants; i++) {
            membersTeam[i] = new Member(Tools.random.nextInt(maxObstacles));
        }
    }

    // Метод вывода информации о членах команды
//    public void infoTeam() {
//        System.out.println("===== Карточка участника =====");
//        for (int i = 0; i < 5; i++) {
//            System.out.println("Участник № " + membersTeam[i].getCountMember()
//                    + ", может преодолеть " + membersTeam[i].getNumberOfObstacles() + " препятствий.");
//        }
//        System.out.println("==============================");
//    }
}
