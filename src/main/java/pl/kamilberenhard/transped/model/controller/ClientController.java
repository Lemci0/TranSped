package pl.kamilberenhard.transped.model.controller;

import org.springframework.web.bind.annotation.*;
import pl.kamilberenhard.transped.model.Client;
import pl.kamilberenhard.transped.model.service.ClientService;

import java.util.List;

@RestController
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients")
    public List<Client> getClients() {
        return clientService.getClients();
    }

    @GetMapping("/clients/{id}")
    public Client getSingleClient(@PathVariable long id) {
        return clientService.getSingleClient(id);
    }

    @PostMapping("/clients")
    public Client addClient(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @PutMapping("/clients")
    public Client editClient(@RequestBody Client client) {
        return clientService.editClient(client);
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable long id) {
        clientService.deleteClient(id);
    }
}
