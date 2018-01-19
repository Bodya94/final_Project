package models.dao;

import models.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    void add(Customer customer) throws SQLException;
    List<Customer> getAll() throws SQLException;
    Customer getByID(int id) throws SQLException;
    void update(Customer customer) throws SQLException;
    void remove (Customer customer) throws SQLException;
}
