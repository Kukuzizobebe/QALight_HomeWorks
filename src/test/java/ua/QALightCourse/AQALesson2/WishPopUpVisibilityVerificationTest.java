package ua.QALightCourse.AQALesson2;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishPopUpVisibilityVerificationTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://hotline.ua/");
            driver.manage().window().maximize();
            Thread.sleep(3000);

            WebElement wishListButton = driver.findElement(By.xpath("//div[@class='popover my-lists']//div[@class='popover-head']"));
            wishListButton.click();

            Thread.sleep(3000);

            WebElement wishListPopUp = driver.findElement(By.xpath("//div[contains(@class,'my-lists__section')]"));

            Assert.assertTrue("Wish list popup isn`t displayed", wishListPopUp.isDisplayed());
        } finally {
            driver.quit();
        }
    }
}
