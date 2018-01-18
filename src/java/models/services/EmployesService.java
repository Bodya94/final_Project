package models.services;

import models.dao.EmployesDAO;
import models.entity.Employes;
import utils.UtilDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployesService extends UtilDB implements EmployesDAO {

    Connection connection = getConnection();

    public void add(Employes employe) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO employes (name, surname, post, phone, email, login, password) VALUES(?,?,?,?,?,?,?) ";
        try {
            preparedStatement = connection.prepareStatement(sql);


            preparedStatement.setString(1, employe.getName());
            preparedStatement.setString(2, employe.getSurname());
            preparedStatement.setString(3, employe.getPost());
            preparedStatement.setString(4, employe.getPhone());
            preparedStatement.setString(5, employe.getEmail());
            preparedStatement.setString(6, employe.getLogin());
            preparedStatement.setString(7, employe.getPassword());
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


    public List<Employes> getAll() throws SQLException {
        List<Employes> employesList = new ArrayList<Employes>();
        Statement statement = null;
        String query = "SELECT * FROM employes";
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Employes employe = new Employes();
                employe.setId(resultSet.getInt(1));
                employe.setName(resultSet.getString(2));
                employe.setSurname(resultSet.getString(3));
                employe.setPost(resultSet.getString(4));
                employe.setPhone(resultSet.getString(5));
                employe.setEmail(resultSet.getString(6));
                employe.setLogin(resultSet.getString(7));
                employe.setPassword(resultSet.getString(8));

                employesList.add(employe);
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
        return employesList;
    }

    public Employes getByID(int id) throws SQLException {
        PreparedStatement preparedStatement = null;
         String query = "SELECT * FROM employes WHERE id=?";

         Employes employe = new Employes();

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                employe.setId(resultSet.getInt("id"));
                employe.setName(resultSet.getString("name"));
                employe.setSurname(resultSet.getString("surname"));
                employe.setPost(resultSet.getString("post"));
                employe.setPhone(resultSet.getString("phone"));
                employe.setEmail(resultSet.getString("email"));
                employe.setLogin(resultSet.getString("login"));
                employe.setPassword(resultSet.getString("password"));
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


        return employe;
    }

    public void update(Employes employe) throws SQLException {
        PreparedStatement preparedStatement = null;

        String sql = "UPDATE employes SET name=?, surname=?, post=?, phone=?, email=?, login=?, password=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, employe.getName());
            preparedStatement.setString(2, employe.getSurname());
            preparedStatement.setString(3, employe.getPost());
            preparedStatement.setString(4, employe.getPhone());
            preparedStatement.setString(5, employe.getEmail());
            preparedStatement.setString(6, employe.getLogin());
            preparedStatement.setString(7, employe.getPassword());
            preparedStatement.setInt(8,employe.getId());
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

    public void remove(Employes employe) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM employes WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,employe.getId());
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
}
