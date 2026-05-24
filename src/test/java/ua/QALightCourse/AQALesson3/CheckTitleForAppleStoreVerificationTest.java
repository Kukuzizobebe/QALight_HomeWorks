package ua.QALightCourse.AQALesson3;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;;

public class CheckTitleForAppleStoreVerificationTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://hotline.ua/");
            driver.manage().window().maximize();
            Thread.sleep(3000);

            String correctTitleForAppleStore = "hotline - порівняння цін";
            String mainTab = driver.getWindowHandle();
            WebElement appleStoreDownloadButton = driver.findElement(By.xpath("//div[contains(@class,'app-text__buttons')]//a[contains(@href,'apps.apple.com')]"));
            appleStoreDownloadButton.click();
            Thread.sleep(2000);

            for (String tab : driver.getWindowHandles()) {
                if (!tab.equals(mainTab)) {
                    driver.switchTo().window(tab);
                    break;
                }
            }
            Thread.sleep(2000);

            WebElement titleOnAppleStore = driver.findElement(By.xpath("//h1//span[contains(@class,'multiline-clamp__text')]"));
            String errorMessage = String.format("This title is not equals to title: %s", correctTitleForAppleStore);
            Assert.assertTrue(errorMessage, Objects.equals(titleOnAppleStore.getText(), correctTitleForAppleStore));
        } finally {
            driver.quit();
        }

    }

}
