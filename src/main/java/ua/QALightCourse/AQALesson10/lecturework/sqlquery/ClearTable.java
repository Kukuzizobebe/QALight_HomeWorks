package ua.QALightCourse.AQALesson10.lecturework.sqlquery;

import java.sql.*;

public class ClearTable {

    public static void main(String[] args) {
        final String URL = "";
        final String userName = "";
        final String dbPassword = "";

        String sqlToClearTable = "DELETE FROM newTable;";

        try (Connection connectionToMySQLBase = DriverManager.getConnection(URL, userName, dbPassword);
             Statement statement = connectionToMySQLBase.createStatement()) {
            statement.executeUpdate(sqlToClearTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}