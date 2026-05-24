package ua.QALightCourse.AQALesson3;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class ChangeToLightThemeVerificatonTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://hotline.ua/");
            driver.manage().window().maximize();
            Thread.sleep(3000);

            WebElement changeThemeButton = driver.findElement(By.xpath("//button[contains(@class,'color-switcher') and contains(@parent-class,'header__lang-icon')]"));
            WebElement colourSVGIcon = driver.findElement(By.xpath("//button[contains(@class,'color-switcher') and contains(@parent-class,'header__lang-icon')]/*[contains(@class,'color-switcher__icon')]"));
            String classBefore = colourSVGIcon.getAttribute("class");
            changeThemeButton.click();
            Thread.sleep(1000);

            String classAfter = colourSVGIcon.getAttribute("class");
            Thread.sleep(2000);

            String errorMessage = "This theme isn`t light theme!";
            Assert.assertTrue(errorMessage, !Objects.equals(classAfter, classBefore));
        } finally {
            driver.quit();
        }
    }
}
