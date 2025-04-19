package site.nomoreparties.stellarburgers.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;

    //Локаторы для регистрации
    private final By nameInput = By.xpath("//div[label[text()='Имя']]/input");
    private final By emailInput = By.xpath("//div[label[text()='Email']]/input");
    private final By passwordInput = By.xpath("//div[label[text()='Пароль']]/input");

    private final By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private final By passwordError = By.xpath("//p[text()='Некорректный пароль']");

    private final By loginLink = By.xpath("//a[@href='/login']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public By getPasswordError() {
        return passwordError;
    }

    //Методы для регистрации
    @Step("Ввод имени: {name}")
    public void enterName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    @Step("Ввод email: {email}")
    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    @Step("Ввод пароля: {password}")
    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    @Step("Нажатие кнопки 'Зарегистрироваться'")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    @Step("Регистрация пользователя: имя={name}, email={email}, пароль={password}")
    public void register(String name, String email, String password) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
        clickRegisterButton();
    }

    @Step("Проверка отображения ошибки: 'Некорректный пароль'")
    public boolean isPasswordErrorDisplayed() {
        return driver.findElement(passwordError).isDisplayed();
    }

    @Step("Нажатие кнопки 'Войти'")
    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }
}
