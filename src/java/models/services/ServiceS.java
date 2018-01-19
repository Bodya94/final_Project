package models.services;

import models.dao.ServiceDAO;
import models.entity.Service;
import utils.UtilDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceS extends UtilDB implements ServiceDAO  {

    Connection connection = getConnection();

    @Override
    public void add(Service service) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO services (id, kind, cost) VALUES(?,?,?) ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, service.getId());
            preparedStatement.setString(2, service.getKind());
            preparedStatement.setInt(3, service.getCost());
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

    @Override
    public List<Service> getAll() throws SQLException {

        List<Service> servicesList = new ArrayList<Service>();
        Statement statement = null;
        String query = "SELECT * FROM services";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Service service = new Service();
                service.setId(resultSet.getInt(1));
                service.setKind(resultSet.getString(2));
                service.setCost(resultSet.getInt(3));
                servicesList.add(service);
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
        return servicesList;
    }

    @Override
    public Service getByID(int id) throws SQLException {


        PreparedStatement preparedStatement = null;
        String query = "SELECT * FROM services WHERE id=?";

        Service service = new Service();

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                service.setId(resultSet.getInt("id"));
                service.setKind(resultSet.getString("kind"));
                service.setCost(resultSet.getInt("cost"));
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


        return service;
    }

    @Override
    public void update(Service service) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE services SET kind=?, cost=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, service.getKind());
            preparedStatement.setInt(2, service.getCost());
            preparedStatement.setInt(3,service.getId());
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

    @Override
    public void remove(Service service) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM services WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,service.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("No connection to DB!" + e);
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
