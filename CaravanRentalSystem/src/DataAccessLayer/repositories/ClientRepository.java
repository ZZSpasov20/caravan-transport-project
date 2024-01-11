package DataAccessLayer.repositories;

import DataAccessLayer.models.Client;
import utils.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    private static ClientRepository instance = null;

    public static ClientRepository getInstance() {

        if (ClientRepository.instance == null) {
            ClientRepository.instance = new ClientRepository();
        }

        return ClientRepository.instance;
    }

    public Client mapToClient(ResultSet set){

        Client account = new Client();

        try{

            account.setClientId(set.getInt(1));
            account.setFirstName(set.getString(2));
            account.setLastName(set.getString(3));
            account.setEmailAddress(set.getString(4));
            account.setPassword(set.getString(5));

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return account;
    }

    public List<Client> getAllClients(){
        List<Client> clients = new ArrayList<>();
        Client client;

        String query = "SELECT * FROM [Clients]";

        Connection connectionInstance;
        Statement statement;
        ResultSet set;

        try{
            connectionInstance = DbConnection.getInstance();
            statement = connectionInstance.createStatement();
            set = statement.executeQuery(query);

            while (set.next()){
                clients.add(mapToClient(set));
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return clients;
    }

    public Client getClientById(int id) {

        String query = "SELECT * FROM Clients WHERE ClientId = ?";

        Connection connectionInstance;
        Client client = new Client();

        try {

            connectionInstance = DbConnection.getInstance();

            PreparedStatement preparedStatement = connectionInstance.prepareStatement(query);

            preparedStatement.setInt(1, id);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                client = mapToClient(resultSet);
            }


        }catch(SQLException e){
            throw new RuntimeException(e);
        }

        return client;

    }

    public Client getClientByEmailAddress(String emailAddress) {

        String query = "SELECT * FROM Clients WHERE EmailAddress like ?";

        Connection connectionInstance;
        Client client = new Client();

        try {

            connectionInstance = DbConnection.getInstance();

            PreparedStatement preparedStatement = connectionInstance.prepareStatement(query);

            preparedStatement.setString(1, emailAddress);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                client = mapToClient(resultSet);
            }


        }catch(SQLException e){
            throw new RuntimeException(e);
        }

        return client;

    }

    public void addClient(Client client){
        String query = "INSERT INTO Clients (FirstName, LastName, EmailAddress, Password) VALUES (?, ?, ?, ?)";

        Connection connectionInstance;

        try{
            connectionInstance = DbConnection.getInstance();

            PreparedStatement preparedStatement = connectionInstance.prepareStatement(query);

            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, client.getEmailAddress());
            preparedStatement.setString(4, client.getPassword());

            preparedStatement.executeUpdate();


        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void updateClient(Client client) {
        String query = "UPDATE Clients SET FirstName = ?, LastName = ?, EmailAddress = ?, Password = ? WHERE ClientId = ?";

        Connection connectionInstance;

        try {
            connectionInstance = DbConnection.getInstance();

            PreparedStatement preparedStatement = connectionInstance.prepareStatement(query);

            preparedStatement.setString(1, client.getFirstName());
            preparedStatement.setString(2, client.getLastName());
            preparedStatement.setString(3, client.getEmailAddress());
            preparedStatement.setString(4, client.getPassword());
            preparedStatement.setInt(5, client.getClientId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteClientById(int id) {
        String query1 = "DELETE FROM Clients WHERE ClientId = ?";

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
