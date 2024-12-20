package fun.spmc.tcg.backend.database;
import java.sql.*;

public class BackendDatabase {
    private Connection connection;

    public BackendDatabase() throws SQLException {
        connection = DriverManager.
                getConnection("jdbc:h2:~/test", "sa", "");
    }
}
