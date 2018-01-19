package models.dao;

import models.entity.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServiceDAO {
    void add(Service service) throws SQLException;
    List<Service> getAll() throws SQLException;
    Service getByID(int id) throws SQLException;
    void update(Service service) throws SQLException;
    void remove (Service service) throws SQLException;
}
