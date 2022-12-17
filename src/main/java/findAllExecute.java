import configuration.Database;
import dao.ClientDao;
import dao.ClientDaoImpl;
import entities.Client;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class findAllExecute {

    public static void main(String[] args) throws SQLException {

        try(Connection connection = Database.getConnection()) {
            ClientDao clientDao = new ClientDaoImpl(connection);
            List<Client> clients = clientDao.findAll();
            System.out.println(clients);
        }

    }
}
