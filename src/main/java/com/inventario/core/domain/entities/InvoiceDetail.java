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
public class InvoiceDetail {
    private Integer id;
    private Integer idProduct;
    private Integer amount;
    private Double total;
    private Double iva;
    private Double totalWithIva;
    private Integer invoiceNumber;
    private Invoice invoice;
}
