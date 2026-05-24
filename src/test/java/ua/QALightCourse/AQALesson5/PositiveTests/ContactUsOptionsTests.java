package ua.QALightCourse.AQALesson5.PositiveTests;

import ua.QALightCourse.AQALesson5.BaseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ContactUsOptionsTests extends BaseTest {

    @Test
    public void contactViaViberShouldOpenBotPage() {
        setSiteURL("https://allo.ua/");
        String mainTab = getDriver().getWindowHandle();
        WebDriverWait waiter = new WebDriverWait(getDriver(), Duration.ofSeconds(6));
        openContactOptionsMenu(waiter);

        By buttonForContactWithUsInViber = By.xpath("//div[contains(@class,'mh-phone')]//span[contains(.,'Viber')]");
        WebElement buttonForContactViberWithUs = waiter.until(ExpectedConditions.elementToBeClickable(buttonForContactWithUsInViber));
        buttonForContactViberWithUs.click();

        switchTab(waiter, mainTab);

        By botTitle = By.xpath("//h1[@class='mat-display-3']");
        WebElement viberBotTitle = waiter.until(ExpectedConditions.visibilityOfElementLocated(botTitle));

        String titleOfViberBot = "ALLO bot";
        Assert.assertEquals(viberBotTitle.getText(), titleOfViberBot);
    }

    @Test
    public void contactViaCallBackFormPopup() {
        setSiteURL("https://allo.ua/");
        WebDriverWait waiter = new WebDriverWait(getDriver(), Duration.ofSeconds(6));
        openContactOptionsMenu(waiter);

        By buttonForContactWithUsInViber = By.xpath("//div[contains(@class,'mh-phone')]//span[contains(.,'Передзвоніть мені')]");
        WebElement buttonForContactViberWithUs = waiter.until(ExpectedConditions.elementToBeClickable(buttonForContactWithUsInViber));
        buttonForContactViberWithUs.click();

        By callBackPopup = By.xpath("//div[@class='p-small-modal p-small-modal-call']");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(callBackPopup));

        String expectedCallBackPopupDescription = "Є питання чи потрібна консультація? Залиште свій номер телефону і ми вам передзвонимо.";
        By titleOfCallBackPopup = By.xpath("//p[@class='p-small-modal__text']");
        WebElement actualCallBackPopupDescription = waiter.until(ExpectedConditions.visibilityOfElementLocated(titleOfCallBackPopup));

        Assert.assertEquals(actualCallBackPopupDescription.getText(), expectedCallBackPopupDescription);
    }

    private void openContactOptionsMenu(WebDriverWait waiter) {
        By buttonForContactWithUs = By.xpath("//div[contains(@class,'mh-phone')]/button");
        WebElement buttonForContactForHelp = waiter.until(ExpectedConditions.elementToBeClickable(buttonForContactWithUs));
        buttonForContactForHelp.click();
        By contactWithUsTab = By.xpath("//div[contains(@class,'mh-phone__content')]");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(contactWithUsTab));
    }

    private void switchTab(WebDriverWait waiter, String mainTab) {
        waiter.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String tab : getDriver().getWindowHandles()) {
            if (!tab.equals(mainTab)) {
                getDriver().switchTo().window(tab);
                break;
            }
        }
    }
}
