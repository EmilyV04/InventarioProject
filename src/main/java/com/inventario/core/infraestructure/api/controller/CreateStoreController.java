package com.inventario.core.infraestructure.api.controller;

import com.inventario.core.application.CreateStore;
import com.inventario.core.infraestructure.api.mapper.StoreRequestMapper;
import com.inventario.core.infraestructure.api.request.StoreRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("store")
@RequiredArgsConstructor
public class CreateStoreController {
    private final CreateStore createStore;
    private final StoreRequestMapper storeRequestMapper;

    @PostMapping(value = "/createStore")
    public void CreateStore(@RequestBody StoreRequest storeRequest){
        createStore.createStore(storeRequestMapper.toEntity(storeRequest));
    }
}
