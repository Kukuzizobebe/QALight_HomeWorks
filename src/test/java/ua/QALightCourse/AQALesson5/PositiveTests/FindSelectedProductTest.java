package ua.QALightCourse.AQALesson5.PositiveTests;

import ua.QALightCourse.AQALesson5.BaseTest.BaseTest;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Map;

public class FindSelectedProductTest extends BaseTest {

    private static final Map<String, String> SELECTED_PRODUCT = Map.ofEntries(
            Map.entry("BrandName", "Apple"),
            Map.entry("ModelName", "iPhone 17 Pro Max"),
            Map.entry("GB", "256GB"),
            Map.entry("Colour", "Cosmic Orange"),
            Map.entry("ModelNumber", "(MFYN4)"),
            Map.entry("FullNameOfProduct", "Apple iPhone 17 Pro Max 256GB Cosmic Orange (MFYN4)"),
            Map.entry("TypeOfProduct", "Смартфони Apple")
    );

    @Test
    public void findProductFromSearchResults() {

        setSiteURL("https://allo.ua/");
        WebDriverWait waiter = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

        By inputSearchField = By.xpath("//input[@id = 'search-form__input']");
        WebElement searchInput = waiter.until(ExpectedConditions.visibilityOfElementLocated(inputSearchField));
        searchInput.sendKeys(SELECTED_PRODUCT.get("FullNameOfProduct"));

        By searchButton = By.xpath("//form//button[@class = 'search-form__submit-button']");
        WebElement buttonForSearch = waiter.until(ExpectedConditions.elementToBeClickable(searchButton));
        buttonForSearch.click();

        verifyAndOpenProduct(waiter);
    }

    @Test
    public void findProductFromCatalogResults() {

        setSiteURL("https://allo.ua/");
        WebDriverWait waiter = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

        By catalogButton = By.xpath("//div[@class='ct-button']");
        WebElement inputSearchField = waiter.until(ExpectedConditions.elementToBeClickable(catalogButton));
        inputSearchField.click();

        By productCategoryCatalog = By.xpath(String.format("//div[@class='mm']//a[@class = 'mm__a' and contains(normalize-space(),'%s')]", SELECTED_PRODUCT.get("BrandName")));
        WebElement productCategoryInCatalog = waiter.until(ExpectedConditions.elementToBeClickable(productCategoryCatalog));

        Actions actions = new Actions(getDriver());
        actions.moveToElement(productCategoryInCatalog).perform();

        By productModelFromCatalogWindow = By.xpath(String.format("//div[contains(@class,'mm__sub-wrapper')]//a[contains(.,'%s')]", SELECTED_PRODUCT.get("TypeOfProduct")));
        WebElement selectedProductModelFromCatalogWindow = waiter.until(ExpectedConditions.visibilityOfElementLocated(productModelFromCatalogWindow));
        selectedProductModelFromCatalogWindow.click();

        verifyAndOpenProduct(waiter);
    }

    private void verifyAndOpenProduct(WebDriverWait waiter) {
        By productFromResultPage = By.xpath(String.format("//div[@class = 'product-card__content']//a[contains(.,'%s')]",
                SELECTED_PRODUCT.get("FullNameOfProduct")));
        WebElement selectedProductFromResultPage = waiter.until(ExpectedConditions.visibilityOfElementLocated(productFromResultPage));
        selectedProductFromResultPage.click();

        By productTitle = By.xpath("//h1[@class='p-view__header-title']");
        WebElement productOfTitle = waiter.until(ExpectedConditions.visibilityOfElementLocated(productTitle));

        Assert.assertTrue(productOfTitle.getText().contains(SELECTED_PRODUCT.get("FullNameOfProduct")));
    }
}
