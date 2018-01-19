package models.dao;

import models.entity.Feedback;

import java.sql.SQLException;
import java.util.List;

public interface FeedbackDAO {
    void add(Feedback feedback) throws SQLException;
    List<Feedback> getAll() throws SQLException;
    List<Feedback> getByEmployeID(int employe_id) throws SQLException;
    void update(Feedback feedback) throws SQLException;
    void remove (Feedback feedback) throws SQLException;
}
