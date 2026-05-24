package ua.QALightCourse.AQALesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoryProductsPage {

    private final WebDriver driver;
    private final WebDriverWait waiter;

    public CategoryProductsPage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void openProduct(String selectedProduct)
    {
        driver.findElement(By.xpath(String.format("//div[contains(@class,'list-item')]//a[contains(.,'%s')]",
                selectedProduct))).click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='title__main']")));
    }
}
