package com.inventario.core.infraestructure.mapper;

import com.inventario.core.domain.entities.Invoice;
import com.inventario.core.infraestructure.dto.InvoiceDto;
import com.inventario.core.shared.mapper.EntityMapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {InvoiceDetailMapper.class, ClientMapper.class})
public interface InvoiceMapper extends EntityMapper<InvoiceDto, Invoice> {
}
