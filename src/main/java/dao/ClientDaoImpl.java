package dao;

import entities.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDaoImpl implements ClientDao {

    private final Connection connection;
    private PreparedStatement preparedStatement;
    private String sql;


    public ClientDaoImpl(Connection connection)
    {
        this.connection = connection;
    }

    // METHOD TO LIST ALL CLIENTS
    public List<Client> findAll() throws SQLException
    {
        sql = "select * from tb_client";
        // SAFE WAY TO MAKE AND EXECUTE THE STATEMENT
        preparedStatement = connection.prepareStatement(sql);
        // RETRIEVE STATEMENT
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Client> clients = new ArrayList<>();
        // LOOP THROUGH THE RESULTS AND INSTANTIATE A NEW CLIENT
        while (resultSet.next())
        {
            Client client = new Client();
            client.setId(resultSet.getInt("id"));
            client.setName(resultSet.getString("name"));
            clients.add(client);
        }
        // RETURN THE LIST
        return clients;
    }

    // METHOD TO INSERT A NEW CLIENT BY A GIVEN NAME
    public void save (String name) throws SQLException
    {
        // CREATE AND PREPARE STATEMENT
        sql = "insert into tb_client(name) values (?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.executeUpdate();
    }

}
