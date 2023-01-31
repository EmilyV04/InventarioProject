package com.inventario.core.infraestructure.repository;

import com.inventario.core.infraestructure.dto.ClientDto;
import com.inventario.core.infraestructure.dto.compositekeys.KeyClientDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientDto, KeyClientDto> {
}
