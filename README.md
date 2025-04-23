# 🖥️ Stellar Burgers UI Tests

This project contains **automated UI tests** for the Stellar Burgers web application.  
It validates user-facing features such as authentication, navigation, and order placement using Selenium WebDriver.

---

## 🧭 Project Structure

- `src/main/java` – Page Object classes representing UI components
- `src/test/java` – UI test cases organized by functionality
- `pom.xml` – Maven project file
- `allure-report/chrome/` – Allure HTML report for Chrome browser

---

## ✅ Technologies Used

- **Java 11**
- **JUnit 4** — for test structure
- **Selenium WebDriver** — for browser automation
- **Allure** — for test reporting
- **Faker** — for dynamic test data generation
- **Maven** — for dependency and build management

---

## 🚀 How to Run Tests

Make sure you have **Java 11+**, **Maven**, and **ChromeDriver** installed. Then run:

```bash
mvn clean test
```

To generate the Allure report:

```bash
mvn allure:report
```

To view the report locally:

```bash
mvn allure:serve
```

---

## 🧪 Features Tested

- User registration and login
- Page navigation (constructor, profile, home)
- Placing and verifying orders
- Tab switching for burger ingredients
- UI validations and negative scenarios

---

## 🌐 Browser Support

Tests are configured for **Google Chrome**.  
Optional support for **Yandex Browser** can be added using custom WebDriver settings.

---

## 📄 License

This project is developed for educational purposes only.