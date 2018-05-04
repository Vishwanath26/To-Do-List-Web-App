package com.legally.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {

    public String firstName = null ;

    public RegisterDAO(User user) {
        SQLConnection connection = new SQLConnection();
        String Query = "INSERT INTO User(firstName,lastName,email,password) values (?,?,?,?);";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(connection.Url,connection.User,connection.Password);
            PreparedStatement psmt = con.prepareStatement(Query);
            psmt.setString(1,user.getFirstName());
            psmt.setString(2,user.getLastName());
            psmt.setString(3,user.getEmail());
            psmt.setString(4,user.getPassword());
            psmt.executeUpdate();
            firstName = user.getFirstName();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
