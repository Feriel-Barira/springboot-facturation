package com.exemple.billing_module.services;

import com.exemple.billing_module.dto.ClientDTO;
import com.exemple.billing_module.models.Client;
import com.exemple.billing_module.repositories.ClientRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // créer un client depuis le DTO
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());
        client.setSiret(clientDTO.getSiret());

        Client savedClient = clientRepository.save(client);

        // retourner DTO avec id et createdAt auto
        return new ClientDTO(
            savedClient.getId(),
            savedClient.getName(),
            savedClient.getEmail(),
            savedClient.getSiret(),
            savedClient.getCreatedAt()
        );
    }


    // récupérer tous les clients (DTO)
    public List<ClientDTO> getAllClients() {
        return clientRepository.findAll().stream()
                .map(c -> new ClientDTO(c.getId(), c.getName(), c.getEmail(), c.getSiret(), c.getCreatedAt()))
                .toList();
    }

    // récupérer un client par ID (DTO)
    public Optional<ClientDTO> getClientById(Long id) {
        return clientRepository.findById(id)
                .map(c -> new ClientDTO(c.getId(),c.getName(), c.getEmail(), c.getSiret(), c.getCreatedAt()));
    }
}



