package ua.QALightCourse.AQALesson10.lecturework.sqlquery;

import java.sql.*;

public class RemoveTable {
    public static void main(String[] args) {
        final String URL = "";
        final String userName = "";
        final String dbPassword = "";

        String sqlQueryToRemoveTable = "DROP TABLE IF EXISTS newTable;";

        try (Connection connectionToMySQLBase = DriverManager.getConnection(URL, userName, dbPassword);
             Statement statement = connectionToMySQLBase.createStatement()) {
            statement.executeUpdate(sqlQueryToRemoveTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
