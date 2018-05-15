package user;

import java.sql.*;
import java.util.List;

public class DAO {

    public String result = null;
    public String userId = null;
    public String  task = null;
    SQLConnection con = new SQLConnection();

public DAO(){

}

    public void  GetUser(String email,String pswd)throws SQLException{
        SQLConnection con = new SQLConnection();
        String Query = "SELECT firstName,userId FROM Users WHERE email =? AND password =?;";
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
                        userId = ""+ rs.getInt("userId");
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

    public  void excecuteSql(String tabName , String columList , String value , char queryType) throws SQLException, ClassNotFoundException {
        SQLConnection con = new SQLConnection();
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection(con.Url,con.User,con.Password);
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Statement stmt = connection.createStatement();
            String query = "";
            switch (queryType) {
                case 'I':
                    query = "INSERT INTO " + tabName + " (" + columList  + ") " + " VALUES (" + value + ")";
                    stmt.executeUpdate(query);
                    break;
                case 'S':
                    query = "SELECT  " + columList + " FROM " + tabName ;
                    ResultSet resultSet = stmt.executeQuery(query);
                    resultSet.next();

                    break;
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
        }
    }

    public ResultSet executeSelectFilterSql(String tabName , String columList , List<String> checkColum , List<String> checkValue) throws ClassNotFoundException, SQLException {
        SQLConnection con = new SQLConnection();
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection(con.Url, con.User, con.Password);
        Class.forName("com.mysql.jdbc.Driver");
        Statement stmt = connection.createStatement();
        String query = "SELECT  " + columList + " FROM " + tabName + " WHERE " + checkColum.get(0) + "= " +checkValue.get(0)+ " AND " + checkColum.get(1) + "= " +"'" +checkValue.get(1) + "'"  ;
        ResultSet resultSet = stmt.executeQuery(query);
        resultSet.next();
        return resultSet;

    }

}
