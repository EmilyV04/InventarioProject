package com.inventario.core.infraestructure.adapter;

import com.inventario.core.domain.entities.Client;
import com.inventario.core.domain.servicie.CreateClientService;
import com.inventario.core.infraestructure.mapper.ClientMapper;
import com.inventario.core.infraestructure.repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class CreateClientAdapter implements CreateClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;
    @Override
    public Client createClient(Client client) {
        log.info("Registrando un cliente!");
        return clientMapper.toEntity(clientRepository.save(clientMapper.toDto(client)));
    }
}
