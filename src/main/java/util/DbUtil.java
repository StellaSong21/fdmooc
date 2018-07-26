package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
    private static boolean flag = false;

    public static synchronized Connection getConnecction() {
        final String URL = "jdbc:mysql://localhost:3306/fdmooc?useUnicode=true&characterEncoding=UTF-8&useSSL=true";
        final String USER = "root";
        final String PASSWORD = "1234";

        while (flag) ;

        flag = true;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static synchronized int closeConnection(Connection conn) {
        try {
            conn.close();
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            flag = false;
        }
    }
}
