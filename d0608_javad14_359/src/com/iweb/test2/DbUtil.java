package com.iweb.test2;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Guan
 * @date 2023/6/8 10:26
 */
public class DbUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/gls?characterEncoding=utf8";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "a12345";

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {

        return DriverManager.getConnection(URL, USER_NAME, PASSWORD);

    }
}
