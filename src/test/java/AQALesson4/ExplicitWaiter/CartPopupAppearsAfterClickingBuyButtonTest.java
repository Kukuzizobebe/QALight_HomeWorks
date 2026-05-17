package AQALesson4.ExplicitWaiter;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPopupAppearsAfterClickingBuyButtonTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://www.vodafone.ua/shop/");
            driver.manage().window().maximize();

            String productName = "Смартфон Apple iPhone 16 128GB Black";
            WebElement inputFieldForSearch = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search']")));
            inputFieldForSearch.sendKeys(productName);
            inputFieldForSearch.sendKeys(Keys.ENTER);

            By resultLocator = By.xpath("//div[@class='title-has-result']");
            waiter.until(ExpectedConditions.textToBePresentInElementLocated(resultLocator, String.format("Пошук по запиту: '%s'", productName)));

            WebElement cartButton = waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format("//div[contains(@class,'product-item-info')]" +
                    "[.//a[contains(.,'%s')]]//button[@type = 'submit']", productName))));
            cartButton.click();

            By xPathPopupTitle = By.xpath("//div[@id = 'minicart-content-wrapper']");
            WebElement cartPopup = waiter.until(ExpectedConditions.visibilityOfElementLocated(xPathPopupTitle));
            Assert.assertTrue(cartPopup.getText().contains("Кошик"));
        } finally {
            driver.quit();
        }

    }
}
