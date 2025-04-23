package site.nomoreparties.stellarburgers.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import site.nomoreparties.stellarburgers.drivers.DriverFactory;

public abstract class BaseTest {

    protected WebDriver driver;

    @Before
    public void setUp(){
        String browser = System.getProperty("browser", "chrome");
        driver = DriverFactory.getDriver(browser);

        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
