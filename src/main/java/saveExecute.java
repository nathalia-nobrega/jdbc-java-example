import configuration.Database;
import dao.ClientDao;
import dao.ClientDaoImpl;

import java.sql.Connection;
import java.sql.SQLException;

public class saveExecute {

    public static void main(String[] args) throws SQLException {

        try(Connection connection = Database.getConnection()) {
            ClientDao clientDao = new ClientDaoImpl(connection);
            clientDao.save("Frank Serpico");
        }

    }
}
