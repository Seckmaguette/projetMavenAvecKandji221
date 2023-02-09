package utils;

import java.sql.*;

public class DataBaseHelper {


    private Connection cnx;
    private PreparedStatement pstnt;

    private  void openConnection() throws SQLException {

        try{
            String url="jdbc:mysql://localhost:3307/moi";
            String username="root",password="root";
            if(cnx == null || cnx.isClosed()){
                cnx= DriverManager.getConnection(url,username,password);
            }
        }catch(Exception e){
            throw e;
        }
    }

    //function pour la requête sql
    public void myPreparStatement(String sql) throws SQLException {
        try{
            openConnection();
            if(sql.trim().toLowerCase().startsWith("insert")) {
                pstnt = cnx.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            }else {
                pstnt = cnx.prepareStatement(sql);
            }
        }catch (Exception e){
            throw e;
        }
    }

    //function pour gérer les paramètres de la requête sql
    public void addParameters(Object[] parameters) throws SQLException {
        try {
            for (int i = 0; i < parameters.length; i++) {
                pstnt.setObject((i+1),parameters[i]);
            }
        }catch (Exception e){
            throw e;
        }

    }

    public ResultSet  myExecuteQuery() throws SQLException {
        try{
            return pstnt.executeQuery();
        }catch (Exception e){
        throw e;
        }
    }




    public void closeConnection() throws SQLException {
        try{
            if(pstnt != null && !pstnt.isClosed()){
                pstnt.close();
                pstnt=null;
            }
            if(cnx != null && !cnx.isClosed()){
                cnx.close();
                cnx=null;
            }
         }catch (Exception e){
            throw e;
        }
    }
    public  int myExecuteUpdate() throws SQLException {
        try{
            return pstnt.executeUpdate();
        }catch (Exception e){
            throw e;
        }
    }
    public  int getGenerateId() throws SQLException {
        try{
            int id=0;
            ResultSet rs = pstnt.getGeneratedKeys();
            while (rs.next()){
                id=rs.getInt(1);
            }
            rs.close();
            return id;
        }catch (Exception e){
            throw e;
        }
    }
}
