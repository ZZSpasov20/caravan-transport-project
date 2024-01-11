package DataAccessLayer.repositories;

import DataAccessLayer.models.Rental;
import utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RentalRepository {
    private static RentalRepository instance = null;

    public static RentalRepository getInstance() {

        if (RentalRepository.instance == null) {
            RentalRepository.instance = new RentalRepository();
        }

        return RentalRepository.instance;
    }

    public Rental mapToRental(ResultSet set){

        Rental rental = new Rental();

        try{

            rental.setRentalId(set.getInt(1));
            rental.setStartDate(set.getString(2));
            rental.setEndDate(set.getString(3));
            rental.setClientId(set.getInt(4));
            rental.setCaravanId(set.getInt(5));
            rental.setReviewId(set.getInt(6));

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return rental;
    }

    public List<Rental> getAllRentals(){
        List<Rental> rentals = new ArrayList<>();
        Rental rental;

        String query = "SELECT * FROM [Rentals]";

        Connection connectionInstance;
        Statement statement;
        ResultSet set;

        try{
            connectionInstance = DbConnection.getInstance();
            statement = connectionInstance.createStatement();
            set = statement.executeQuery(query);

            while (set.next()){
                rentals.add(mapToRental(set));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return rentals;
    }

    public Rental getRentalById(int id) {

        String query = "SELECT * FROM Rentals WHERE RentalId = ?";

        Connection connectionInstance;
        Rental rental = new Rental();

        try {

            connectionInstance = DbConnection.getInstance();

            PreparedStatement preparedStatement = connectionInstance.prepareStatement(query);

            preparedStatement.setInt(1, id);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                rental = mapToRental(resultSet);
            }


        }catch(SQLException e){
            throw new RuntimeException(e);
        }

        return rental;

    }

    public void addRental(Rental rental){
        String query = "INSERT INTO Rentals (StartDate , EndDate, ClientId, CaravanId, ReviewId) VALUES (?, ?, ?, ?, ?)";

        Connection connectionInstance;

        try{
            connectionInstance = DbConnection.getInstance();

            PreparedStatement preparedStatement = connectionInstance.prepareStatement(query);

            preparedStatement.setString(1, rental.getStartDate());
            preparedStatement.setString(2, rental.getEndDate());
            preparedStatement.setInt(3, rental.getClientId());
            preparedStatement.setInt(4, rental.getCaravanId());
            preparedStatement.setInt(5, rental.getReviewId());

            preparedStatement.executeUpdate();


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void updateRental(Rental rental) {
        String query = "UPDATE Rentals SET StartDate = ?, EndDate = ?, ClientId = ?, CaravanId = ?, ReviewId = ? WHERE RentalId = ?";

        Connection connectionInstance;

        try {
            connectionInstance = DbConnection.getInstance();

            PreparedStatement preparedStatement = connectionInstance.prepareStatement(query);

            preparedStatement.setString(1, rental.getStartDate());
            preparedStatement.setString(2, rental.getEndDate());
            preparedStatement.setInt(3, rental.getClientId());
            preparedStatement.setInt(4, rental.getCaravanId());
            preparedStatement.setInt(5, rental.getReviewId());
            preparedStatement.setInt(6, rental.getRentalId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteRentalById(int id) {
        String query1 = "DELETE FROM Rentals WHERE RentalId = ?";

        Connection connectionInstance;
        try {
            connectionInstance = DbConnection.getInstance();

            PreparedStatement preparedStatement = connectionInstance.prepareStatement(query1);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
