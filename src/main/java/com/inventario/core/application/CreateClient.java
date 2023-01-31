package com.inventario.core.application;

import com.inventario.core.domain.entities.Client;
import com.inventario.core.domain.servicie.CreateClientService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateClient {
    private final CreateClientService createClientService;
    public void createClient(Client client){
        createClientService.createClient(client);
    }
}
