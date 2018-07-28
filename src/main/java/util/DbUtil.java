package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
    private static boolean flag = false;
    private static Connection conn;

    public DbUtil() {
        final String URL = "jdbc:mysql://localhost:3306/fdmooc?useUnicode=true&characterEncoding=UTF-8&useSSL=true";
        final String USER = "root";
        final String PASSWORD = "1234";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized Connection getConnecction() {
        while (flag) ;
        flag = true;
        return conn;
    }

    public static synchronized void closeConnection() {
        flag = false;
    }
}
