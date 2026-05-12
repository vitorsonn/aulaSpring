package com.fatec.product.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.product.entities.Client;
import com.fatec.product.repositories.ClientRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    public List<Client> getClients() {
        return repository.findAll();

    }

    public Client getClientById(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException());
    }

}
