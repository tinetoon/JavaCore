package HomeWork07;

import HomeWork07.classes.ListWeather;
import HomeWork07.classes.Root;
import HomeWork07.enums.Periods;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
//import org.json.simple.parser.ParseException;

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

    // Поля класса для параметров KEY/VALUE
    private static String citiZip = "null";
    private static final String RUSSIA_CODE = "RU";
    private static final String APPI_ID = ApplicationGlobalState.getInstance().getAPPI_ID_OW();
    private static String cnt = "5";
    private static final String UNITS = "metric";


    // Клиент для подключения к серверу
    private final OkHttpClient client = new OkHttpClient();

    // Объект ответа от сервера
    WeatherResponse weatherResponse = new WeatherResponse();

    // Переопределяем главный метод интерфейса WeatherProvider
    @Override
    public void getWeather(Periods periods) throws IOException {

        // Устанавливаем значения почтового индекса и периода получения прогноза погоды
        setCitiZip(ApplicationGlobalState.getInstance().getSelectedCityZip());
        setCnt(ApplicationGlobalState.getInstance().getSelectedPeriod());

        if (periods.equals(Periods.NOW)) {

            System.out.println("===== ПРОГНОЗ ПОГОДЫ НА ТЕКУЩУЮ ДАТУ =====");
//            printWeatherNow(client);
            weatherResponse.setStringWeatherResponse(getWeatherNow(client));
            System.out.println("Температура: " + weatherResponse.getTemperatureNow() + " градусов.");

        } else {

            System.out.println("===== ПРОГНОЗ ПОГОДЫ НА " + cnt + " ДНЕЙ =====");
            Root weatherList = weatherResponse.getTemperature();
            System.out.println("Прогноз погоды для города: " + weatherList.getCity());
            for (Object it: weatherList.getList()) {
                ListWeather list = (ListWeather) it;
                if (list.getMain().getHour() == 0) {
                    System.out.println("Дата: " + list.getDt_txt() + "Температура: " + list.getMain().getTemp());
                }
            }
//            printWeatherPeriod(client);
//            weatherResponse.setStringWeatherResponse(getWeatherPeriod(client));
//            try {
//                System.out.println("Температура: " + weatherResponse.getTemperature() + " градусов.");
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
        }

    }

    // Метод запроса погоды на текущую дату
    public static void printWeatherNow(OkHttpClient client) throws IOException {

        // Создаём URL для отправки GET запроса
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(BASE_HOST)
                .addPathSegment(DATA)
                .addPathSegment(API_VERSION)
                .addPathSegment(WEATHER)
                .addQueryParameter("zip", (citiZip + "," + RUSSIA_CODE))
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

    // Метод возвращающий прогноз погоды на текущую дату
    public static String getWeatherNow(OkHttpClient client) throws IOException {

        // Создаём URL для отправки GET запроса
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(BASE_HOST)
                .addPathSegment(DATA)
                .addPathSegment(API_VERSION)
                .addPathSegment(WEATHER)
                .addQueryParameter("zip", (citiZip + "," + RUSSIA_CODE))
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

        return body;
    }

    // Метод запроса погоды на 5 (1-5) дней
    public static void printWeatherPeriod(OkHttpClient client) throws IOException {

        // Создаём URL для отправки GET запроса
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(BASE_HOST)
                .addPathSegment(DATA)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST)
                .addQueryParameter("zip", (citiZip + "," + RUSSIA_CODE))
                .addQueryParameter("appid", APPI_ID)
                .addQueryParameter("cnt", cnt)
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

    // Метод возвращающий прогноз погоды на 5 (1-5) дней
    public static String getWeatherPeriod(OkHttpClient client) throws IOException {

        // Создаём URL для отправки GET запроса
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(BASE_HOST)
                .addPathSegment(DATA)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST)
                .addQueryParameter("zip", (citiZip + "," + RUSSIA_CODE))
                .addQueryParameter("appid", APPI_ID)
                .addQueryParameter("cnt", cnt)
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

        return body;
    }

    // Геттеры на код города и количество дней погоды
    public static String getCitiZip() {
        return citiZip;
    }
    public static String getCnt() {
        return cnt;
    }

    // Сеттер на код города (для присвоения другого кода из пользовательского ввода, см. класс UserInterface)
    public static void setCitiZip(String citiZip) {
        OpenWeatherMap.citiZip = citiZip;
    }

    // Сеттер на количество дней погоды (для присвоения значения из пользовательского ввода)
    public static void setCnt(String cnt) {
        OpenWeatherMap.cnt = cnt;
    }
}
