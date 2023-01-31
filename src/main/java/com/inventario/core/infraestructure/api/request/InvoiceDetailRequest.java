package com.inventario.core.infraestructure.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class InvoiceDetailRequest {
    private Integer id;
    private Integer idProduct;
    private Integer amount;
    private Double total;
    private Double iva;
    private Double totalWithIva;
    private Integer invoiceNumber;
}
