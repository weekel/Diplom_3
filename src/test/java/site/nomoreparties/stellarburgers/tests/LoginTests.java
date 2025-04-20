package site.nomoreparties.stellarburgers.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pom.ForgotPasswordPage;
import site.nomoreparties.stellarburgers.pom.LoginPage;
import site.nomoreparties.stellarburgers.pom.MainPage;
import site.nomoreparties.stellarburgers.pom.RegisterPage;

import static site.nomoreparties.stellarburgers.config.Url.*;

@DisplayName("Тесты на вход в аккаунт")
public class LoginTests extends BaseTest{
    private MainPage mainPage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private ForgotPasswordPage forgotPasswordPage;
    private Faker faker = new Faker();

    private String name;
    private String email;
    private String password;

    @Before
    public void initPage() {
        name = faker.name().firstName();
        email = faker.internet().emailAddress();
        password = faker.internet().password();

        driver.get(REGISTER_PAGE_URL);
        mainPage = new MainPage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);

        registerPage.register(name, email,password);
    }

    @Test
    @DisplayName("Вход через кнопку 'Войти в аккаунт' на главной")
    @Description("Проверяет, что пользователь может авторизоваться через кнопку 'Войти в аккаунт' на главной странице")
    public void loginFromMainPageLoginButton() {
        driver.get(MAIN_PAGE_URL);
        mainPage.clickLoginButtonOnPage();

        loginPage.login(email, password);
        Assert.assertTrue("Кнопка 'Оформить заказ' не отображается — возможно, вход не выполнен", mainPage.isPlaceOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку 'Личный кабинет'")
    @Description("Проверяет, что пользователь может авторизоваться через кнопку 'Личный кабинет'")
    public void loginFromPersonalCabinetButton() {
        driver.get(MAIN_PAGE_URL);
        mainPage.clickPersonalCabinetButton();

        loginPage.login(email, password);
        Assert.assertTrue("Кнопка 'Оформить заказ' не отображается — возможно, вход не выполнен", mainPage.isPlaceOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Проверяет, что пользователь может авторизоваться через кнопку 'Войти' в форме регистрации")
    public void loginFromRegisterPage() {
        driver.get(REGISTER_PAGE_URL);
        registerPage.clickLoginLink();

        loginPage.login(email, password);
        Assert.assertTrue("Кнопка 'Оформить заказ' не отображается — возможно, вход не выполнен", mainPage.isPlaceOrderButtonVisible());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Проверяет, что пользователь может авторизоваться через кнопку в форме восстановления пароля")
    public void loginFromForgotPasswordPage() {
        driver.get(FORGOT_PASSWORD_PAGE_URL);
        forgotPasswordPage.clickLoginLink();

        loginPage.login(email, password);
        Assert.assertTrue("Кнопка 'Оформить заказ' не отображается — возможно, вход не выполнен", mainPage.isPlaceOrderButtonVisible());
    }
}
