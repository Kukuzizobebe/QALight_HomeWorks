package ua.QALightCourse.AQALesson6.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    private WebDriver driver;

    @BeforeMethod
    protected void driverInit() {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hotline.ua/");
    }

    @AfterMethod
    protected void driverQuit() {
        this.driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
