package ua.QALightCourse.AQALesson10.lecturework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPage {

    private WebDriver driver;
    private WebDriverWait waiter;

    public LogInPage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(this.driver, Duration.ofSeconds(15));
    }

    public void login(String email, String password) {
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='content login-form']")));
        driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@autocomplete='current-password']")).sendKeys(password);
        WebElement button = waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
        button.click();
    }
}
