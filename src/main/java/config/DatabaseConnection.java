package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/employee_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "0074";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("PostgreSQL JDBC Driver not found.");
        }
    }

    public static void checkConnection() {
        try {
            Connection connection = getConnection();
            System.out.println("Connection established successfully.");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Connection failed.");
        }
    }
    
}
