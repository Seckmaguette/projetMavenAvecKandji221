package views;

import models.Service;
import service.ServiceDao;

import java.sql.SQLException;
import java.util.Scanner;

public class ServiceView {
    Scanner sc = new Scanner(System.in);
  //  ServiceDao serviceDao = new ServiceDao();
    public void MenuService() throws SQLException {
        int choix;
        do{
            System.out.println("======= Menu Service =======");
            System.out.println("1-Ajouter");
            System.out.println("2-Modifier");
            System.out.println("3-Rechercher");
            System.out.println("4-Supprimer");
            System.out.println("5-lister");
            System.out.println("6-Quitter");
            choix = sc.nextInt();
            switch (choix){
                case 1:
                    System.out.println("======= Ajout de Service ======");
                    Service service = new Service();
                    service.saisi();
                    ServiceDao serviceDao = new ServiceDao();
                    if (serviceDao.findByName(service.getLibelle())==null) {
                        serviceDao.update(service,1);

                    }else{
                        System.out.println(" le service existe déjà");

                    }
                    serviceDao.findAll().forEach(se-> System.out.println(se.getLibelle()));

                    break;
                case 2:
                    System.out.println("======= Modification d'un service =======");
                    ServiceDao serviceDaos= new ServiceDao();
                    Service services = serviceDaos.findByName(sc.next());
                    if (services != null) {
                        System.out.println(" modifier le service");
                        services.setLibelle(sc.next());
                        serviceDaos.update(services,0);

                    }else{
                        System.out.println(" le service n'existe pas");

                    }
                    serviceDaos.findAll().forEach(se-> System.out.println(se.getId()+ " " +se.getLibelle()));
                    break;
                case 3:
                    System.out.println("======= Recherche d'un service ====");
                    ServiceDao serviceDa= new ServiceDao();
                    Service serv = serviceDa.findByName(sc.next());
                    if (serv != null) {
                        System.out.println("id :" + serv.getId()+ ":" + "libelle :" + "" +serv.getLibelle());


                    }else{
                        System.out.println(" le service n'existe pas");

                    }
                   // serviceDaos.findAll().forEach(se-> System.out.println(se.getId()+ " " +se.getLibelle()));
                    break;
                case 4:
                    System.out.println("======= Suppression d'un service =======");
                    ServiceDao serviceD = new ServiceDao();
                    Service servi = serviceD.findByName(sc.next());
                    if (servi != null) {
                        //System.out.println(" supprimer le service");
                        System.out.println(servi.getLibelle());
                        serviceD.delete(servi.getLibelle());

                    }else{
                        System.out.println(" le service n'existe pas");

                    }
                    break;
                case 5:
                    System.out.println("===== Liste Service =====");
                    ServiceDao servDao= new ServiceDao();
                    servDao.findAll().forEach(se-> System.out.println(se.getId()+ " " +se.getLibelle()));

                    break;
                default:
                    break;

            }


        }while(choix != 6);
    }
}
