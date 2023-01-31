package com.inventario.core.infraestructure.api.mapper;

import com.inventario.core.domain.entities.Store;
import com.inventario.core.infraestructure.api.request.StoreRequest;
import com.inventario.core.shared.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StoreRequestMapper extends EntityMapper<StoreRequest, Store> {
}
