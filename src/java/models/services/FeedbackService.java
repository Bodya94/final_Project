package models.services;

import models.dao.FeedbackDAO;
import models.entity.Feedback;
import utils.UtilDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class FeedbackService extends UtilDB implements FeedbackDAO {

    Connection connection = getConnection();

    @Override
    public void add(Feedback feedback) throws SQLException {


        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO registers (id_customer, id_employe, text, created) VALUES(?,?,?,?) ";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,  feedback.getIdCustomer());
            preparedStatement.setInt(2, feedback.getIdEmploye());
            preparedStatement.setString(3, feedback.getText());
            preparedStatement.setString(4, feedback.getCreted());
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
    public List<Feedback> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<Feedback> getByEmployeID(int employe_id) throws SQLException {
        return null;
    }

    @Override
    public void update(Feedback feedback) throws SQLException {

    }

    @Override
    public void remove(Feedback feedback) throws SQLException {

    }
}
