package ua.QALightCourse.AQALesson10.lecturework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnLogInButton()
    {
        driver.findElement(By.xpath("//a[contains(@class,'header__user-icon')]")).click();
    }
}
