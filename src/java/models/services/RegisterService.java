package models.services;

import models.dao.RegisterDAO;
import models.entity.Register;
import utils.UtilDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegisterService extends UtilDB implements RegisterDAO {

    Connection connection = getConnection();

    @Override
    public void add(Register register) throws SQLException {

        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO registers (date, customer_id, employe_id, service_id) VALUES(?,?,?,?) ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,  register.getDate());
            preparedStatement.setInt(2, register.getCustomerId());
            preparedStatement.setInt(3, register.getEmployeId());
            preparedStatement.setInt(4, register.getServiceId());
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
    public List<Register> getAll() throws SQLException {


        List<Register> registersList = new ArrayList<Register>();
        Statement statement = null;
        String query = "SELECT * FROM registers";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Register register = new Register();
                register.setDate(resultSet.getString(1));
                register.setCustomerId(resultSet.getInt(2));
                register.setEmployeId(resultSet.getInt(3));
                register.setServiceId(resultSet.getInt(4));
                registersList.add(register);
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
        return registersList;
    }

    @Override
    public List<Register> getByEmployeID(int employe_id) throws SQLException {
        List<Register> registersList = new ArrayList<Register>();
        PreparedStatement preparedStatement = null;
        String query = "SELECT * FROM registers WHERE employe_id=?";



        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,employe_id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Register register = new Register();
                register.setDate(resultSet.getString("date"));
                register.setEmployeId(resultSet.getInt("employe_id"));
                register.setCustomerId(resultSet.getInt("customer_id"));
                register.setServiceId(resultSet.getInt("service_id"));
                registersList.add(register);
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


        return registersList;
    }


    @Override
    public void update(Register register) throws SQLException {

        PreparedStatement preparedStatement = null;

        String sql = "UPDATE registers SET date=?, customer_id=?, service_id=? WHERE employe_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, register.getDate());
            preparedStatement.setInt(2, register.getCustomerId());
            preparedStatement.setInt(3,register.getServiceId());
            preparedStatement.setInt(4,register.getEmployeId());
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
    public void remove(Register register) throws SQLException {

        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM registers WHERE employe_id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,register.getEmployeId());
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
