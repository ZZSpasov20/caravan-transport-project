package BusinessLayer.services;

import DataAccessLayer.models.Client;
import DataAccessLayer.repositories.ClientRepository;

import java.util.ArrayList;
import java.util.List;

public class ClientService {
    private static ClientService instance = null;

    private final ClientRepository clientRepository;

    private ClientService() {
        this.clientRepository = ClientRepository.getInstance();
    }

    public static ClientService getInstance() {

        if (ClientService.instance == null) {
            ClientService.instance = new ClientService();
        }

        return ClientService.instance;
    }

    public String castClientToString(Client clientModule){
        String client = "";
        client = clientModule.toString();
        return client;
    }

    public Client mapValuesToClient(String firstName, String lastName,String emailAddress,String password){
        Client client = new Client();

        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setEmailAddress(emailAddress);
        client.setPassword(password);

        return client;
    }

    public Client mapValuesToClient(int id, String firstName, String lastName,String emailAddress,String password){
        Client client = new Client();
        
        client.setClientId(id);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setEmailAddress(emailAddress);
        client.setPassword(password);

        return client;
    }

    public List<String> getAllClients(){
        List<String> allClients = new ArrayList<>();
        List<Client> allClientsModules = new ArrayList<>();
        allClientsModules = clientRepository.getAllClients();

        for (Client client : allClientsModules ){
            allClients.add(castClientToString(client));
        }

        return allClients;
    }

    public String getClientById(int id){
        String client = "";

        client = castClientToString(clientRepository.getClientById(id));

        return client;
    }

    public void addClient(String firstName, String lastName,String emailAddress,String password){
        clientRepository.addClient(mapValuesToClient(firstName, lastName, emailAddress, password));
    }

    public void updateClient(int id, String firstName, String lastName,String emailAddress,String password){
        clientRepository.updateClient(mapValuesToClient(id, firstName, lastName, emailAddress, password));
    }

    public void deleteClient(int id) {
        clientRepository.deleteClientById(id);
    }
}
