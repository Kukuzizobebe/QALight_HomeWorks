package ua.QALightCourse.AQALesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultPage {

    private final WebDriver driver;
    private final WebDriverWait waiter;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void addSelectedProductToComparisonList(List<String> listOfSelectedProductModels) {
        if (listOfSelectedProductModels == null || listOfSelectedProductModels.isEmpty()) {
            return;
        }
        for (String model : listOfSelectedProductModels) {
            By compareButton = By.xpath(String.format("//div[contains(@class,'list-item')][.//a[contains(.,'%s')]]//button[@class='compare-button']",
                    model));
            waiter.until(ExpectedConditions.elementToBeClickable(compareButton)).click();
        }
    }

    public void openComparisonListDetails() {
        driver.findElement(By.xpath("//div[contains(@class,'product-compare')]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'profile-sidebar__section-child-container')]")).click();
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='table']")));
    }
}
