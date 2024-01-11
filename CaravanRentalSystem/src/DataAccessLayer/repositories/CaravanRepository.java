package DataAccessLayer.repositories;

import DataAccessLayer.models.Caravan;
import utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CaravanRepository {
    private static CaravanRepository instance = null;

    public static CaravanRepository getInstance() {

        if (CaravanRepository.instance == null) {
            CaravanRepository.instance = new CaravanRepository();
        }

        return CaravanRepository.instance;
    }

    public Caravan mapToCaravan(ResultSet set){

        Caravan caravan = new Caravan();

        try{

            caravan.setCaravanId(set.getInt(1));
            caravan.setRentalPrice(set.getFloat(2));
            caravan.setIsAvaliable(set.getInt(3));
            caravan.setManufacturer(set.getString(4));
            caravan.setModelName(set.getString(5));

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return caravan;
    }

    public List<Caravan> getAllCaravans(){
        List<Caravan> caravans = new ArrayList<>();
        Caravan caravan;

        String query = "SELECT * FROM [Caravans]";

        Connection connectionInstance;
        Statement statement;
        ResultSet set;

        try{
            connectionInstance = DbConnection.getInstance();
            statement = connectionInstance.createStatement();
            set = statement.executeQuery(query);

            while (set.next()){
                caravans.add(mapToCaravan(set));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return caravans;
    }

    public Caravan getCaravanById(int id) {

        String query = "SELECT * FROM Caravans WHERE CaravanId = ?";

        Connection connectionInstance;
        Caravan caravan = new Caravan();

        try {

            connectionInstance = DbConnection.getInstance();

            PreparedStatement preparedStatement = connectionInstance.prepareStatement(query);

            preparedStatement.setInt(1, id);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                caravan = mapToCaravan(resultSet);
            }


        }catch(SQLException e){
            throw new RuntimeException(e);
        }

        return caravan;

    }

    public void addCaravan(Caravan caravan){
        String query = "INSERT INTO Caravans (RentalPrice, IsAvaliable, Manufacturer, ModelName) VALUES (?, ?, ?, ?)";

        Connection connectionInstance;

        try{
            connectionInstance = DbConnection.getInstance();

            PreparedStatement preparedStatement = connectionInstance.prepareStatement(query);

            preparedStatement.setFloat(1, caravan.getRentalPrice());
            preparedStatement.setInt(2, caravan.getIsAvaliable());
            preparedStatement.setString(3, caravan.getManufacturer());
            preparedStatement.setString(4, caravan.getModelName());

            preparedStatement.executeUpdate();


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void updateCaravan(Caravan caravan) {
        String query = "UPDATE Caravans SET RentalPrice = ?, IsAvaliable = ?, Manufacturer = ?, ModelName = ? WHERE CaravanId = ?";

        Connection connectionInstance;

        try {
            connectionInstance = DbConnection.getInstance();

            PreparedStatement preparedStatement = connectionInstance.prepareStatement(query);

            preparedStatement.setFloat(1, caravan.getRentalPrice());
            preparedStatement.setInt(2, caravan.getIsAvaliable());
            preparedStatement.setString(3, caravan.getManufacturer());
            preparedStatement.setString(4, caravan.getModelName());
            preparedStatement.setInt(5, caravan.getCaravanId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCaravanById(int id) {
        String query1 = "DELETE FROM Caravans WHERE CaravanId = ?";

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
