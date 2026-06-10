package ua.QALightCourse.AQALesson10.homework.loginintests.OLX;

import org.apache.commons.lang3.tuple.Pair;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.QALightCourse.AQALesson10.homework.OLX.pages.HomePage;
import ua.QALightCourse.AQALesson10.homework.OLX.pages.LogInPage;
import ua.QALightCourse.AQALesson10.homework.basetest.BaseTest;
import ua.QALightCourse.AQALesson10.homework.db.dbdataprovider.DataBaseProvider;

public class LoginInNegativeTests extends BaseTest {

    @Test
    public void shouldNotLogInToOLXWithInvalidCredentials() {

        getDriver().get("https://www.olx.ua/uk/");

        Pair<String, String> userCredentials = DataBaseProvider.getUserCredentials();
        String expectedErrorText = "Неможливо продовжити, оскільки ми виявили підозрілу активність. Якщо ви вважаєте, що це помилка, звʼяжіться з нашою командою.";

        HomePage homePage = new HomePage(getDriver());
        homePage.clickToLogInButton();

        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.logInToAccount(userCredentials.getLeft(), userCredentials.getRight());
        String actualErrorText = logInPage.getLogInErrorText();

        Assert.assertTrue(actualErrorText.contains(expectedErrorText));
    }
}

