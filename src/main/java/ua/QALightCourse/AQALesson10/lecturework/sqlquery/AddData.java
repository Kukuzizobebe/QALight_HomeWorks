package ua.QALightCourse.AQALesson10.lecturework.sqlquery;

import java.sql.*;

public class AddData {

    public static void main(String[] args) {

        final String URL = "";
        final String userName = "";
        final String dbPassword = "";

        String userEmail = "email@example.com";
        String userPassword = "Password1";

        String sqlQueryToAddUser = "INSERT INTO newTable (login,password) VALUES (?,?)";

        try (Connection connectionToMySQLBase = DriverManager.getConnection(URL, userName, dbPassword);
             PreparedStatement preparedStatement = connectionToMySQLBase.prepareStatement(sqlQueryToAddUser)) {

            preparedStatement.setString(1, userEmail);
            preparedStatement.setString(2, userPassword);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
