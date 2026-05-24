package ua.QALightCourse.AQALesson5.NegativeTests;

import ua.QALightCourse.AQALesson5.BaseTest.BaseTest;
import ua.QALightCourse.AQALesson5.DataProvider.InvalidPhoneNumbersDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class InvalidPhoneAuthorizationTest extends BaseTest {

    @Test(dataProvider = "shouldShowErrorForInvalidPhoneNumber", dataProviderClass = InvalidPhoneNumbersDataProvider.class)
    public void checkCategoryPage(String invalidPhoneNumber, String expectedTextError) {

        setSiteURL("https://rozetka.com.ua/");
        WebDriverWait waiter = new WebDriverWait(getDriver(), Duration.ofSeconds(5));

        By authorizeButton = By.xpath("//button[contains(@class,'reset-btn d-block')]");
        WebElement categoriesButton = waiter.until(ExpectedConditions.visibilityOfElementLocated(authorizeButton));
        categoriesButton.click();

        By authorizePopup = By.xpath("//div[contains(@class,'content')]");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(authorizePopup));

        By inputField = By.xpath("//input[@id='phone']");
        WebElement inputNumberField = waiter.until(ExpectedConditions.visibilityOfElementLocated(inputField));
        inputNumberField.sendKeys(invalidPhoneNumber);

        By buttonContinueAuth = By.xpath("//button[contains(@class,'submit-button')]");
        WebElement buttonContinue = waiter.until(ExpectedConditions.elementToBeClickable(buttonContinueAuth));
        buttonContinue.click();

        By textError = By.xpath("//p[contains(@class,'validation-message')]");
        WebElement actualTextError = waiter.until(ExpectedConditions.presenceOfElementLocated(textError));

        Assert.assertEquals(actualTextError.getText(), expectedTextError);
    }
}
