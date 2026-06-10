package ua.QALightCourse.AQALesson10.homework.Steam.pages;

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
        this.waiter = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public void logInToAccount(String login, String password)
    {
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._3XCnc4SuTz8V8-jXVwkt_s")));
        driver.findElement(By.cssSelector("input#«r4»")).sendKeys(login);
        driver.findElement(By.cssSelector("input#«r5»")).sendKeys(password);
        driver.findElement(By.cssSelector("button.DjSvCZoKKfoNSmarsEcTS")).click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._1W_6HXiG4JJ0By1qN_0fGZ")));
    }
    public String getLogInErrorText()
    {
        return driver.findElement(By.cssSelector("div._1W_6HXiG4JJ0By1qN_0fGZ")).getText();
    }
}
