import java.sql.*;

public class dbconnection {

    static Connection con;

    public static Connection getConnection() {
        try {
            if (con == null) {

                // IMPORTANT: Load MySQL driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student_db",
                    "root",
                    "abhinavanka21"
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }
}
