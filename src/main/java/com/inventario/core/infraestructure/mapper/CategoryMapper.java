package com.inventario.core.infraestructure.mapper;

import com.inventario.core.domain.entities.Category;
import com.inventario.core.infraestructure.dto.CategoryDto;
import com.inventario.core.shared.mapper.EntityMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper (componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {ProductMapper.class})
public interface CategoryMapper extends EntityMapper<CategoryDto, Category> {
}
