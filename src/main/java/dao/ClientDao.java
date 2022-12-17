package dao;

import entities.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDao {

    // METHOD TO LIST ALL CLIENTS
    List<Client> findAll() throws SQLException;

    // METHOD TO INSERT A NEW CLIENT BY A GIVEN NAME
    void save(String name) throws SQLException;
}
