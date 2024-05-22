# ProductAPI

Проект ProductAPI представляет собой RESTful API для управления продуктами. Он написан на языке Java 17 с использованием фреймворка Spring Boot и Spring Data JPA. Для удобного развертывания используется Docker Compose.

## Запуск с использованием Docker Compose

Проект настроен для запуска с использованием Docker Compose. Это позволяет легко управлять зависимостями и контейнерами.

### Dockerfile

`Dockerfile` содержит инструкции для сборки Docker-образа приложения.

### docker-compose.yaml

`docker-compose.yaml` содержит конфигурацию для запуска всех необходимых сервисов, включая базу данных и само приложение.

### Команды для сборки и запуска

#### Сборка проекта:

mvn clean install

docker-compose up -d

После выполнения этих команд приложение будет доступно по адресу http://localhost:8080.

### Основные компоненты проекта
#### Контроллеры
ProductController.java: обрабатывает HTTP-запросы, связанные с продуктами.
#### Сущности
Product.java: представляет собой сущность продукта.
#### Исключения

CharacterLimitException.java: выбрасывается при превышении лимита символов.

ProductNameNullException.java: выбрасывается, если имя продукта пусто.

ProductNotSuchException.java: выбрасывается, если продукт не найден.

ProductPriceException.java: выбрасывается при неверной цене продукта.

wGlobalExceptionHandler.java: глобальный обработчик исключений.
#### Репозитории
ProductRepository.java: предоставляет методы для взаимодействия с базой данных.
#### Сервисы
ProductService.java и ProductServiceImpl.java: содержат бизнес-логику приложения.
#### Валидация
ProductValidator.java: содержит логику для валидации данных продукта.
#### Ресурсы
application.properties: содержит настройки приложения.
schema.sql: скрипт для создания схемы базы данных.
#### Тесты
ProductApiApplicationTests.java: содержит тесты для проверки функциональности приложения.