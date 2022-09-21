package jm.task.core.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final  String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final  String USERNAME = "root";
    private static final  String PASSWORD = "Grav!t99Gert23@#";
    public static Connection getConnection() {
        Connection connection = null;
        try  {connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException ex) {
            System.out.println( " не подключились");
            throw new RuntimeException(ex);
        }
        return connection;
    }
}
