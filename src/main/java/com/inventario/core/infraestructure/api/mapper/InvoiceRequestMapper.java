package com.inventario.core.infraestructure.api.mapper;

import com.inventario.core.domain.entities.Invoice;
import com.inventario.core.infraestructure.api.request.InvoiceRequest;
import com.inventario.core.shared.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface InvoiceRequestMapper extends EntityMapper<InvoiceRequest, Invoice> {
}
