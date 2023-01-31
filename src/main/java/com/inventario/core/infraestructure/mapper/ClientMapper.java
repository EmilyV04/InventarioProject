package com.inventario.core.infraestructure.mapper;

import com.inventario.core.domain.entities.Client;
import com.inventario.core.infraestructure.dto.ClientDto;
import com.inventario.core.shared.mapper.EntityMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {StoreMapper.class, InvoiceMapper.class})
public interface ClientMapper extends EntityMapper<ClientDto, Client> {
}
