package com.inventario.core.infraestructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "detalle_factura",schema = "inventario")
public class InvoiceDetailDto {
    @Id
    private Integer id;
    private Integer amount;
    private Double total;
    private Double iva;
    private Double totalWithIva;

    @ManyToOne
    @JoinColumn(name = "invoiceNumber", referencedColumnName = "invoiceNumber")
    private InvoiceDto invoice;

    @ManyToOne
    @JoinColumn(name = "idProduct", referencedColumnName = "id")
    private ProductDto product;

}
