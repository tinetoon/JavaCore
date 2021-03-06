package HomeWork06;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Ответственный за создание класса - А.А. Дюжаков
 * Дата создания: 06.10.2021
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

public class HomeApp06 {

    public static void main(String[] args) throws IOException {

        URL url = new URL("https://api.openweathermap.org/data/2.5/forecast?zip=198097,RU&appid=716cb70e7508d5933ac312eb82eb98bf&units=metric");

        // Получаем погоду методом openStream
        InputStream in = url.openStream();
        new BufferedReader(new InputStreamReader(in, UTF_8))
                .lines() // возвращает Stream (поток) строк, а не строки
                .forEach(System.out::println); // аналогично записи .forEach(line -> sout(line))

        // HttpURLConnection
        HttpURLConnection httpConect = (HttpsURLConnection) url.openConnection();
        httpConect.connect();

        System.out.println("Отправленный GET запрос: " + httpConect);
        System.out.println("Ответ сервера: " + httpConect.getResponseCode());
    }
}
