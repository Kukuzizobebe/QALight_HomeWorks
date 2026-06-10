package ua.QALightCourse.AQALesson10.lecturework.sqlquery;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class GetDataAndUse {

    public static void main(String[] args) {
        Map<String, String> usersData = new HashMap<>();

        final String URL = "";
        final String userName = "";
        final String dbPassword = "";

        String sqlQueryToFindUser = "SELECT login, password FROM newTable;";

        try (Connection connectionToMySQLBase = DriverManager.getConnection(URL, userName, dbPassword);
             Statement statement = connectionToMySQLBase.createStatement();
             ResultSet result = statement.executeQuery(sqlQueryToFindUser)) {

            while (result.next()) {
                String userEmail = result.getString("login");
                String userPassword = result.getString("password");
                usersData.put(userEmail, userPassword);
            }
            System.out.println("------Obrained users are: " + usersData);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
