package ua.QALightCourse.AQALesson10.lecturework.sqlquery;

import ua.QALightCourse.AQALesson10.lecturework.localestorage.LocalStorage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class AddDataFromMap {

    public static void main(String[] args) {
        Map<String, String> usersData = LocalStorage.getUserInfo();

        final String URL = "";
        final String userName = "";
        final String dbPassword = "";

        String sqlQueryToAddUser = "INSERT INTO newTable (login,password) VALUES (?,?)";

        try (Connection connectionToMySQLBase = DriverManager.getConnection(URL, userName, dbPassword);
             PreparedStatement preparedStatement = connectionToMySQLBase.prepareStatement(sqlQueryToAddUser)) {

            for (Map.Entry<String, String> userData : usersData.entrySet()) {
                preparedStatement.setString(1, userData.getKey());
                preparedStatement.setString(2, userData.getValue());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
