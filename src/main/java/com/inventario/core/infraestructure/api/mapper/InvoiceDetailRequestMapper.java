package com.inventario.core.infraestructure.api.mapper;

import com.inventario.core.domain.entities.InvoiceDetail;
import com.inventario.core.infraestructure.api.request.InvoiceDetailRequest;
import com.inventario.core.shared.mapper.EntityMapper;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface InvoiceDetailRequestMapper extends EntityMapper<InvoiceDetailRequest, InvoiceDetail> {
}
