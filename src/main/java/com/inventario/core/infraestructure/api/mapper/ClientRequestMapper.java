package com.inventario.core.infraestructure.api.mapper;

import com.inventario.core.domain.entities.Client;
import com.inventario.core.infraestructure.api.request.ClientRequest;
import com.inventario.core.shared.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface ClientRequestMapper extends EntityMapper<ClientRequest, Client> {
}
