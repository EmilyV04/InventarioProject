package com.inventario.core.infraestructure.api.mapper;

import com.inventario.core.domain.entities.Category;
import com.inventario.core.infraestructure.api.request.CategoryRequest;
import com.inventario.core.shared.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface CategoryRequestMapper extends EntityMapper<CategoryRequest, Category> {
}
