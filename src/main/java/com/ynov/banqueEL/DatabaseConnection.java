package com.ynov.banqueEL;

import java.sql.*;

public class DatabaseConnection {

    public static final String DB_URL = "jdbc:mysql://localhost:3306/database";
    public static final String DB_LOGIN = "root";
    public static final String DB_PASSWORD = "password";

    public Connection openConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
    public void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
