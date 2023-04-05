package com.lakhan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lakhan.Entity.Client;
import com.lakhan.exception.ResourceNotFoundException;
import com.lakhan.repo.ClientRepository;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + id));
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client clientDetails) {
        Client client = getClientById(id);
        client.setName(clientDetails.getName());
        client.setDob(clientDetails.getDob());
        client.setAddress(clientDetails.getAddress());
        client.setContactInfo(clientDetails.getContactInfo());
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        Client client = getClientById(id);
        clientRepository.delete(client);
    }

}


