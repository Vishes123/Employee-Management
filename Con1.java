package Jdbc_project;

import java.sql.*;
import java.sql.Statement;
import java.sql.DriverManager;


public class Con1 {
    public Connection connection;
    public Statement statement;
    public Statement statment;

    public Con1() {
        try {

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginFrom", "root", "Vishesh@123");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
