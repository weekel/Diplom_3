package site.nomoreparties.stellarburgers.tests;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pom.RegisterPage;
import site.nomoreparties.stellarburgers.utils.WaitUtils;

import static site.nomoreparties.stellarburgers.config.Url.LOGIN_PAGE_URL;
import static site.nomoreparties.stellarburgers.config.Url.REGISTER_PAGE_URL;

@DisplayName("Тесты на регистрацию")
public class RegisterTests extends BaseTest{
    private RegisterPage registerPage;
    private Faker faker = new Faker();

    private String expectedUrl;
    private String actualUrl;
    private String name;
    private String email;
    private String password;
    private String shortPassword;

    @Before
    public void initPage() {
        registerPage = new RegisterPage(driver);

        driver.get(REGISTER_PAGE_URL);

        name = faker.name().firstName();
        email = faker.internet().emailAddress();

    }

    @Test
    @DisplayName("Успешная регистрация с валидными данными")
    @Description("Проверяет, что пользователь попадает на страницу логина после успешной регистрации")
    public void userCanRegisterSuccessfully() {
        password = faker.internet().password();
        registerPage.register(name, email, password);

        WaitUtils.waitForUrl(driver, LOGIN_PAGE_URL);

        expectedUrl = LOGIN_PAGE_URL;
        actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("Пользователь не попал на страницу входа после регистрации", expectedUrl, actualUrl);
    }

    @Test
    @DisplayName("Ошибка при регистрации с коротким паролем")
    @Description("Проверяет, что при вводе пароля менее 6 символов отображается сообщение 'Некорректный пароль'")
    public void registrationWithShortPasswordShowsError() {
        password = faker.internet().password(1, 5);
        registerPage.register(name, email, password);

        WaitUtils.waitForElementVisible(driver, registerPage.getPasswordError());

        Assert.assertTrue("Ожидалось сообщение об ошибке 'Некорректный пароль'", registerPage.isPasswordErrorDisplayed());
    }
}
