package com.example.resttemplate.service;

import com.example.resttemplate.model.Client;
import com.example.resttemplate.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public Client update(Client client) {
        return save(Client.builder()
                .id(client.getId())
                .name(client.getName())
                .dateFrom(client.getDateFrom())
                .dateTo(client.getDateTo())
                .status(client.getStatus())
                .build());
    }

    public void deleteById(int id) {
        clientRepository.deleteById(id);
    }

    public Optional<Client> findById(int id) {
        return clientRepository.findById(id);
    }

    public Page<Client> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }
}
