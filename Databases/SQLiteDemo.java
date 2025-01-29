package Databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class SQLiteDemo {
    public static void main(String[] args) {
        //URL to connect to SQLite database
        String url = "jdbc:sqlite:mydatavase.db";

        //SQL command to create a table
        String createTableSQL = "CREATE TABLE IF NOT EXISTS student (" + "id INTEGER PRIMARY KEY," + "name TEXT NOT NULL," + "age INTEGER" + ");";

        try (Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement()){
                //if connection is successful
                if(conn != null){
                    System.out.println("Connected to the SQLite database.");

                    //Execute the SQL command to create the table
                    stmt.execute(createTableSQL);
                    System.out.println("Table 'students' created or already exists.");
                }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    String insertDataSQL = "INSERT INTO students (name, age) VALUES ('Alice', 23);";
    String selectDataSQL = "SELECT * FROM students;";

    try(Connection conn = DriverManager.getConnection(url);
    Statement stmt = conn.createStatement()){
        //Insert a new student
        stmt.executeQuery(insertDataSQL);
        System.out.println("Inserted a new student.");

        //Query the students table
        ResultSet rs = stmt.executeQuery(selectDataSQL);

        while(rs.next()){
            System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getInt("age"));
        }
    } catch (SQLException e){
        System.out.println(e.getMessage());
    }
}

