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

    public void delete(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
        }

        else{
            throw new EntityNotFoundException("Cliente não encontrado");

        }

    }

    public Client save(Client client){
        return repository.save(client);
    }

    public void update (Client client, Long id){
        Client c = repository.findById(id)
                .orElseThrow( () -> new EntityNotFoundException("Cliente não cadastrado"));

        c.setName(client.getName());
        c.setEmail(client.getEmail());
        c.setDoc(client.getDoc());
        c.setDataCadastro(client.getDataCadastro());

        repository.save(c);

    }

}
