package models.dao;

import models.entity.Register;

import java.sql.SQLException;
import java.util.List;

public interface RegisterDAO {
    void add(Register register) throws SQLException;
    List<Register> getAll() throws SQLException;
    List<Register> getByEmployeID(int employe_id) throws SQLException;
    void update(Register register) throws SQLException;
    void remove (Register register) throws SQLException;
}
