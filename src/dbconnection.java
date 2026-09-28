import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class dbconnection {

    static Connection con;

    public static Connection getConnection() {
        try {
            if (con == null) {
                Properties props = new Properties();
                try (FileInputStream in = new FileInputStream("config.properties")) {
                    props.load(in);
                }

                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection(
                    props.getProperty("db.url"),
                    props.getProperty("db.user"),
                    props.getProperty("db.password")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}