package com.inventario.core.infraestructure.api.controller;

import com.inventario.core.application.CreateClient;
import com.inventario.core.infraestructure.api.mapper.ClientRequestMapper;
import com.inventario.core.infraestructure.api.request.ClientRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("client")
@RequiredArgsConstructor
public class CreateClientController {
    private final CreateClient createClient;
    private final ClientRequestMapper clientRequestMapper;
    @PostMapping(value = "/createClient")
    public void CreateClient(@RequestBody ClientRequest clientRequest) {
        createClient.createClient(clientRequestMapper.toEntity(clientRequest));
    }
}
