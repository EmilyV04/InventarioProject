package com.inventario.core.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Invoice {
    private Integer invoiceNumber;
    private String description;
    private Double total;
    private Double totalWithIva;
    private Double iva;
    private Integer productsAmount;
    private InvoiceStateEnum state;
    private Integer idClient;
    private String typeIdClient;
    private Client client;

}
