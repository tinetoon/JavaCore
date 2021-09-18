package lesson1.education;

public class Athletes {

    // Поля класс спортсмены
    private int numberOfObstacles; // Количество препятствий, которое может преодолеть участник
    private int countAthletes; // Номер спортсмена
    public static int count = 0; // Номер участник

    // Конструктор
    public Athletes(int colichestvoPrepyatstvij) {
        this.numberOfObstacles = colichestvoPrepyatstvij;
        ++count;
        this.countAthletes = count;
    }

    // Создаём геттеры на количество участников и количество препятствий, которое может пройти каждый участник
    public int getNumberOfObstacles() {
        return numberOfObstacles;
    }
    public int getCountAthletes() {
        return countAthletes;
    }
}
