package com.tacoloco.orders.services.impl;

import com.tacoloco.orders.dto.ClientDTO;
import com.tacoloco.orders.entity.Client;
import com.tacoloco.orders.repository.ClientRepository;
import com.tacoloco.orders.services.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    ClientRepository clientRepository;

    ModelMapper modelMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ModelMapper modelMapper) {
        this.clientRepository = clientRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClientDTO create(ClientDTO clientDTO) {

        Client client = modelMapper.map(clientDTO, Client.class);
        return modelMapper.map(clientRepository.save(client), ClientDTO.class);
    }
}

