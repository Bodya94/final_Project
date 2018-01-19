package models.dao;

import models.entity.RenderedService;

import java.sql.SQLException;
import java.util.List;

public interface RenderedServiceDAO {
    void add(RenderedService renderedService) throws SQLException;
    List<RenderedService> getAll() throws SQLException;
    List<RenderedService> getByEmployeID(int employe_id) throws SQLException;
    void update(RenderedService renderedService) throws SQLException;
    void remove (RenderedService renderedService) throws SQLException;
}
