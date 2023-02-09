package service;

import models.Service;
import utils.DataBaseHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDao implements  IService {

    Service service;
    private DataBaseHelper db;
    List<Service> services = new ArrayList<>();
    public ServiceDao(){
        db = new DataBaseHelper();
    }

    @Override
    public Service add(Service service) throws SQLException {

        try{
            String sql="INSERT INTO service VALUES(null,?)";
            db.myPreparStatement(sql);
            Object[] parameters={service.getLibelle()};
            db.addParameters(parameters);
            db.myExecuteUpdate();
            service.setId(db.getGenerateId());
            return service;
        }catch(Exception e){
            throw e;

        }

    }

    @Override
    public Service update(Service service,int type) throws SQLException {
        try {
            String sql = type == 0 ?"UPDATE service SET libelle=? WHERE id=?":"INSERT INTO service VALUES(null,?)";
            db.myPreparStatement(sql);
            Object[] parameters = null;
            if (type == 0) {
                parameters = new Object[2];
                parameters[0] = service.getLibelle().toLowerCase();
                parameters[1] = service.getId();

            } else {
                parameters = new Object[1];
                parameters[0] = service.getLibelle().toLowerCase();
                service.setId(db.getGenerateId());
            }

            db.addParameters(parameters);
            db.myExecuteUpdate();
            return service;

        } catch (Exception e) {
            throw e;
        }
    }
  /*  @Override
    public Service rechercherService(int id){
        Service srv = new Service(id);
        for(Service service : services){
            if(service.equals(srv)){
                return service;
            }
        }
        return null;
    }*/

    @Override
    public Service findByName(String name) throws SQLException {
        try {
            String sql="SELECT * FROM service WHERE libelle=?";
            db.myPreparStatement(sql);
            db.addParameters(new Object[]{name.toLowerCase()});
            ResultSet rs= db.myExecuteQuery();
            Service service = null;
            if (rs.next()) {
                service = new Service(rs.getInt(1),rs.getString(2));
            }
            rs.close();
            return (Service) service;
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<Service> findAll() throws SQLException {
        try{
            String sql = "SELECT * FROM service";
            db.myPreparStatement(sql);
            ResultSet rs= db.myExecuteQuery();
            List<Service> service = new ArrayList<>();
            while (rs.next()){
                Service s=new Service(rs.getInt(1), rs.getString(2));

                service.add(s);
            }
            rs.close();
            return service;
        }catch(Exception e){
            throw e;
        }

    }

    @Override
    public void delete(String name) throws SQLException {
        try {
            String sql = "DELETE FROM service  WHERE libelle=?";

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
