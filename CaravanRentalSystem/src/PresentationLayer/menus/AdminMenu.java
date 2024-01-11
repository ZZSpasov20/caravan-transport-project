package PresentationLayer.menus;

public class AdminMenu implements Menu{
    @Override
    public void startMenu(){
        adminMenuStarter();
    }

    public static void adminMenuStarter(){
        System.out.println("Welcome to Caravan Rental System:");
        System.out.println("Admin Menu");
        System.out.println("Please select option:");
        System.out.println("1.Caravans");
        System.out.println("2.Clients");
        System.out.println("3.Reviews");
        System.out.println("4.Rentals");
        System.out.println("5.Exit application");
    }

    public static void adminMenuCaravan(){
        System.out.println("1.See all caravans");
        System.out.println("2.See a specific caravan");
        System.out.println("3.Add a caravan");
        System.out.println("4.Update a caravan");
        System.out.println("5.Delete a caravan");
        System.out.println("6.Go back");
    }

    public static void adminMenuClients(){
        System.out.println("1.See all clients");
        System.out.println("2.See a specific clients");
        System.out.println("3.Add a clients");
        System.out.println("4.Update a clients");
        System.out.println("5.Delete a clients");
        System.out.println("6.Go back");
    }

    public static void adminMenuReviews(){
        System.out.println("1.See all reviews");
        System.out.println("2.See a specific reviews");
        System.out.println("3.Add a reviews");
        System.out.println("4.Update a reviews");
        System.out.println("5.Delete a reviews");
        System.out.println("6.Go back");
    }

    public static void adminMenuRentals(){
        System.out.println("1.See all rentals");
        System.out.println("2.See a specific rentals");
        System.out.println("3.Add a rentals");
        System.out.println("4.Update a rentals");
        System.out.println("5.Delete a rentals");
        System.out.println("6.Go back");
    }
}
