package AQALesson5.DataProvider;

import org.testng.annotations.DataProvider;

public class InvalidPhoneNumbersDataProvider {
    @DataProvider
    public Object[][] shouldShowErrorForInvalidPhoneNumber() {
        return new Object[][]{
                {"089 312 31 23", "Введіть номер мобільного телефону"},
                {"009 312 31 23", "Введіть номер мобільного телефону"},
                {"109 312 31 23", "Введіть номер мобільного телефону"}
        };
    }
}
