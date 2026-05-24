package ua.QALightCourse.AQALesson6.dataprovider;

import org.testng.annotations.DataProvider;

public class LoginTestData {
    @DataProvider
    public Object[][] invalidLoginCredentialsData() {
        return new Object[][]{
                {"Test", "Test12345!"},
        };
    }
}
