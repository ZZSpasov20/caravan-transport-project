package PresentationLayer.main;

import PresentationLayer.controllers.AdminController;
import utils.DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        AdminController adminController = new AdminController();

        adminController.displayAdminMenuStarter();
    }
}
