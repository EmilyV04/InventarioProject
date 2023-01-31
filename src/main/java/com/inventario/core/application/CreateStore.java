package com.inventario.core.application;

import com.inventario.core.domain.entities.Store;
import com.inventario.core.domain.servicie.CreateStoreService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateStore {
    private final CreateStoreService createStoreService;
    public void createStore(Store store){
        createStoreService.createStore(store);
    }
}
