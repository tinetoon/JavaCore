package lesson1.HomeWork01;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 16.09.2021
 */

public class HomeApp01 {

    private static Team team;

    public static void main(String[] args) {

        // Создаём команду мечты
        team = new Team("Команда мечты", 5, 5);

//        for (int i = 0; i < 5; i++) {
//            System.out.println("Участник № " + team.
//                    + ", может преодолеть " + membersTeam[].getNumberOfObstacles() + " препятствий.");
//        }

        for (int i = 0; i < team.getMembersTeam.length; i++) {
            System.out.println("Участник № " + team.membersTeam[i].getCountMember()
                    + ", может преодолеть " + team.membersTeam[i].getNumberOfObstacles());
        }
    }

    // Метод вывода информации о членах команды
    public void infoTeam() {
        System.out.println("===== Карточка участника =====");

        for (int i = 0; i < team.getMembersTeam.length; i++) {
            System.out.println("Участник № " + team.getMembersTeam[i].getCountMember()
                    + ", может преодолеть " + team.getMembersTeam[i].getNumberOfObstacles());
        }
        System.out.println("==============================");
    }
}
