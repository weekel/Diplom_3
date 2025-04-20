package site.nomoreparties.stellarburgers.pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    //Локаторы для входа в аккаунт
    private final By loginButtonOnPage = By.xpath("//button[text()='Войти в аккаунт']");
    private final By personalCabinetButton = By.xpath("//p[text()='Личный Кабинет']");

    //Локаторы разделов конструктора
    private final By bunsConstructorTab = By.xpath("//span[text()='Булки']");
    private final By saucesConstructorTab = By.xpath("//span[text()='Соусы']");
    private final By fillingsConstructorTab = By.xpath("//span[text()='Начинки']");

    private final By bunsTabSelected = By.xpath("//div[contains(@class,'tab_tab_type_current')]/span[text()='Булки']");
    private final By saucesTabSelected = By.xpath("//div[contains(@class,'tab_tab_type_current')]/span[text()='Соусы']");
    private final By fillingsTabSelected = By.xpath("//div[contains(@class,'tab_tab_type_current')]/span[text()='Начинки']");


    private final By placeOrderButton = By.xpath("//button[text()='Оформить заказ']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //Методы для тестирования входа в аккаунт
    @Step("Клик по кнопке 'Войти в аккаунт' на главной странице")
    public void clickLoginButtonOnPage() {
        driver.findElement(loginButtonOnPage).click();
    }

    @Step("Клик по кнопке 'Личный кабинет' на главной странице")
    public void clickPersonalCabinetButton() {
        driver.findElement(personalCabinetButton).click();
    }

    @Step("Проверка отображения кнопки 'Оформить заказ'")
    public boolean isPlaceOrderButtonVisible() {
        return driver.findElement(By.xpath("//button[text()='Оформить заказ']")).isDisplayed();
    }

    //Методы для тестирования переходов между разделами

    public By getBunsConstructorTab() {
        return bunsConstructorTab;
    }

    public By getBunsTabSelected() {
        return bunsTabSelected;
    }

    public By getSaucesTabSelected() {
        return saucesTabSelected;
    }

    public By getFillingsTabSelected() {
        return fillingsTabSelected;
    }

    @Step("Клик по вкладке 'Булки' в конструкторе")
    public void clickBunsConstructorTab() {
        driver.findElement(bunsConstructorTab).click();
    }

    @Step("Клик по вкладке 'Соусы' в конструкторе")
    public void clickSaucesConstructorTab() {
        driver.findElement(saucesConstructorTab).click();
    }

    @Step("Клик по вкладке 'Начинки' в конструкторе")
    public void clickFillingsConstructorTab() {
        driver.findElement(fillingsConstructorTab).click();
    }

    @Step("Проверка, что вкладка 'Булки' выбрана")
    public boolean isBunTabSelected() {
        return driver.findElement(bunsTabSelected).isDisplayed();
    }

    @Step("Проверка, что вкладка 'Соусы' выбрана")
    public boolean isSaucesTabSelected() {
        return driver.findElement(saucesTabSelected).isDisplayed();
    }

    @Step("Проверка, что вкладка 'Начинки' выбрана")
    public boolean isFillingsTabSelected() {
        return driver.findElement(fillingsTabSelected).isDisplayed();
    }
}
