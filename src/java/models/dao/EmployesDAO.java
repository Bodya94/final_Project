package models.dao;

import models.entity.Employes;

import java.sql.SQLException;
import java.util.List;

public interface EmployesDAO {
    void add(Employes employe) throws SQLException;
    List <Employes> getAll();
    Employes getByID();
    void update(Employes employe);
    void remove (Employes employe);
}
