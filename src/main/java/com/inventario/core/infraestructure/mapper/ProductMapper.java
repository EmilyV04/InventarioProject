package com.inventario.core.infraestructure.mapper;

import com.inventario.core.domain.entities.Product;
import com.inventario.core.infraestructure.dto.ProductDto;
import com.inventario.core.shared.mapper.EntityMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper (componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {StoreMapper.class, CategoryMapper.class, InvoiceDetailMapper.class})
public interface ProductMapper extends EntityMapper<ProductDto, Product> {
}
