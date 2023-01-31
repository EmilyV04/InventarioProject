package com.inventario.core.infraestructure.mapper;

import com.inventario.core.domain.entities.Store;
import com.inventario.core.infraestructure.dto.StoreDto;
import com.inventario.core.shared.mapper.EntityMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses={ProductMapper.class, ClientMapper.class})
public interface StoreMapper extends EntityMapper<StoreDto, Store> {
}
