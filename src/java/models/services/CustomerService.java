package models.services;

import models.dao.CustomerDAO;
import models.entity.Customer;
import utils.UtilDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService extends UtilDB implements CustomerDAO  {

    Connection connection = getConnection();

    public void add(Customer customer) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO customers (name, surname, phone, email, login, password) VALUES(?,?,?,?,?,?) ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getSurname());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getLogin());
            preparedStatement.setString(6, customer.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public List<Customer> getAll() throws SQLException {
        List<Customer> customersList = new ArrayList<Customer>();
        Statement statement = null;
        String query = "SELECT * FROM customers";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Customer customer = new Customer();
                customer.setId(resultSet.getInt(1));
                customer.setName(resultSet.getString(2));
                customer.setSurname(resultSet.getString(3));
                customer.setPhone(resultSet.getString(4));
                customer.setEmail(resultSet.getString(5));
                customer.setLogin(resultSet.getString(6));
                customer.setPassword(resultSet.getString(7));

                customersList.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return customersList;
    }

    public Customer getByID(int id) throws SQLException {

        PreparedStatement preparedStatement = null;
        String query = "SELECT * FROM customers WHERE id=?";

        Customer customer = new Customer();

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                customer.setId(resultSet.getInt("id"));
                customer.setName(resultSet.getString("name"));
                customer.setSurname(resultSet.getString("surname"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setEmail(resultSet.getString("email"));
                customer.setLogin(resultSet.getString("login"));
                customer.setPassword(resultSet.getString("password"));
            }
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }


        return customer;
    }
    public void update(Customer customer) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE customers SET name=?, surname=?, phone=?, email=?, login=?, password=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getSurname());
            preparedStatement.setString(3, customer.getPhone());
            preparedStatement.setString(4, customer.getEmail());
            preparedStatement.setString(5, customer.getLogin());
            preparedStatement.setString(6, customer.getPassword());
            preparedStatement.setInt(7,customer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    public void remove(Customer customer) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM customers WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,customer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No connection to BD!" + e);
        }finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }


    }
}
