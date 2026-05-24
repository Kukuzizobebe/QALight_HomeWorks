package ua.QALightCourse.AQALesson4.FluentWaiter;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class ProductCategoryNameDisplayInCatalogTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        FluentWait<WebDriver> waiter = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        try {
            driver.get("https://www.vodafone.ua/shop/");
            driver.manage().window().maximize();

            String selectedProductCategoryName = "Apple";
            String selectedProductSubCategoryName = "Apple Watch";
            By xPathButtonProductCalatog = By.xpath("//button[@class = 'open-catalog']");
            waiter.until(ExpectedConditions.elementToBeClickable(xPathButtonProductCalatog));
            WebElement productCatalog = driver.findElement(xPathButtonProductCalatog);
            productCatalog.click();

            By xPathProductCategoryWindow = By.xpath(String.format("//div[@class = 'navigation']//span[contains(.,'%s')]", selectedProductCategoryName));
            waiter.until(ExpectedConditions.visibilityOfElementLocated(xPathProductCategoryWindow));
            WebElement productCatalogWindow = driver.findElement(xPathProductCategoryWindow);
            productCatalogWindow.click();

            By xPathProductSubCategoryWindow = By.xpath(String.format("//div[@class = 'navigation']//strong[contains(.,'%s')]", selectedProductSubCategoryName));
            waiter.until(ExpectedConditions.visibilityOfElementLocated(xPathProductSubCategoryWindow));
            WebElement productSubCatalogTitle = driver.findElement(xPathProductSubCategoryWindow);
            productSubCatalogTitle.click();

            By xPathResultOfSearchTextDescription = By.xpath(String.format("//h1//span[contains(.,'%s')]", selectedProductSubCategoryName));
            waiter.until(ExpectedConditions.visibilityOfElementLocated(xPathResultOfSearchTextDescription));
            WebElement titleResultOfSearch = driver.findElement(xPathResultOfSearchTextDescription);
            Assert.assertTrue(titleResultOfSearch.getText().contains(selectedProductSubCategoryName));
        } finally {
            driver.quit();
        }

    }
}
