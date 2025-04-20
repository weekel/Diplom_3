package site.nomoreparties.stellarburgers.tests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pom.MainPage;
import site.nomoreparties.stellarburgers.utils.WaitUtils;

import static site.nomoreparties.stellarburgers.config.Url.MAIN_PAGE_URL;

@DisplayName("Тесты главной страницы (Конструктор)")
public class ConstructorTests extends BaseTest{
    private MainPage mainPage;

    @Before
    public void initPage() {
        driver.get(MAIN_PAGE_URL);
        mainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Переход к разделу 'Булки'")
    @Description("Проверяет, что при клике на раздел 'Булки' открывается соответствующий контент")
    public void clickBunsButtonSelectsBunsTab() {
        mainPage.clickSaucesConstructorTab();

        mainPage.clickBunsConstructorTab();
        WaitUtils.waitForElementVisible(driver, mainPage.getBunsTabSelected());
        Assert.assertTrue("Таб 'Булки' не стал активным", mainPage.isBunTabSelected());
    }

    @Test
    @DisplayName("Клик по кнопке 'Соусы' выбирает соответствующий таб")
    @Description("Проверяет, что при клике на таб 'Соусы' он становится активным")
    public void clickSaucesButtonSelectsSaucesTab() {
        mainPage.clickSaucesConstructorTab();

        WaitUtils.waitForElementVisible(driver, mainPage.getSaucesTabSelected());

        Assert.assertTrue("Таб 'Соусы' не стал активным", mainPage.isSaucesTabSelected());
    }

    @Test
    @DisplayName("Клик по кнопке 'Начинки' выбирает соответствующий таб")
    @Description("Проверяет, что при клике на таб 'Начинки' он становится активным")
    public void clickFillingsButtonSelectsFillingsTab() {
        mainPage.clickFillingsConstructorTab();

        WaitUtils.waitForElementVisible(driver, mainPage.getFillingsTabSelected());

        Assert.assertTrue("Таб 'Начинки' не стал активным", mainPage.isFillingsTabSelected());
    }
}
