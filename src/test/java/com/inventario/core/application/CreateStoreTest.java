package com.inventario.core.application;

import com.inventario.core.domain.entities.Store;
import com.inventario.core.domain.servicie.CreateStoreService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CreateStoreTest {
    @InjectMocks
    private CreateStore createStore;
    @Mock
    private CreateStoreService createStoreService;
    @Test
    void createStore() {
        var build = buildStore();
        var response = buildStore();
        Mockito.when(createStoreService.createStore(build)).thenReturn(response);
        createStore.createStore(build);
        Mockito.verify(createStoreService, Mockito.times(1)).createStore(build);
    }

    private Store buildStore(){
        return Store.builder().id(2)
                .typeId("NIT")
                .name("Distribuidora ABC")
                .idCountry(456)
                .idMunicipality(654)
                .address("mz 25 lt 5").build();
    }
}