package HomeWork07;

import HomeWork07.classes.DataWeather;
import HomeWork07.classes.Root;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Класс взаимодействия с БД
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 18.10.2021
 *
 * 1. Добавить поддержку SQLite в проект. Через Мавен добавлена библиотека SQLite JDBC » 3.36.0.3
 * 2. Создать класс-репозиторий, отвечающий за взаимодействие с базой данных.
 * 3. Организовать запись данных в базу при каждом успешном API запросе.
 * Формат - String city, String localDate, String weatherText, Double temperature.
 * 4. Организовать чтение из базы всех данных по пункту меню (требует переработки меню)
 * 5. Учесть, что соединение всегда нужно закрывать
 */

public class Repository implements DatabaseRepository {

    // Поля класса
    private String filename = null;
    private final String CREATE_TABLE_QUERY = "CREATE TABLE IF NOT EXISTS weather (\n" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "city TEXT NOT NULL,\n" +
            "date_time TEXT NOT NULL,\n" +
            "weather_text TEXT NOT NULL,\n" +
            "temperature REAL NOT NULL,\n" +
            ");";
    private final String INSERT_WEATHER_QUERY = "INSERT INTO weather (city, date_time, weather_text, temperature) VALUES (?,?,?,?)";

    // Статический блок для инициализации драйвера работы с БД
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.out.println("Драйвер SQLite не зарегистрирован: " + e.toString());
        }
    }

    // Конструктор класса
    public Repository() {
        this.filename = ApplicationGlobalState.getInstance().getDATABASE_FILE_NAME();
    }

    // Метод возвращающий объект соединения с базой данных (!!! добавить имя файла в URL)
    private Connection getConnection() throws SQLException {
        Connection myConnection = DriverManager.getConnection("jdbc:sqlite:" + filename);
        return myConnection;
    }

    // Метод создания таблицы
    private void createTableIfNotExists() {
        try (Connection newConnection = getConnection()) { // Конструкция try-with-resources автоматически закрывает ресурсы, открытые в блоке try
            newConnection.createStatement().execute(CREATE_TABLE_QUERY);
        } catch (SQLException e) {
            System.out.println("Повторное создание таблицы остановлено: " + e.toString());
        }
    }

    // Метод возвращающий результат сохранения данных в БД
    @Override
    public boolean saveWeatherData(DataWeather dataWeather) throws SQLException {
        try (Connection newConnection = getConnection(); // Конструкция try-with-resources автоматически закрывает ресурсы, открытые в блоке try
             PreparedStatement saveWeather = newConnection.prepareStatement(INSERT_WEATHER_QUERY)) {
                saveWeather.setString(1, dataWeather.getCity());
                saveWeather.setString(2, dataWeather.getDateTime());
                saveWeather.setString(3, dataWeather.getWeatherText());
                saveWeather.setDouble(4, (Double) dataWeather.getTemperature());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new SQLException("Ошибка при сохранении строки с погодой в БД"); // Создаём сообщение об ошибке для выброса на верх
    }

    // Код взят с урока (!!! разобраться с логикой)
    @Override
    public List<DataWeather> getAllSavedData() throws IOException {
        throw new IOException("Not implemented exception");
    }

}
