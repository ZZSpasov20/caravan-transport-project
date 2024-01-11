package PresentationLayer.main;

import PresentationLayer.controllers.AdminController;
import utils.DbConnection;
import utils.TimerThread;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TimerThread timer = TimerThread.getInstance();
        timer.start();

        AdminController adminController = new AdminController();

        adminController.displayAdminMenuStarter();
    }
}
