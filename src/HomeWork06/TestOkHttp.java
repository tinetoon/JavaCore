package HomeWork06;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 09.10.2021
 *
 * 1. С помощью http запроса получить в виде json строки погоду в Санкт-Петербурге
 * на период времени, пересекающийся со следующим занятием
 * (например, выборка погода на следующие 5 дней - подойдет)
 *
 * В качестве источника данных будем использовать ресурс openweathermap.org
 * Для этого регистрируем на указанном сайте личную учётную запись.
 * Создаём учебный APIKEY 7063829f1fd4a64b42f6787514262064
 *
 * В соответствии с документацией на ресурсе openweathermap.org
 * состав GET запроса следующий:
 * api.openweathermap.org/data/2.5/forecast?zip={zip code},{country code}&appid={API key}
 * При этом:
 * {API key} нам уже известен
 * {zip code} - это почтовый код города, для Санкт Петербурга принимаем 198097 или 198217
 * {country code} - это двухзначный код страны в соответствии с ISO3166, для России будет - RU
 * в качестве дополнительного параметра используем ключ {units} со значением = metric
 * для получения данных в метрических единицах
 *
 * С дополнительным параметром GET запрос будет выглядеть следующим образом:
 * api.openweathermap.org/data/2.5/forecast?zip=198097,RU&appid=7063829f1fd4a64b42f6787514262064&units=metric
 */

public class TestOkHttp {

    // Поля класса для GET запроса после "/"
    private static final String BASE_HOST = "api.openweathermap.org";
    private static final String DATA = "data";
    private static final String API_VERSION = "2.5";
    private static final String FORECAST = "forecast";
    private static final String ZIP_COUNTRY = "forecast?zip=198097,RU";
//    private static final String API_VERSION = "v1";
//    private static final String FORECAST_TYPE = "daily";
//    private static final String FORECAST_PERIOD = "5day";

    // Поля класса для параметров KEY/VALUE
    private static final String SAINT_PETERSBURG_ZIP = "198097,RU";
    private static final String RUSSIA_CODE = "RU";
    private static final String APPI_ID = "7063829f1fd4a64b42f6787514262064";
    private static final String UNITS = "metric";

    public static void main(String[] args) throws IOException {

        // Создаём клиент для подключения к серверу
        OkHttpClient client = new OkHttpClient();

        // Создаём URL для отправки GET запроса
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host(BASE_HOST)
                .addPathSegment(DATA)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST)
                .addQueryParameter("zip", SAINT_PETERSBURG_ZIP)
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
}
