package com.legally.user;

import org.springframework.dao.support.DaoSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class DAO {

    public String result = null;


    public DAO(String email,String pswd)throws SQLException{
        SQLConnection con = new SQLConnection();
        String Query = "SELECT firstName FROM User WHERE email =? AND password =?;";
        try {
            if(Query!=null&&Query!="")
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection=DriverManager.getConnection(con.Url, con.User, con.Password);
                PreparedStatement psmt = connection.prepareStatement(Query);
                psmt.setString(1,email);
                psmt.setString(2,pswd);
                try (ResultSet rs = psmt.executeQuery()) {
                    if(rs.isBeforeFirst())
                    {
                        rs.next();
                        result =  rs.getString("firstName");
                    }
                    else {
                        result = null;
                    }

                }
            }
        }
        catch(Exception exp) {
            try {
                throw exp;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }


}
