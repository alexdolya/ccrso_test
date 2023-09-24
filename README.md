# Overview
Микросервис считывает названия городов (в файле приведенном в репозитории - 50 крупнейших городов мира) из файла и добавляет их в БД. По названию каждого города каждый час получает информацию о погоде из сервиса https://openweathermap.org/, сохраняет их в БД, выводит лог в консоль.

## Технологии

Микросервис использует следующие технологии:
- Java 11
- Spring Boot 2.7.16
- Spring OpenFeign
- Lombok
- Liquibase
- PostgreSQL
- Spring Data JPA

## Запуск приложения

Запуск приложения и БД происходит в контейнере с помощью docker-compose. Выполните следующие инструкции.

1. Клонируйте репозиторий

2. В терминале перейдите в папку с проектом.

3. В файле .env установите переменные окружения:
- APPID - ваш API key для openweathermap.org -
- CITIESLIST_PATH - путь к файлу со списком городов в которых располагаются "дата-центры"
- DB_DATA_PATH - путь для хранения данных записываемых в БД

4. В терминале выполните следющую команду
    ```
    docker-compose up
    ```

5. После старта приложения вы увидите результат его работы
 ```
mcrs      | 2023-09-24 15:28:34.278  INFO 1 --- [           main] ru.dolya.mcrs_test.CcrsoTestApplication   : Started McrsTestApplication in 5.418 seconds (JVM running for 5.878)
mcrs      | 2023-09-24 15:28:35.166  INFO 1 --- [   scheduling-1] r.d.m.service.impl.WeatherServiceImpl    : Weather have been saved to DB. City: Saratov, Temp: 20.52, Description: clear sky
mcrs      | 2023-09-24 15:28:35.253  INFO 1 --- [   scheduling-1] r.d.m.service.impl.WeatherServiceImpl    : Weather have been saved to DB. City: Moscow, Temp: 22.54, Description: scattered clouds
 ```
