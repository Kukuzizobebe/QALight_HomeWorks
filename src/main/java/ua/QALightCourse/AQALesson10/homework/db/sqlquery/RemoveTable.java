package ua.QALightCourse.AQALesson10.homework.db.sqlquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RemoveTable {

    public static void main(String[] args) {
        final String URL = "";
        final String userName = "";
        final String dbPassword = "";

        String sqlQueryToRemoveTable = "DROP TABLE IF EXISTS Rud_usersDataTable;";

        try (Connection connectionToMySQLBase = DriverManager.getConnection(URL, userName, dbPassword);
             Statement statement = connectionToMySQLBase.createStatement()) {
            statement.executeUpdate(sqlQueryToRemoveTable);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
