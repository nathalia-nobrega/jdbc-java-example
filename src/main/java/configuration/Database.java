package configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    private static Connection connection;
    private static final String url = "jdbc:mysql://localhost:3306/db_cadastro_cliente";
    private static final String user = "root";
    private static final String password = "";

    public static Connection getConnection() throws SQLException  {
        if (connection != null) { return connection; }

        return DriverManager.getConnection(url, user, password);

    }
}
