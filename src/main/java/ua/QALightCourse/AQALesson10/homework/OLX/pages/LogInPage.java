package ua.QALightCourse.AQALesson10.homework.OLX.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPage {
    private WebDriver driver;
    private WebDriverWait waiter;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    public void logInToAccount(String login, String password)
    {
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.css-ymo82s")));
        driver.findElement(By.cssSelector("input#username")).sendKeys(login);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        driver.findElement(By.cssSelector("button#Login")).click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#error-banner")));
    }
    public String getLogInErrorText()
    {
       return driver.findElement(By.cssSelector("div#error-banner")).getText();
    }
}
