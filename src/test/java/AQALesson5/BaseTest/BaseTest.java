package AQALesson5.BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest{

    protected WebDriver driver;

    @BeforeMethod
    protected void driverInit() {
        this.driver = new ChromeDriver();
    }

    public void setSiteURL(String URL)
    {
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    protected void driverQuit() {
        this.driver.quit();
    }

    protected WebDriver getDriver() {
        return driver;
    }
}
