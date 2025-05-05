package org.alex;

import java.io.Closeable;
import java.sql.*;

public class Jdbc implements Closeable  {
    private Connection connection;

    public void connectionSet(String url, String user, String pass){
        try {
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection successful");
        } catch (SQLException e) {
            System.out.println("Error connection");
        }
    }

    public String write(String str, String session) throws SQLException {
        if(connection!=null){
            Statement statement = connection.createStatement();
            String sqlRequest = "INSERT INTO test (string, session) VALUES ('"+str+"','"+session+"')";
            statement.executeUpdate(sqlRequest);
            statement.close();
            return "Successful";
        }else{
            throw new SQLException("No connection");
        }
    }

    public String readAll() throws SQLException {
        if(connection!=null){
            Statement statement = connection.createStatement();
            String sqlRequest = "SELECT * FROM test";
            ResultSet resultSet = statement.executeQuery(sqlRequest);
            String result = "";
            while(resultSet.next()){
                result += "\n"+resultSet.getString("session")+"    "+resultSet.getString("string");
            }
            statement.close();
            return result;
        }else{
            throw new SQLException("No connection");
        }
    }

    @Override
    public void close(){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
