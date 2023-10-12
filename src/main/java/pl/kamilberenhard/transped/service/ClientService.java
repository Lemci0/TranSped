package pl.kamilberenhard.transped.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kamilberenhard.transped.model.Client;
import pl.kamilberenhard.transped.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client getSingleClient(long id) {
        return clientRepository.findById(id)
                .orElseThrow();
    }

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    public Client editClient(Client client) {
        Client editedClient = clientRepository.findById(client.getId()).orElseThrow();
        editedClient.setName(client.getName());
        editedClient.setStreet(client.getStreet());
        editedClient.setCity(client.getCity());
        editedClient.setPostalCode(client.getPostalCode());
        return editedClient;
    }

    public void deleteClient(long id) {
        clientRepository.deleteById(id);
    }
}
