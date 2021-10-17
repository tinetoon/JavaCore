package HomeWork07;

import java.io.IOException;
import java.util.Scanner;

/**
 * Класс взаимодействия пользователя с консолью
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 09.10.2021
 */

public class UserInterface {

    // Создаём объект контроллера
    private final Controller controller = new Controller();

    // Метод для запуска приложения
    public void runApplication() {

        Scanner scanner = new Scanner(System.in); // Создаём объект сканера (метод in объекта Sys - стандартный input stream, ожидает ввод с клавиатуры)

        enterCitiZip(scanner);
        enterPeriodWeather(scanner);
    }

    // Метод ввода кода города
    private void enterCitiZip(Scanner scanner) {

        while (true) {
            System.out.println("Введите почтовый индекс Санкт-Петербурга (198097 или 198217): ");

            String citiZipTmp = scanner.nextLine(); // Инициализируем временную переменную для кода города

            // Проверяем правильность ввода почтового индекса (!!! вынести в отдельный метод boolean)
            if (!citiZipTmp.equals("198097") && !citiZipTmp.equals("198217") && !citiZipTmp.equals("184682")) { // 184682 - Снежногорск, Мурманская обл.
                System.out.println("Введён неверный почтовый индекс, повторите ввод.");
//                    break;
            } else {
                setGlobalCity(citiZipTmp);
                System.out.println("Выбран г. Санкт-Петербург, почтовый индекс: " + citiZipTmp);
                break; // * - заменить выход на логику
            }

        }
    }

    // Метод фиксирующий код города введённый пользователем
    private void setGlobalCity(String citiZip) {
        ApplicationGlobalState.getInstance().setSelectedCity(citiZip);
    }

    // Метод ввода периода прогноза погоды
    private void enterPeriodWeather(Scanner scanner) {

        while (true) {
            System.out.println("Введите ответ:\n" +
                    "0 - погода на текущую дату;\n" +
                    "от 1 до 5 - погода на период в днях;\n" + // "от 1 до 5 - погода на период в днях;\n"
                    "др. - выход из приложения.");

            String periodWeatherTmp = scanner.nextLine(); // Инициализируем временную переменную для кода города

            // Проверяем правильность ввода периода (!!! вынести в отдельный метод boolean)
            if (!periodWeatherTmp.equals("0")
                    && !periodWeatherTmp.equals("1")
                    && !periodWeatherTmp.equals("2")
                    && !periodWeatherTmp.equals("3")
                    && !periodWeatherTmp.equals("4")
                    && !periodWeatherTmp.equals("5")) {
                System.out.println("===== EXIT =====");
                    break;
            } else {
                System.out.println("Выбран период: " + periodWeatherTmp);

                try {
                    notifyController(periodWeatherTmp); // отправляем значение в контроллер и обрабатываем исключения
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Метод передающий период, введённый пользователем в контроллер и в глобальную переменную
    private void notifyController(String period) throws IOException {
        int dayPeriod = Integer.valueOf(period);
        int hourPeriod = dayPeriod * 8; // В каждом суточном прогнозе восемь трёхчасовых периодов
        ApplicationGlobalState.getInstance().setSelectedDayPeriod(period);
        ApplicationGlobalState.getInstance().setSelectedHourPeriod(Integer.toString(hourPeriod));
        controller.onUserInput(period);
    }
}
