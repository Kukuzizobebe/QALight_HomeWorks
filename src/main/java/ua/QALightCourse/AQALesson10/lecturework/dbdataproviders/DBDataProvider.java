package ua.QALightCourse.AQALesson10.lecturework.dbdataproviders;

import org.apache.commons.lang3.tuple.Pair;

import java.sql.*;

public class DBDataProvider {

    public static Pair<String, String> getUserInfo() {
        final String URL = "";
        final String userName = "";
        final String dbPassword = "";

        Pair<String, String> usersData = null;

        String sql = "SELECT login, password FROM newTable";

        try (Connection connection = DriverManager.getConnection(URL, userName, dbPassword);
             Statement statement = connection.createStatement();
             ResultSet result= statement.executeQuery(sql)) {

            while (result.next()) {
                String login = result.getString("login");
                String password = result.getString("password");
                usersData = (Pair.of(login, password));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error while fetching users from DB", e);
        }

        return usersData;
    }
}