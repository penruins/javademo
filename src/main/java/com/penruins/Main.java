package com.penruins;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static String dbUrl = "jdbc:mysql://localhost:3306/db_book";
    private static String dbUserName = "root";
    private static String dbPassword = "mzrfviwhninayh";
    private static String jdbcName = "com.mysql.cj.jdbc.Driver";


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(jdbcName);
        Connection con = DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
        List list = new ArrayList();
        String sql = "select * from t_user";
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        while(rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setIsAdmin(rs.getString(2));
            user.setUsername(rs.getString(3));
            user.setPassword(rs.getString(4));
            user.setPhone(rs.getString(5));
            user.setAddress(rs.getString(6));

            list.add(user);

        }

        list.forEach(e -> System.out.println(e));
    }
}


//    public List getRecoredDataSql(String sql) throws Exception {
//        Connection conn = null;
//        Statement stmt = null;
//        ResultSet rs = null;
//        List list = new ArrayList();
//        conn = dbUtil.getCon();
//        stmt = conn.createStatement();
//        rs = stmt.executeQuery(sql);
//        while(rs.next()) {
//            User user = new User();
//            user.setId(rs.getInt(1));
//            user.setIsAdmin(rs.getString(2));
//            user.setUsername(rs.getString(3));
//            user.setPassword(rs.getString(4));
//            user.setPhone(rs.getString(5));
//            user.setAddress(rs.getString(6));
//            list.add(user);
//        }
//        return list;
//    }
