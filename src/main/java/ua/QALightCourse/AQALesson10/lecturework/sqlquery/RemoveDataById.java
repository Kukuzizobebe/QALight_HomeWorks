package ua.QALightCourse.AQALesson10.lecturework.sqlquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveDataById {

    public static void main(String[] args) {

        final String URL = "";
        final String userName = "";
        final String dbPassword = "";

        int idToRemove = 2;

        String sqlQueryToDeleteUserById = "DELETE FROM newTable WHERE id = ?;";

        try (Connection connectionToMySQLBase = DriverManager.getConnection(URL, userName, dbPassword);
             PreparedStatement preparedStatement = connectionToMySQLBase.prepareStatement(sqlQueryToDeleteUserById)) {
            preparedStatement.setInt(1,idToRemove);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
