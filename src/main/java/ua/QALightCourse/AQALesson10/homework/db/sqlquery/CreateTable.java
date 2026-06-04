package ua.QALightCourse.AQALesson10.homework.db.sqlquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public static void main(String[] args) {

        final String URL = "";
        final String userName = "";
        final String dbPassword = "";

        String sqlQueryToCreateTable = "CREATE TABLE IF NOT EXISTS Rud_usersDataTable (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "login VARCHAR(255) NOT NULL, " +
                "password VARCHAR(255) NOT NULL" +
                ");";
        try (Connection connectionToMySQLDB = DriverManager.getConnection(URL, userName, dbPassword);
             Statement statement = connectionToMySQLDB.createStatement()) {
            statement.executeUpdate(sqlQueryToCreateTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
