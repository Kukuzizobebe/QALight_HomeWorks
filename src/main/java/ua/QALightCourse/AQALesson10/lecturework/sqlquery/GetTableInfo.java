package ua.QALightCourse.AQALesson10.lecturework.sqlquery;

import java.sql.*;

public class GetTableInfo {

    public static void main(String[] args) {

        final String URL = "";
        final String userName = "";
        final String dbPassword = "";

        String tableName = "newTable";
        String query = "SELECT * FROM " + tableName;

        try (Connection connection = DriverManager.getConnection(URL, userName, dbPassword);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-20s", metaData.getColumnName(i));
            }
            System.out.println();

            for (int i = 1; i <= columnCount; i++) {
                System.out.print("--------------------");
            }
            System.out.println();

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.printf("%-20s", rs.getString(i));
                }
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println("Connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}