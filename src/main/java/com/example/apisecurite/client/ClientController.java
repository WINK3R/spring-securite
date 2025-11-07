package com.example.apisecurite.client;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
@Validated
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> listClients() {
        return clientService.getClients();
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody @Validated ClientRequest request) {
        Client created = clientService.addClient(request.firstName(), request.lastName());
        return ResponseEntity.ok(created);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteClient(@RequestBody @Validated ClientRequest request) {
        boolean removed = clientService.deleteClient(request.firstName(), request.lastName());
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}

