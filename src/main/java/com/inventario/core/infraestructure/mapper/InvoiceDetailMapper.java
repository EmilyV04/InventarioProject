package com.inventario.core.infraestructure.mapper;

import com.inventario.core.domain.entities.InvoiceDetail;
import com.inventario.core.infraestructure.dto.InvoiceDetailDto;
import com.inventario.core.shared.mapper.EntityMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper (componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {InvoiceMapper.class, ProductMapper.class})
public interface InvoiceDetailMapper extends EntityMapper<InvoiceDetailDto, InvoiceDetail> {
}
