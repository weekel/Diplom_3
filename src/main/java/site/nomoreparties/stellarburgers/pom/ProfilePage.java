package site.nomoreparties.stellarburgers.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.utils.WaitUtils;

import static site.nomoreparties.stellarburgers.config.Url.LOGIN_PAGE_URL;

public class ProfilePage {

    private WebDriver driver;

    //Локтаор для перехода из личного кабинета в конструктор
    private final By headerLogo = By.className("AppHeader_header__logo__2D0X2");
    private final By constructorLink = By.xpath("//p[text()='Конструктор']");

    private final By logoutButton = By.xpath("//button[text()='Выход']");


    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    //Методы для перехода из личного кабинета в конструктор
    @Step("Клик по логотипу Stellar Burgers в шапке")
    public void clickHeaderLogo() {
        driver.findElement(headerLogo).click();
    }

    @Step("Клик по ссылке 'Конструктор' в шапке")
    public void clickConstructorLink() {
        driver.findElement(constructorLink).click();
    }

    //Метод для выхода из аккаунта
    @Step("Клик по кнопке 'Выйти' в личном кабинете")
    public void clickLogoutButton() {
        WaitUtils.waitForElementVisible(driver, logoutButton);
        driver.findElement(logoutButton).click();
        WaitUtils.waitForUrl(driver, LOGIN_PAGE_URL);
    }
}
