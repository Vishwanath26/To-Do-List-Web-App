package com.legally.user;
import java.sql.*;

public class SQLConnection {
        public String Url;
        public String User;
        public String Password;

        public SQLConnection(){
            this.Url =  "jdbc:mysql://localhost:3306/Users";
            this.User = "root";
            this.Password = "root";
        }
};
