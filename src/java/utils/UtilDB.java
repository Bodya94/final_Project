package utils;
import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UtilDB {

    private final static String URL = "jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=false";
    private final static String USER_NAME = "root";
    private final static String PASSWORD = "root";



    public Connection getConnection(){


        Connection connection = null;

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
