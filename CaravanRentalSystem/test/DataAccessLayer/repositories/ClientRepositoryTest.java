package DataAccessLayer.repositories;

import DataAccessLayer.models.Client;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientRepositoryTest {

    @Test
    void getInstance() {
        ClientRepository clientRepository;

        clientRepository = ClientRepository.getInstance();

        assertNotNull(clientRepository);

    }

    @Test
    void getAllClients() {
        List<Client> clientList;
        ClientRepository clientRepository = ClientRepository.getInstance();

        clientList = clientRepository.getAllClients();

        assertNotNull(clientList);
    }

    @Test
    void getClientById() {
        Client client = new Client();
        int expectedId = 1;
        ClientRepository clientRepository = ClientRepository.getInstance();

        client = clientRepository.getClientById(expectedId);
    }
    @Test
    void getClientByEmailAddress(){
        Client client;
        String expectedEmailAddress = "dmakiver0@geocities.jp";
        ClientRepository clientRepository = ClientRepository.getInstance();

        client = clientRepository.getClientByEmailAddress(expectedEmailAddress);

    }

    @Test
    void addClient() {
        Client client = new Client();
        client.setFirstName("Test");
        client.setLastName("Test");
        client.setEmailAddress("Test@gmail.com");
        client.setPassword("test123");
        ClientRepository clientRepository = ClientRepository.getInstance();
        Client result;

        clientRepository.addClient(client);
        result = clientRepository.getClientByEmailAddress("Test@gmail.com");

        assertNotNull(result.getEmailAddress());
        deleteTestUser();
    }

    @Test
    void updateClient() {
        Client client = new Client();
        client.setFirstName("Test");
        client.setLastName("Test");
        client.setEmailAddress("Test@gmail.com");
        client.setPassword("test123");
        ClientRepository clientRepository = ClientRepository.getInstance();
        String changedFirstName = "NewTest";
        Client newClient = client;
        newClient.setFirstName("NewTest");
        Client result;

        clientRepository.addClient(client);
        result = clientRepository.getClientByEmailAddress("Test@gmail.com");
        clientRepository.updateClient(newClient);

        assertEquals(result.getFirstName(), changedFirstName);
        deleteTestUser();
    }

    @Test
    void deleteClientById() {
        Client client = new Client();
        client.setFirstName("Test");
        client.setLastName("Test");
        client.setEmailAddress("Test@gmail.com");
        client.setPassword("test123");
        ClientRepository clientRepository = ClientRepository.getInstance();
        Client result;

        clientRepository.addClient(client);
        client = clientRepository.getClientByEmailAddress("Test@gmail.com");
        clientRepository.deleteClientById(client.getClientId());

        result = clientRepository.getClientByEmailAddress("Test@gmail.com");

        assertNull(result.getEmailAddress());

    }
    @AfterEach
     void deleteTestUser(){
        Client client = new Client();
        client.setEmailAddress("Test@gmail.com");
        ClientRepository clientRepository = ClientRepository.getInstance();

        client = clientRepository.getClientByEmailAddress("Test@gmail.com");
        clientRepository.deleteClientById(client.getClientId());

    }
}