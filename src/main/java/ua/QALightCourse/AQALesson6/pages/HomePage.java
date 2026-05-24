package ua.QALightCourse.AQALesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait waiter;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void openLoginForm() {
        driver.findElement(By.xpath("//a[contains(@class,'user-button')]")).click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form")));
    }

    public void searchProduct(String selectedProduct) {
        By searchInputField = By.xpath("//input[@type='text']");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(searchInputField));
        driver.findElement(searchInputField).sendKeys(selectedProduct);
        driver.findElement(By.xpath("//button[contains(@class,'search__btn flex')]")).click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'search__list')]")));
    }

    public void openCategoryFromIcons(String nameOfCategory) {
        driver.findElement(By.xpath(String.format("//div[contains(@class,'categories-section__inner')]//a[contains(.,'%s')]", nameOfCategory))).click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(@class,'title-page')]")));
    }

}
