package lesson1.HomeWork01;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 16.09.2021
 */

public class HomeApp01 {

    public static void main(String[] args) {

        // Создаём команду мечты
        Team dreamTeam = new Team("Команда мечты", 4, 5);
//        dreamTeam.dreamTeamBuilding();
        System.out.println("Team # ");
        System.out.println("Команда: " + dreamTeam.getTeamName());
        System.out.println("----------------------------");
        System.out.println("Member # ");
        System.out.println("Участники ");
        dreamTeam.infoTeam();

        Course newCourse = new Course(5); // Создаём полосу из 5-ти препятствий
//        dreamTeam.dreamTeamBuilding();
//        dreamTeam.infoTeam();
//        dreamTeam.getMembersTeam();

    }

}
