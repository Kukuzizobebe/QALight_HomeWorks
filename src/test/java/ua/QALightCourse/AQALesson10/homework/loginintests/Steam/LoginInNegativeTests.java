package ua.QALightCourse.AQALesson10.homework.loginintests.Steam;

import org.apache.commons.lang3.tuple.Pair;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.QALightCourse.AQALesson10.homework.Steam.pages.HomePage;
import ua.QALightCourse.AQALesson10.homework.Steam.pages.LogInPage;
import ua.QALightCourse.AQALesson10.homework.basetest.BaseTest;
import ua.QALightCourse.AQALesson10.homework.db.dbdataprovider.DataBaseProvider;

public class LoginInNegativeTests extends BaseTest {

    @Test
    public void shouldNotLogInToSteamWithInvalidCredentials() {
        getDriver().get("https://store.steampowered.com/");

        Pair<String, String> userCredentials = DataBaseProvider.getUserCredentials();
        String expectedErrorText = "Будь ласка, перевірте логін і пароль свого акаунта, а потім спробуйте знову.";

        HomePage homePage = new HomePage(getDriver());
        homePage.clickToLogInButton();

        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.logInToAccount(userCredentials.getLeft(), userCredentials.getRight());
        String actualErrorText = logInPage.getLogInErrorText();
        Assert.assertTrue(expectedErrorText.contains(actualErrorText));
    }
}

