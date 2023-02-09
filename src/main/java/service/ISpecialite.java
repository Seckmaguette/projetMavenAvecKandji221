package service;

import models.Specialite;

import java.sql.SQLException;
import java.util.List;

public interface ISpecialite {
    public Specialite add(Specialite specialite) throws SQLException;
    public Specialite update(Specialite specialite,int type) throws SQLException;
    public Specialite findByName(String name) throws SQLException;
    public List<Specialite> findAll() throws SQLException;
    public void delete(String name) throws SQLException;
}
