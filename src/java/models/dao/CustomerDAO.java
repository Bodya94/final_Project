package models.dao;

import models.entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDAO {
    void add(Customer customer) throws SQLException;
    List<Customer> getAll();
    Customer getByID();
    void update(Customer employe);
    void remove (Customer employe);
}
