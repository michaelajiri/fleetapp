package com.infotech.fleetapp.service;

import com.infotech.fleetapp.model.Client;
import com.infotech.fleetapp.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Integer id){
        return clientRepository.findById(id);
    }

    public void addNewClient(Client client){
        clientRepository.save(client);
    }

    public void updateClient(Client client){
        clientRepository.save(client);
    }

    public void removeClient(Integer id){
        clientRepository.deleteById(id);
    }
}