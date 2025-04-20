package site.nomoreparties.stellarburgers.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.utils.WaitUtils;

import static site.nomoreparties.stellarburgers.config.Url.MAIN_PAGE_URL;

public class LoginPage {

    private WebDriver driver;

    //Локторы для входа в аккаунт
    private final By emailInput = By.xpath("//input[@name='name']");
    private final By passwordInput = By.xpath("//input[@type='password']");
    private final By loginButton = By.xpath("//button[text()='Войти']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Методы для входа в аккаунт
    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    @Step("Вход в аккаунт: email = {email}, пароль = {password}")
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
        WaitUtils.waitForUrl(driver, MAIN_PAGE_URL);
    }
}
