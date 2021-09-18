package lesson1.HomeWork01;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 16.09.2021
 */

public class HomeApp01 {

    public static void main(String[] args) {

        // Создаём команду мечты
        Team dreamTeam = new Team("Команда мечты", 5, 5);
//        dreamTeam.dreamTeamBuilding();
        System.out.println("Team # ");
        System.out.println("Команда: " + dreamTeam.getTeamName());
        System.out.println("----------------------------");
        System.out.println("Member # ");
        System.out.println("Участники ");
//        dreamTeam.dreamTeamBuilding();
//        dreamTeam.infoTeam();
//        dreamTeam.getMembersTeam();

    }

}
