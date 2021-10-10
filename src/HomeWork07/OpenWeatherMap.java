package HomeWork07;

import HomeWork07.enums.Periods;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Класс реализации запроса погоды на ресурсе openweathermap.org
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 09.10.2021
 */

public class OpenWeatherMap implements WeatherProvider {

    // Поля класса для GET запроса после "/"
    private static final String BASE_HOST = "api.openweathermap.org";
    private static final String DATA = "data";
    private static final String API_VERSION = "2.5";
    private static final String WEATHER = "weather";
    private static final String FORECAST = "forecast";
    private static final String DAILY = "daily";

    // Поля класса для параметров KEY/VALUE
    private static String CITI_ZIP = ApplicationGlobalState.getInstance().getSelectedCityZip();
    private static final String RUSSIA_CODE = "RU";
    private static final String APPI_ID = ApplicationGlobalState.getInstance().getAPPI_ID_OW();
    private static String CNT = "5";
    private static final String UNITS = "metric";


    // Клиент для подключения к серверу
    private final OkHttpClient client = new OkHttpClient();

    // Переопределяем главный метод интерфейса WeatherProvider
    @Override
    public void getWeather(Periods periods) throws IOException {

        if (periods.equals(Periods.NOW)) {

            System.out.println("===== ПРОГНОЗ ПОГОДЫ НА ТЕКУЩУЮ ДАТУ =====");
            getWeatherNow(client);

        } else {

            System.out.println("===== ПРОГНОЗ ПОГОДЫ НА 5 ДНЕЙ =====");
            getWeatherPeriod(client);

        }

    }

    // Метод запроса погоды на текущую дату
    public static void getWeatherNow(OkHttpClient client) throws IOException {

        // Создаём URL для отправки GET запроса
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(BASE_HOST)
                .addPathSegment(DATA)
                .addPathSegment(API_VERSION)
                .addPathSegment(WEATHER)
                .addQueryParameter("zip", (CITI_ZIP + "," + RUSSIA_CODE))
                .addQueryParameter("appid", APPI_ID)
                .addQueryParameter("units", UNITS)
                .build();

        // Выводим в консоль информацию об отправке запроса
        System.out.println("Отправляем GET запрос: " + url.toString());

        // Создаём объект отправки запросов на сервер
        Request request = new Request.Builder()
                .header("Content-type", "application/json")
                .url(url)
                .build();

        // Создаём объект получения ответов с сервера
        Response response = client.newCall(request).execute();

        // Объявляем строковую переменную и инициализируем её ответом сервера
        String body = response.body().string();

        System.out.println("Код ответа сервера: " + response.code());
        System.out.println(body);
    }

    // Метод запроса погоды на 5 (1-16) дней
    public static void getWeatherPeriod(OkHttpClient client) throws IOException {

        // Создаём URL для отправки GET запроса
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(BASE_HOST)
                .addPathSegment(DATA)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST)
                .addPathSegment(DAILY)
                .addQueryParameter("zip", (CITI_ZIP + "," + RUSSIA_CODE))
                .addQueryParameter("appid", APPI_ID)
                .addQueryParameter("cnt", CNT)
                .addQueryParameter("units", UNITS)
                .build();

        // Выводим в консоль информацию об отправке запроса
        System.out.println("Отправляем GET запрос: " + url.toString());

        // Создаём объект отправки запросов на сервер
        Request request = new Request.Builder()
                .header("Content-type", "application/json")
                .url(url)
                .build();

        // Создаём объект получения ответов с сервера
        Response response = client.newCall(request).execute();

        // Объявляем строковую переменную и инициализируем её ответом сервера
        String body = response.body().string();

        System.out.println("Код ответа сервера: " + response.code());
        System.out.println(body);
    }

    // Геттеры на код города и количество дней погоды
    public static String getCitiZip() {
        return CITI_ZIP;
    }
    public static String getCNT() {
        return CNT;
    }

    // Сеттер на код города (для присвоения другого кода из пользовательского ввода, см. класс UserInterface)
    public static void setCitiZip(String citiZip) {
        CITI_ZIP = citiZip;
    }

    // Сеттер на количество дней погоды (для присвоения значения из пользовательского ввода)
    public static void setCNT(String CNT) {
        OpenWeatherMap.CNT = CNT;
    }
}
