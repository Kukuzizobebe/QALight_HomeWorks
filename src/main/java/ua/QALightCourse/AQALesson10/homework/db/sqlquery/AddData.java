package ua.QALightCourse.AQALesson10.homework.db.sqlquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddData {
    public static void main(String[] args) {
        final String URL = "";
        final String userName = "";
        final String dbPassword = "";

        String userEmail = "email@example.com";
        String userPassword = "Password1";

        String sqlQueryToAddUser = "INSERT INTO Rud_usersDataTable (login,password) VALUES (?,?)";

        try(Connection connectiontoMySQLDB = DriverManager.getConnection(URL,userName,dbPassword);
            PreparedStatement preparedStatement = connectiontoMySQLDB.prepareStatement(sqlQueryToAddUser)){
            preparedStatement.setString(1, userEmail);
            preparedStatement.setString(2, userPassword);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
