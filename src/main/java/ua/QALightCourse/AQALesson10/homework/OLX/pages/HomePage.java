package ua.QALightCourse.AQALesson10.homework.OLX.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToLogInButton()
    {
        driver.findElement(By.xpath("//a[@data-testid='myolx-link']")).click();
    }
}
