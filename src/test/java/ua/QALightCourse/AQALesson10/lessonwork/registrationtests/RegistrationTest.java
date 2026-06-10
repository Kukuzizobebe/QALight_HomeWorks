package ua.QALightCourse.AQALesson10.lessonwork.registrationtests;

import org.apache.commons.lang3.tuple.Pair;
import org.testng.annotations.Test;
import ua.QALightCourse.AQALesson10.lecturework.dbdataproviders.DBDataProvider;
import ua.QALightCourse.AQALesson10.lecturework.pages.HomePage;
import ua.QALightCourse.AQALesson10.lecturework.pages.LogInPage;
import ua.QALightCourse.AQALesson10.lessonwork.basetest.BaseTest;

public class RegistrationTest extends BaseTest {

    @Test
    public void verifyUserCanBeRegistered() {
        Pair<String, String> userCredentials = DBDataProvider.getUserInfo();
        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnLogInButton();

        LogInPage logInPage = new LogInPage(getDriver());
        logInPage.login(userCredentials.getLeft(), userCredentials.getRight());
    }

}
