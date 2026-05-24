package ua.QALightCourse.AQALesson4.ImplicitWaiter;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class SelectedAddonPresenceTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.vodafone.ua/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            String selectedAddon = "Online PASS";
            WebElement addonSectionTab = driver.findElement(By.xpath("//li[contains(@class,'links__item')]//a[contains(@href,'services')]"));
            addonSectionTab.click();

            WebElement addonTabWithInformation = driver.findElement(By.xpath(String.format("//div[contains(@class,'vf-service-card__title') and contains(.,'%s')]", selectedAddon)));
            Assert.assertEquals(selectedAddon, addonTabWithInformation.getText());

        } finally {
            driver.quit();
        }
    }
}
