package PresentationLayer.controllers;

import BusinessLayer.services.CaravanService;
import BusinessLayer.services.ClientService;
import BusinessLayer.services.RentalService;
import BusinessLayer.services.ReviewService;
import DataAccessLayer.models.Client;
import DataAccessLayer.repositories.CaravanRepository;
import PresentationLayer.menus.AdminMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AdminController {

    private static final Scanner scanner = new Scanner(System.in);

    private final CaravanService caravanService;
    private final ClientService clientService;
    private final ReviewService reviewService;
    private final RentalService rentalService;

    public AdminController() {
        this.caravanService = CaravanService.getInstance();
        this.clientService = ClientService.getInstance();
        this.reviewService = ReviewService.getInstance();
        this.rentalService = RentalService.getInstance();
    }

    public void displayAdminMenuStarter(){
        AdminMenu.adminMenuStarter();

        int choice = 0;

        choice = scanner.nextInt();

        switch (choice){
            case 1:{
                displayAdminMenuCaravan();
                break;
            }
            case 2:{
                displayAdminMenuClients();
                break;
            }
            case 3:{
                displayAdminMenuReviews();
                break;
            }
            case 4:{
                displayAdminMenuRentals();
                break;
            }
            case 5:{
                break;
            }
            default: {
                System.out.println("Sorry wrong input!");

                displayAdminMenuStarter();
                break;
            }
        }
    }

    public void displayAdminMenuCaravan(){
        AdminMenu.adminMenuCaravan();

        int choice = 0;
        choice = scanner.nextInt();

        switch (choice) {
            case 1: {
                List<String> allCaravans = new ArrayList<>();
                allCaravans = caravanService.getAllCaravans();

                for(String caravan : allCaravans){
                    System.out.println(caravan);
                }

                displayAdminMenuCaravan();

                break;
            }
            case 2: {
                System.out.println("Please enter the id of the caravan you want to see:");
                int id = scanner.nextInt();

                System.out.println(caravanService.getCaravanById(id));

                displayAdminMenuCaravan();

                break;
            }
            case 3: {
                System.out.println("Please enter caravan information without id:");

                float price = scanner.nextFloat();
                int isAvaliable = scanner.nextInt();
                scanner.nextLine();
                String manufacturer = scanner.nextLine();
                String modelName = scanner.nextLine();

                caravanService.addCaravan(price, isAvaliable, manufacturer, modelName);

                System.out.println("Caravan added successfully");

                displayAdminMenuCaravan();

                break;
            }
            case 4: {
                System.out.println("Please enter new caravan information and id:");

                int id = scanner.nextInt();
                float price = scanner.nextFloat();
                int isAvaliable = scanner.nextInt();
                scanner.nextLine();
                String manufacturer = scanner.nextLine();
                String modelName = scanner.nextLine();

                caravanService.updateCaravan(id, price, isAvaliable, manufacturer, modelName);

                System.out.println("Caravan updated successfully");

                displayAdminMenuCaravan();

                break;
            }
            case 5: {
                System.out.println("Please enter id of the caravan you want to delete:");

                int id = scanner.nextInt();

                caravanService.deleteCaravan(id);

                System.out.println("Caravan deleted successfully");

                displayAdminMenuCaravan();

                break;
            }
            case 6:{
                displayAdminMenuStarter();
                break;
            }
            default: {
                System.out.println("Sorry wrong input!");

                displayAdminMenuCaravan();

                break;
            }
        }
    }

    public void displayAdminMenuClients(){
        AdminMenu.adminMenuClients();

        int choice = 0;
        choice = scanner.nextInt();

        switch (choice) {
            case 1: {
                List<String> allClients = new ArrayList<>();
                allClients = clientService.getAllClients();

                for(String client : allClients){
                    System.out.println(client);
                }

                displayAdminMenuClients();

                break;
            }
            case 2: {
                System.out.println("Please enter the id of the client you want to see:");
                int id = scanner.nextInt();

                System.out.println(clientService.getClientById(id));

                displayAdminMenuClients();

                break;
            }
            case 3: {
                System.out.println("Please enter client information without id:");

                scanner.nextLine();
                String firstName = scanner.nextLine();
                String lastName = scanner.nextLine();
                String emailAddress = scanner.nextLine();
                String password = scanner.nextLine();

                clientService.addClient(firstName, lastName, emailAddress, password);

                System.out.println("Client added successfully");

                displayAdminMenuClients();

                break;
            }
            case 4: {
                System.out.println("Please enter new client information and id:");

                int id = scanner.nextInt();
                scanner.nextLine();
                String firstName = scanner.nextLine();
                String lastName = scanner.nextLine();
                String emailAddress = scanner.nextLine();
                String password = scanner.nextLine();

                clientService.updateClient(id, firstName, lastName, emailAddress, password);

                System.out.println("Client updated successfully");

                displayAdminMenuClients();

                break;
            }
            case 5: {
                System.out.println("Please enter id of the client you want to delete:");

                int id = scanner.nextInt();

                clientService.deleteClient(id);

                System.out.println("Client deleted successfully");

                displayAdminMenuClients();

                break;
            }
            case 6:{
                displayAdminMenuStarter();
                break;
            }
            default: {
                System.out.println("Sorry wrong input!");

                displayAdminMenuClients();

                break;
            }
        }
    }

    public void displayAdminMenuReviews(){
        AdminMenu.adminMenuReviews();

        int choice = 0;
        choice = scanner.nextInt();

        switch (choice) {
            case 1: {
                List<String> allReviews = new ArrayList<>();
                allReviews = reviewService.getAllReviews();

                for(String client : allReviews){
                    System.out.println(client);
                }

                displayAdminMenuReviews();

                break;
            }
            case 2: {
                System.out.println("Please enter the id of the review you want to see:");
                int id = scanner.nextInt();

                System.out.println(reviewService.getReviewById(id));

                displayAdminMenuReviews();

                break;
            }
            case 3: {
                System.out.println("Please enter review information without id:");

                int rating = scanner.nextInt();
                scanner.nextLine();
                String comment = scanner.nextLine();

                reviewService.addReview(rating, comment);

                System.out.println("Review added successfully");

                displayAdminMenuReviews();

                break;
            }
            case 4: {
                System.out.println("Please enter new review information and id:");

                int id = scanner.nextInt();
                scanner.nextLine();
                int rating = scanner.nextInt();
                scanner.nextLine();
                String comment = scanner.nextLine();


                reviewService.updateReview(id, rating, comment);

                System.out.println("Review updated successfully");

                displayAdminMenuReviews();

                break;
            }
            case 5: {
                System.out.println("Please enter id of the review you want to delete:");

                int id = scanner.nextInt();

                reviewService.deleteReview(id);

                System.out.println("Review deleted successfully");

                displayAdminMenuReviews();

                break;
            }
            case 6:{
                displayAdminMenuStarter();
                break;
            }
            default: {
                System.out.println("Sorry wrong input!");

                displayAdminMenuReviews();

                break;
            }
        }
    }

    public void displayAdminMenuRentals(){
        AdminMenu.adminMenuRentals();

        int choice = 0;
        choice = scanner.nextInt();

        switch (choice) {
            case 1: {
                List<String> allRentals = new ArrayList<>();
                allRentals = rentalService.getAllRentals();

                for(String rental : allRentals){
                    System.out.println(rental);
                }

                displayAdminMenuRentals();

                break;
            }
            case 2: {
                System.out.println("Please enter the id of the rental you want to see:");
                int id = scanner.nextInt();

                System.out.println(rentalService.getRentalById(id));

                displayAdminMenuRentals();

                break;
            }
            case 3: {
                System.out.println("Please enter rental information without id:");

                String startDate = scanner.nextLine();
                String endDate = scanner.nextLine();
                scanner.nextLine();
                int clientId = scanner.nextInt();
                scanner.nextLine();
                int caravanId = scanner.nextInt();
                scanner.nextLine();
                int reviewId = scanner.nextInt();

                rentalService.addRental(startDate, endDate, clientId, caravanId, reviewId);

                System.out.println("Rental added successfully");

                displayAdminMenuRentals();

                break;
            }
            case 4: {
                System.out.println("Please enter new rental information and id:");

                int id = scanner.nextInt();
                scanner.nextLine();
                String startDate = scanner.nextLine();
                String endDate = scanner.nextLine();
                int clientId = scanner.nextInt();
                scanner.nextLine();
                int caravanId = scanner.nextInt();
                scanner.nextLine();
                int reviewId = scanner.nextInt();


                rentalService.updateRental(id, startDate, endDate, clientId, caravanId, reviewId);

                System.out.println("Rental updated successfully");

                displayAdminMenuRentals();

                break;
            }
            case 5: {
                System.out.println("Please enter id of the rental you want to delete:");

                int id = scanner.nextInt();

                rentalService.deleteRental(id);

                System.out.println("Rental deleted successfully");

                displayAdminMenuRentals();

                break;
            }
            case 6:{
                displayAdminMenuStarter();
                break;
            }
            default: {
                System.out.println("Sorry wrong input!");

                displayAdminMenuRentals();

                break;
            }
        }
    }
}
