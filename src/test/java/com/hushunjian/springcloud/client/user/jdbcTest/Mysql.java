package com.hushunjian.springcloud.client.user.jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Mysql {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            String userNmae = "root";
            String password = "950420HSJ";
            String jdbcUrl = "jdbc:mysql://localhost:3306/macgradle";
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(jdbcUrl, userNmae, password);
            if (connection != null){
                String sql = "select * from hello";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                int col = resultSet.getMetaData().getColumnCount();
                System.out.println(col);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null){
                System.out.println("连接成功!");
            }
        }
    }
}
