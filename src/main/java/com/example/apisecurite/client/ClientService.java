package com.example.apisecurite.client;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final CopyOnWriteArrayList<Client> clients = new CopyOnWriteArrayList<>();

    public ClientService() {
        clients.add(new Client("Alice", "Durand"));
        clients.add(new Client("Bob", "Martin"));
    }

    public List<Client> getClients() {
        return Collections.unmodifiableList(clients);
    }

    public Client addClient(String firstName, String lastName) {
        Client client = new Client(firstName, lastName);
        clients.add(client);
        return client;
    }

    public boolean deleteClient(String firstName, String lastName) {
        return clients.removeIf(client -> client.matches(firstName, lastName));
    }
}

