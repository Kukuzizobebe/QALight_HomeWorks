package ua.QALightCourse.AQALesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private final WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductTitle(){
        return driver.findElement(By.xpath("//h1[contains(@class,'title__main')]")).getText();
    }
}
