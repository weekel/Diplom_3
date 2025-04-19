package site.nomoreparties.stellarburgers.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverFactory {

    @Step("Открытие браузера: {browserName}")
    public static WebDriver getDriver(String browserName) {
        switch (browserName.toLowerCase()) {

            case "chrome":
                return new ChromeDriver();

            case "yandex":

                System.setProperty("webdriver.chrome.driver", "C:\\Users\\VAVA\\WebDriver\\yandex\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:\\Users\\VAVA\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe");
                return new ChromeDriver(options);

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
    }
}
