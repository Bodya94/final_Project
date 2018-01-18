package models.services;

import models.dao.EmployesDAO;
import models.entity.Employes;
import utils.UtilDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmployesService extends UtilDB implements EmployesDAO {

    Connection connection = getConnection();

    public void add(Employes employe) throws SQLException {
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO employes (id, name, surname, post, phone, email, login, password) VALUES(?,?,?,?,?,?,?,?) ";
        try {
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, employe.getId());
            preparedStatement.setString(2, employe.getName());
            preparedStatement.setString(3, employe.getSurname());
            preparedStatement.setString(4, employe.getPost());
            preparedStatement.setString(5, employe.getPhone());
            preparedStatement.setString(6, employe.getEmail());
            preparedStatement.setString(7, employe.getLogin());
            preparedStatement.setString(8, employe.getPassword());
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

    public List<Employes> getAll() {
        return null;
    }

    public Employes getByID() {
        return null;
    }

    public void update(Employes employe) {

    }

    public void remove(Employes employe) {

    }
}
