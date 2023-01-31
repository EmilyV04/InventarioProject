package com.inventario.core.infraestructure.api.request;

import com.inventario.core.domain.entities.InvoiceStateEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class InvoiceRequest {
    private Integer invoiceNumber;
    private String description;
    private Double total;
    private Double totalWithIva;
    private Integer iva;
    private Integer productsAmount;
    @Enumerated(EnumType.STRING)
    private InvoiceStateEnum state;
    private Integer idClient;
    private String typeIdClient;
}
