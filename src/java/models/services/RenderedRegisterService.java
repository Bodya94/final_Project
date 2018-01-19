package models.services;

import models.dao.RenderedServiceDAO;
import models.entity.RenderedService;
import utils.UtilDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RenderedRegisterService extends UtilDB implements RenderedServiceDAO {

    Connection connection = getConnection();

    @Override
    public void add(RenderedService renderedService) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO rendered_services (id, date, customer_id, employe_id, service_id) VALUES(?,?,?,?,?) ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,  renderedService.getId());
            preparedStatement.setString(2,  renderedService.getDate());
            preparedStatement.setInt(3, renderedService.getCustomerId());
            preparedStatement.setInt(4, renderedService.getEmployeId());
            preparedStatement.setInt(5, renderedService.getServiceId());
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
    public List<RenderedService> getAll() throws SQLException {



        List<RenderedService> renderedServicesList = new ArrayList<RenderedService>();
        Statement statement = null;
        String query = "SELECT * FROM rendered_services";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                RenderedService renderedService = new RenderedService();
                renderedService.setId(resultSet.getInt(1));
                renderedService.setDate(resultSet.getString(2));
                renderedService.setCustomerId(resultSet.getInt(3));
                renderedService.setEmployeId(resultSet.getInt(4));
                renderedService.setServiceId(resultSet.getInt(5));
                renderedServicesList.add(renderedService);
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
        return renderedServicesList;
    }

    @Override
    public List<RenderedService> getByEmployeID(int employe_id) throws SQLException {

        List<RenderedService> renderedServicesList = new ArrayList<RenderedService>();
        PreparedStatement preparedStatement = null;
        String query = "SELECT * FROM rendered_services WHERE employe_id=?";



        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,employe_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                RenderedService renderedService = new RenderedService();
                renderedService.setDate(resultSet.getString("date"));
                renderedService.setEmployeId(resultSet.getInt("employe_id"));
                renderedService.setCustomerId(resultSet.getInt("customer_id"));
                renderedService.setServiceId(resultSet.getInt("service_id"));
                renderedServicesList.add(renderedService);
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


        return renderedServicesList;
    }

    @Override
    public void update(RenderedService renderedService) throws SQLException {


        PreparedStatement preparedStatement = null;

        String sql = "UPDATE rendered_services SET id, date=?, customer_id=?, service_id=? WHERE employe_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, renderedService.getId());
            preparedStatement.setString(2, renderedService.getDate());
            preparedStatement.setInt(3, renderedService.getCustomerId());
            preparedStatement.setInt(4,renderedService.getServiceId());
            preparedStatement.setInt(5,renderedService.getEmployeId());
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
    public void remove(RenderedService renderedService) throws SQLException {

        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM rendered_services WHERE employe_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,renderedService.getEmployeId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error connection to DB!" + e);
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
