package com.inventario.core.infraestructure.repository;

import com.inventario.core.infraestructure.dto.StoreDto;
import com.inventario.core.infraestructure.dto.compositekeys.KeyStoreDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<StoreDto, KeyStoreDto> {
}
