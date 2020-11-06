package com.penruins.sqlInjection;

import java.sql.*;

public class Main {
    public static boolean login(String username,String password) throws ClassNotFoundException, SQLException {
        boolean result = false;
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_book","root","mzrfviwhninayh");
        String sql = "select * from t_user where username='" + username + "' and password='" + password + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if(resultSet.next()) result = true;
        return result;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        String username = "admin";
        String password = "admin";
        boolean login = login(username,password);
        if(login) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }
    }
}
