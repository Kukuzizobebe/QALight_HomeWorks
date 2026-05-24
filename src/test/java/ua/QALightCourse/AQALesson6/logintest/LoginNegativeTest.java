package ua.QALightCourse.AQALesson6.logintest;

import ua.QALightCourse.AQALesson6.basetest.BaseTest;
import ua.QALightCourse.AQALesson6.dataprovider.LoginTestData;
import org.testng.Assert;
import org.testng.annotations.Test;
import ua.QALightCourse.AQALesson6.pages.HomePage;
import ua.QALightCourse.AQALesson6.pages.LoginFormPage;

public class LoginNegativeTest extends BaseTest {

    @Test(dataProviderClass = LoginTestData.class, dataProvider = "invalidLoginCredentialsData")
    public void shouldNotLoginWithInvalidCredentials(String userLogin, String userPasswond) {
        HomePage homePage = new HomePage(getDriver());
        homePage.openLoginForm();

        String expectedResult = "Введіть коректний email або номер мобільного телефону";
        LoginFormPage loginFormPage = new LoginFormPage(getDriver());
        loginFormPage.fillLoginForm(userLogin, userPasswond);
        loginFormPage.submitFilledLoginForm();

        Assert.assertEquals(loginFormPage.errorLoginText(), expectedResult);
    }


}
