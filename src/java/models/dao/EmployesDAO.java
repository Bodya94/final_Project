package models.dao;

import models.entity.Employes;

import java.sql.SQLException;
import java.util.List;

public interface EmployesDAO {
    void add(Employes employe) throws SQLException;
    List <Employes> getAll() throws SQLException;
    Employes getByID(int id) throws SQLException;
    void update(Employes employe) throws SQLException;
    void remove (Employes employe) throws SQLException;
}
