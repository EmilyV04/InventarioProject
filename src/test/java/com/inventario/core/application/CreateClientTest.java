package com.inventario.core.application;

import com.inventario.core.domain.entities.Client;
import com.inventario.core.domain.servicie.CreateClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CreateClientTest {
    @InjectMocks
    private CreateClient createClient;
    @Mock
    private CreateClientService createClientService;

    @Test
    void createClient() {
        var build = buildClient();
        var response = buildClient();
        Mockito.when(createClientService.createClient(build)).thenReturn(response);
        createClient.createClient(build);
        Mockito.verify(createClientService, Mockito.times(1)).createClient(build);
    }

    private Client buildClient(){
        return Client.builder().id(5)
                .typeId("CC")
                .names("Pablo")
                .lastNames("Montes")
                .phoneNumber(1478523)
                .cellphoneNumber(1236547895)
                .idStore(1)
                .typeIdStore("NIT").build();
    }
}