package com.ynov.banqueEL.dao;

import com.ynov.banqueEL.DatabaseConnection;
import com.ynov.banqueEL.model.Client;

import java.sql.*;

public class ClientManager {

    public static final String DB_URL = "jdbc:mysql://localhost:3306/database";
    public static final String DB_LOGIN = "root";
    public static final String DB_PASSWORD = "password";

    public static Client getClientByID(int clientID) {
        Client result = new Client();

        try {
            //Connection con = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);
            DatabaseConnection c = new DatabaseConnection();
            Connection con = c.openConnection();

            PreparedStatement s = con.prepareStatement("SELECT clientID, firstname, lastname, login FROM clients WHERE clientID = ?");
            s.setInt(1, clientID);
            ResultSet rs = s.executeQuery();

            while (rs.next()) {
                result.setClientID(rs.getInt("clientID"));
                result.setFirstName(rs.getString("firstname"));
                result.setLastName(rs.getString("lastname"));
                result.setLogin(rs.getString("login"));

                System.out.println("Found client : " + result.toString());
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
