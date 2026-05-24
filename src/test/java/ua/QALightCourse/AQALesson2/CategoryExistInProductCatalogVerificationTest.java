package ua.QALightCourse.AQALesson2;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static java.lang.String.format;

public class CategoryExistInProductCatalogVerificationTest {

    public static void main(String[] args) throws InterruptedException {

        String category = "LEGO";
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://hotline.ua/");
            driver.manage().window().maximize();

            Thread.sleep(3000);

            WebElement productCatalogButton = driver.findElement(By.xpath("//div[@class='button-menu-main ']"));
            productCatalogButton.click();

            Thread.sleep(3000);

            List<WebElement> categoriesInProductCategoriesMenu = driver.findElements(By.xpath("//ul[@class='menu-main__list']//li"));

            String errorMessage = "Category is incorrect. It doesn`t exist in product category menu";

            boolean isCategoryPresent = categoriesInProductCategoriesMenu.stream()
                    .map(WebElement::getText)
                    .anyMatch(o -> o.contains(category));

            Assert.assertTrue(errorMessage, isCategoryPresent);

        } finally {
            driver.quit();
        }

    }
}
