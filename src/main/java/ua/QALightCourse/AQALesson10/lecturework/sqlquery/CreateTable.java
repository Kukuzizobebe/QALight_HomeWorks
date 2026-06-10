package ua.QALightCourse.AQALesson10.lecturework.sqlquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public static void main(String[] args) {

        final String URL = "";
        final String userName = "";
        final String dbPassword = "";

        String sqlQueryToCreateTable = "CREATE TABLE IF NOT EXISTS newTable (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "login VARCHAR(255) NOT NULL, " +
                "password VARCHAR(255) NOT NULL" +
                ");";

        try (Connection connectionToMySQLBase = DriverManager.getConnection(URL, userName, dbPassword);
             Statement statement = connectionToMySQLBase.createStatement()) {
            statement.executeUpdate(sqlQueryToCreateTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
