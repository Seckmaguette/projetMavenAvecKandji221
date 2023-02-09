package service;

import models.Medecin;
import utils.DataBaseHelper;

import java.sql.SQLException;
import java.util.List;

public class MedcinDao implements Imedcin {
    Medecin medcin;
    private DataBaseHelper db;
    public MedcinDao(){
        db = new DataBaseHelper();
    }
    @Override
    public Medecin add(Medecin medecin) throws SQLException {
        return null;
    }

    @Override
    public Medecin update(Medecin medecin, int type) throws SQLException {
        try {
            String sql = type == 0 ?"UPDATE medcin SET nomCOmplet =? WHERE id=?":"INSERT INTO medcin VALUES(null,?,?,?,?,?,?,?)";
            db.myPreparStatement(sql);
            Object[] parameters = null;
            if (type == 0) {
                parameters = new Object[8];
                parameters[0] = medecin.getNomCOmplet().toLowerCase();
                parameters[1] = medecin.getId();

            } else {
                parameters = new Object[7];
                parameters[0] = medecin.getNomCOmplet().toLowerCase();
                parameters[1] = medecin.getDateNaissance();
                parameters[2] = medecin.getDateEmbauche();
                parameters[3] = medecin.getSalaire();
                parameters[4] = medecin.getAdresse().toLowerCase();

                parameters[5] = medecin.getSpecialite().getId();

                parameters[6] = medecin.getService().getId();
                medecin.setId(db.getGenerateId());
            }

            db.addParameters(parameters);
            db.myExecuteUpdate();
            return medecin;

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Medecin findByName(String name) throws SQLException {
        return null;
    }

    @Override
    public List<Medecin> findAll() throws SQLException {
        return null;
    }

    @Override
    public void delete(String name) throws SQLException {

    }
}
