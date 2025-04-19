## Автотесты для веб-приложения Stellar Burgers

### Описание

Проект содержит автотесты для проверки основных пользовательских сценариев веб-приложения [Stellar Burgers](https://stellarburgers.nomoreparties.site/), реализованные с использованием Java, JUnit4, Selenium и Allure.

Тесты написаны по паттерну **Page Object**, покрывают сценарии регистрации, логина, навигации по интерфейсу и выхода из аккаунта.

---

### Технологии

- Java 11
- Maven
- Selenium WebDriver
- JUnit 4
- Allure Report
- JavaFaker
- Chrome / Yandex Browser

---

### Покрытие тестами

| Функциональность               | Тест-класс              |
|--------------------------------|--------------------------|
| Регистрация                    | `RegisterTests`          |
| Логин                         | `LoginTests`             |
| Навигация (Конструктор)       | `ConstructorTests`       |
| Личный кабинет и выход        | `PersonalCabinetTests`   |

---

### Запуск тестов

```bash
# Очистить и запустить тесты в Chrome
mvn clean test

# Запустить в Яндекс.Браузере
mvn clean test -Dbrowser=yandex
```

---

### Генерация Allure-отчета

```bash
# 1. Запуск тестов с генерацией результатов
mvn clean test

# 2. Генерация и запуск отчета
allure serve target/allure-results
```

