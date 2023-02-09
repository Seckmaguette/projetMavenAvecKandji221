package views;

import models.Specialite;
import service.SpecialiteDao;

import java.sql.SQLException;
import java.util.Scanner;

public class SpecialiteView {

    public void specialiteMenu() throws SQLException {
        Scanner sc1 = new Scanner(System.in);
        int choix1;
        do{
            System.out.println("======= Menu Specialite =======");
            System.out.println("1-Ajouter");
            System.out.println("2-Modifier");
            System.out.println("3-Rechercher");
            System.out.println("4-Supprimer");
            System.out.println("5-Lister");
            System.out.println("6-Quitter");
            choix1 = sc1.nextInt();
            switch (choix1){
                case 1:
                    System.out.println("======= Ajout de Specialite ======");
                    Specialite specialite = new Specialite();
                    specialite.saisi();
                    SpecialiteDao specialiteDao = new SpecialiteDao();
                   if (specialiteDao.findByName(specialite.getLibelle()) == null){
                        specialiteDao.update(specialite,1);
                    }else{
                        System.out.println(" le specialite existe déjà");

                    }
                    specialiteDao.findAll().forEach(spc-> System.out.println(spc.getLibelle()));

                    break;
                case 2:
                    System.out.println("======= Modification d'un specialite =======");
                    SpecialiteDao specialiteDao1= new SpecialiteDao();
                    Specialite specialite1 = specialiteDao1.findByName(sc1.next());
                    if (specialite1 != null) {
                        System.out.println(" modifier le service");
                        specialite1.setLibelle(sc1.next());
                        specialiteDao1.update(specialite1,0);

                    }else{
                        System.out.println(" Ce specialité n'existe pas");

                    }
                    specialiteDao1.findAll().forEach(se-> System.out.println(se.getId()+ " " +se.getLibelle()));
                    break;
                case 3:
                    System.out.println("======= Recherche de Specialite ====");
                    SpecialiteDao specialiteDao2= new SpecialiteDao();
                    Specialite specialite2 = specialiteDao2.findByName(sc1.next());
                    if (specialite2 != null) {
                        System.out.println("id :" + specialite2.getId()+ " " + "libelle :" + "" +specialite2.getLibelle());


                    }else{
                        System.out.println(" le specialité n'existe pas");

                    }
                    // serviceDaos.findAll().forEach(se-> System.out.println(se.getId()+ " " +se.getLibelle()));
                    break;
                case 4:
                    System.out.println("======= Suppression d'un specialité =======");
                    SpecialiteDao spD = new SpecialiteDao();
                    Specialite spc = spD.findByName(sc1.next());
                    if (spc != null) {
                        //System.out.println(" supprimer le service");
                        System.out.println(spc.getLibelle());
                        spD.delete(spc.getLibelle());
                        spD.findAll().forEach(se-> System.out.println(se.getId()+ " " +se.getLibelle()));
                    }else{
                        System.out.println(" le service n'existe pas");

                    }
                    break;
                case 5:
                    System.out.println("======= Liste des spécialités =======");
                    SpecialiteDao spDao = new SpecialiteDao();
                    spDao.findAll().forEach(sp->System.out.println(sp.getId()+""+sp.getLibelle()));
                    break;
                default:
                    break;

            }


        }while(choix1 != 6);
    }
}
