package AQALesson3;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChangeLanguageToRUVerificationTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://hotline.ua/");
            driver.manage().window().maximize();
            Thread.sleep(3000);

            WebElement buttonForChangeLanguage = driver.findElement(By.xpath("//div[contains(@class,'lang-item') and contains(.,'RU')]"));
            buttonForChangeLanguage.click();

            String language = "RU";
            String errorMessage = "This language is already chosen on this page";
            Thread.sleep(3000);

            WebElement buttonForChangeLanguageRU = driver.findElement(By.xpath("//div[@class = 'lang-item' and contains(.,'RU')]"));
            Thread.sleep(3000);

            buttonForChangeLanguageRU.click();
            Thread.sleep(5000);

            WebElement buttonCurrentLanguage = driver.findElement(By.xpath("//div[contains(@class,'lang-button')]"));

            Assert.assertTrue(errorMessage,buttonCurrentLanguage.getText().equals(language));
        } finally {
            driver.quit();
        }

    }

}
