package main;

import models.Service;
import service.ServiceDao;
import views.MenuView;
import views.ServiceView;
import views.SpecialiteView;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int choix;
        MenuView menuView = new MenuView();

        do{
            menuView.menu();
            choix = sc.nextInt();
            switch (choix){
                case 1:
                    break;
                case 2:
                    ServiceView serviceView = new ServiceView();
                    serviceView.MenuService();
                    break;
                case 3:
                    SpecialiteView specialiteView = new SpecialiteView();
                    specialiteView.specialiteMenu();
                    break;
                default:
                    break;
            }

        }while( choix != 4);

    }
}



