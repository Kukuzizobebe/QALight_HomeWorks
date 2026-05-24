package ua.QALightCourse.AQALesson4.ExplicitWaiter;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OTPRequestByPhoneNumberForExistUserTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            driver.get("https://www.vodafone.ua/shop/");
            driver.manage().window().maximize();

            String selectedPhoneNumber = "+38(075) 121-21-99";
            WebElement authorizeButton = waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'header')]//a[contains(@href,'login') " +
                    "and contains(.,'Особистий кабінет')]")));
            authorizeButton.click();

            WebElement phoneInput = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-type='tel']")));

            phoneInput.sendKeys(selectedPhoneNumber);

            waiter.until(ExpectedConditions.attributeToBe(By.xpath("//input[@data-type='tel']"), "value", selectedPhoneNumber));

            waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'login')]"))).click();

            String textInFieldForOTP = "Введіть код із повідомлення";
            WebElement otpField = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
            Assert.assertEquals(textInFieldForOTP, otpField.getAttribute("placeholder"));

        } finally {
            driver.quit();
        }
    }

}
