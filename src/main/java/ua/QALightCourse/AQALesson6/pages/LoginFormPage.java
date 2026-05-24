package ua.QALightCourse.AQALesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginFormPage {

    private final WebDriver driver;

    public LoginFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillLoginForm(String userLogin, String userPassword) {
        WebElement userLoginField = driver.findElement(By.xpath("//input[@inputmode='email']"));
        userLoginField.sendKeys(userLogin);
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@type='password']"));
        userPasswordField.sendKeys(userPassword);
    }

    public void submitFilledLoginForm() {
        By loginFilledFields = By.xpath("//input[@inputmode='email']");
        driver.findElement(loginFilledFields).sendKeys(Keys.ENTER);
    }

    public String errorLoginText() {
        return driver.findElement(By.xpath("//div[contains(@class,'error')]")).getText();
    }

}
