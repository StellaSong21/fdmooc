package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
    private static boolean flag = false;
    private static Connection conn = initConnection();

    private static synchronized Connection initConnection() {
        final String URL = "jdbc:mysql://localhost:3306/fdmooc?useUnicode=true&characterEncoding=UTF-8&useSSL=true";
        final String USER = "root";
        final String PASSWORD = "1234";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Connection getConnection() {

        //System.out.println("I require " + Thread.currentThread().toString());

        while (flag) {
            try {
                Thread.sleep(50);
                //System.out.println("I am trapped " + Thread.currentThread().toString());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //System.out.println("I am in " + Thread.currentThread().toString());
        flag = true;
        return conn;

    }

    public static synchronized void closeConnection() {
        flag = false;
    }
}
