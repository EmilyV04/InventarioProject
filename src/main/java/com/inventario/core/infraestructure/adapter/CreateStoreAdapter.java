package com.inventario.core.infraestructure.adapter;

import com.inventario.core.domain.entities.Store;
import com.inventario.core.domain.servicie.CreateStoreService;
import com.inventario.core.infraestructure.mapper.StoreMapper;
import com.inventario.core.infraestructure.repository.StoreRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class CreateStoreAdapter implements CreateStoreService {
    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;
    public Store createStore(Store store){
        log.info("Creando una tienda!");
        return storeMapper.toEntity(storeRepository.save(storeMapper.toDto(store)));
    }

}
