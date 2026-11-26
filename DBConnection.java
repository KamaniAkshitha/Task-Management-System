import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/task_manager";

    private static final String USER = "root";

    private static final String PASSWORD = "project@1";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );
        }
        catch(Exception e) {
            System.out.println(
                    "Connection Failed: "
                    + e.getMessage()
            );
            return null;
        }
    }
}