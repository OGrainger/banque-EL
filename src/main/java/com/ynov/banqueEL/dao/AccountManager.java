package com.ynov.banqueEL.dao;

import com.ynov.banqueEL.model.Account;

import java.sql.*;
import java.util.List;

public class AccountManager {

    public static final String DB_URL = "jdbc:mysql://localhost:3306/database";
    public static final String DB_LOGIN = "root";
    public static final String DB_PASSWORD = "password";

    public static List<Account> getAccountsByClientID(int clientID) {

        List<Account> results = null;

        try {
            Connection con = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);

            PreparedStatement s = con.prepareStatement("SELECT number, description, money FROM accounts WHERE clientID = ?");
            s.setInt(1, clientID);
            ResultSet rs = s.executeQuery();

            while (rs.next()) {
                Account a = new Account();
                a.setNumber(rs.getInt("number"));
                a.setDescription(rs.getString("description"));
                a.setMoney(rs.getDouble("money"));

                System.out.println("Found account : ID " + a.getNumber());

                results.add(a);
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }

}
