package ua.QALightCourse.AQALesson10.homework.Steam.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToLogInButton(){
        driver.findElement(By.cssSelector("a.global_action_link")).click();
    }
}
