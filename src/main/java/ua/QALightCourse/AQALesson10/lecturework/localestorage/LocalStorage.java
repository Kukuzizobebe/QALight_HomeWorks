package ua.QALightCourse.AQALesson10.lecturework.localestorage;

import java.util.Map;

public class LocalStorage {

    public static Map<String, String> getUserInfo() {
        return Map.of("anton@example.com", "Password3",
                "ivan@example.com", "Password4",
                "bohdan@example.com", "Password5",
                "artem@example.com", "Password6",
                "semen@example.com", "Password7");
    }
}
