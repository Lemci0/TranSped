package pl.kamilberenhard.transped.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kamilberenhard.transped.model.Client;
import pl.kamilberenhard.transped.service.ClientService;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientService clientService;

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
