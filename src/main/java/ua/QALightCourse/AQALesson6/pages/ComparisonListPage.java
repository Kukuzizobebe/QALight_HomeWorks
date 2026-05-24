package ua.QALightCourse.AQALesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ComparisonListPage {

    private final WebDriver driver;

    public ComparisonListPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getListOfAddedProducts() {
        List<String> listOfAddedModels = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class,'title-link')]"));
        for (WebElement element : elements) {
            listOfAddedModels.add(element.getText());
        }
        return listOfAddedModels;
    }

}
