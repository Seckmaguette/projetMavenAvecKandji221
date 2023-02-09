package service;

import models.Service;
import models.Specialite;
import utils.DataBaseHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecialiteDao implements ISpecialite {
    Specialite specialite;
    private DataBaseHelper db;
    public SpecialiteDao(){
        db = new DataBaseHelper();
    }


    @Override
    public Specialite add(Specialite specialite) throws SQLException {
        try{
            String sql="INSERT INTO specialite VALUES(null,?)";
            db.myPreparStatement(sql);
            Object[] parameters={specialite.getLibelle()};
            db.addParameters(parameters);
            db.myExecuteUpdate();
            specialite.setId(db.getGenerateId());
            return specialite;
        }catch(Exception e){
            throw e;

        }
    }

    @Override
    public Specialite update(Specialite specialite, int type) throws SQLException {
        try {
            String sql = type == 0 ?"UPDATE specialite SET libelle=? WHERE id=?":"INSERT INTO specialite VALUES(null,?)";
            db.myPreparStatement(sql);
            Object[] parameters = null;
            if (type == 0) {
                parameters = new Object[2];
                parameters[0] = specialite.getLibelle().toLowerCase();
                parameters[1] = specialite.getId();

            } else {
                parameters = new Object[1];
                parameters[0] = specialite.getLibelle().toLowerCase();
                specialite.setId(db.getGenerateId());
            }

            db.addParameters(parameters);
            db.myExecuteUpdate();
            return specialite;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Specialite findByName(String name) throws SQLException {
        try {
            String sql="SELECT * FROM specialite WHERE libelle=?";
            db.myPreparStatement(sql);
            db.addParameters(new Object[]{name.toLowerCase()});
            ResultSet rs= db.myExecuteQuery();
            Specialite specialite = null;
            if (rs.next()) {
                specialite = new Specialite(rs.getInt(1),rs.getString(2));
            }
            rs.close();
            return (Specialite) specialite;
        }
        catch (Exception e){
            throw e;
        }
    }
    @Override
    public List<Specialite> findAll() throws SQLException {
        try{
            String sql = "SELECT * FROM specialite";
            db.myPreparStatement(sql);
            ResultSet rs= db.myExecuteQuery();
            List<Specialite> specialite = new ArrayList<>();
            while (rs.next()){
                Specialite sp=new Specialite(rs.getInt(1), rs.getString(2));

                specialite.add(sp);
            }
            rs.close();
            return specialite;
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public void delete(String name) throws SQLException {
        try {
            String sql = "DELETE FROM specialite  WHERE libelle=?";

            Object[] parameters={name};
            db.myPreparStatement(sql);
            db.addParameters(parameters);
            db.myExecuteUpdate();
            //  rs.close();

        }catch (Exception e){
            throw e;
        }

    }
}
