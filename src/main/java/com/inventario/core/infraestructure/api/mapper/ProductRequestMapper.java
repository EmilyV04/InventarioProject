package com.inventario.core.infraestructure.api.mapper;

import com.inventario.core.domain.entities.Product;
import com.inventario.core.infraestructure.api.request.ProductRequest;
import com.inventario.core.shared.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductRequestMapper extends EntityMapper<ProductRequest, Product> {
}
