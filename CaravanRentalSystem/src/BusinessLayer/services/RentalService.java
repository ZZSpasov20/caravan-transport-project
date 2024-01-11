package BusinessLayer.services;

import DataAccessLayer.models.Rental;
import DataAccessLayer.repositories.RentalRepository;

import java.util.ArrayList;
import java.util.List;

public class RentalService {
    private static RentalService instance = null;

    private final RentalRepository rentalRepository;

    private RentalService() {
        this.rentalRepository = RentalRepository.getInstance();
    }

    public static RentalService getInstance() {

        if (RentalService.instance == null) {
            RentalService.instance = new RentalService();
        }

        return RentalService.instance;
    }

    public String castRentalToString(Rental rentalModule){
        String rental = "";
        rental = rentalModule.toString();
        return rental;
    }

    public Rental mapValuesToRental(String startDate,String endDate,int clientId,int caravanId, int reviewId){
        Rental rental = new Rental();

        rental.setStartDate(startDate);
        rental.setEndDate(endDate);
        rental.setClientId(clientId);
        rental.setCaravanId(caravanId);
        rental.setReviewId(reviewId);

        return rental;
    }

    public Rental mapValuesToRental(int id, String startDate,String endDate,int clientId,int caravanId, int reviewId){
        Rental rental = new Rental();

        rental.setRentalId(id);
        rental.setStartDate(startDate);
        rental.setEndDate(endDate);
        rental.setClientId(clientId);
        rental.setCaravanId(caravanId);
        rental.setReviewId(reviewId);

        return rental;
    }

    public List<String> getAllRentals(){
        List<String> allRentals = new ArrayList<>();
        List<Rental> allRentalsModules = new ArrayList<>();
        allRentalsModules = rentalRepository.getAllRentals();

        for (Rental rental : allRentalsModules ){
            allRentals.add(castRentalToString(rental));
        }

        return allRentals;
    }

    public String getRentalById(int id){
        String rental = "";

        rental = castRentalToString(rentalRepository.getRentalById(id));

        return rental;
    }

    public void addRental(String startDate,String endDate,int clientId,int caravanId, int reviewId){
        rentalRepository.addRental(mapValuesToRental(startDate, endDate, clientId, caravanId, reviewId));
    }

    public void updateRental(int id, String startDate,String endDate,int clientId,int caravanId, int reviewId){
        rentalRepository.updateRental(mapValuesToRental(id, startDate, endDate, clientId, caravanId, reviewId));
    }

    public void deleteRental(int id) {
        rentalRepository.deleteRentalById(id);
    }
}
