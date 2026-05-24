package ua.QALightCourse.AQALesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoryPage {

    private final WebDriver driver;
    private final WebDriverWait waiter;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void selectSubCategory(String subCategory) {
        driver.findElement(By.xpath(String.format("//div[contains(@class,'section-navigation__item')]//div[contains(.,'%s')]", subCategory))).click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='catalog-title__main']")));
    }

}
