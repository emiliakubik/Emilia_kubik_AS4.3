package Databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Practice {
    public static void main(String[] args) {
        // URL to connect to SQLite database
        String url = "jdbc:sqlite:mydatabase.db";

        // SQL command to create a table
        String createTableSQL = "CREATE TABLE IF NOT EXISTS students ("
                + "id INTEGER PRIMARY KEY, "
                + "name TEXT NOT NULL, "
                + "age INTEGER"
                + ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
             
            // If connection is successful
            if (conn != null) {
                System.out.println("Connected to the SQLite database.");

                // Execute the SQL command to create the table
                stmt.execute(createTableSQL);
                System.out.println("Table 'students' created or already exists.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

