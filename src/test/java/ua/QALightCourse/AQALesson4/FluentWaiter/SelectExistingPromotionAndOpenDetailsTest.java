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

public class SelectExistingPromotionAndOpenDetailsTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        FluentWait<WebDriver> waiter = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);

        try {
            driver.get("https://www.vodafone.ua/shop/");
            driver.manage().window().maximize();

            By xPathPromotionButton = By.xpath("//div[@class = 'top-links-other']//a[contains(.,'Акції')]");
            WebElement promotionButton = waiter.until(ExpectedConditions.elementToBeClickable(xPathPromotionButton));
            promotionButton.click();

            String selectedPromotion = "Саме те до Сезону";
            By xPathSelectedPromotionTab = By.xpath(String.format("//ul[@class = 'promotion-list']//li[contains(.,'%s')]", selectedPromotion));
            WebElement selectedPromotionTab = waiter.until(ExpectedConditions.elementToBeClickable(xPathSelectedPromotionTab));
            selectedPromotionTab.click();

            By xPathTitleNameOfSelectedPromotion = By.xpath("//h1//span");
            WebElement titileOfSelectedPromotion = waiter.until(ExpectedConditions.visibilityOfElementLocated(xPathTitleNameOfSelectedPromotion));
            Assert.assertEquals(selectedPromotion, titileOfSelectedPromotion.getText());
        } finally {
            driver.quit();
        }
    }

}
