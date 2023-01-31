package com.inventario.core.infraestructure.dto;

import com.inventario.core.domain.entities.InvoiceStateEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "factura",schema = "inventario")
public class InvoiceDto {
    @Id
    private Integer invoiceNumber;
    private String description;
    private Double total;
    private Double totalWithIva;
    private Double iva;
    private Integer productsAmount;
    @Enumerated(EnumType.STRING)
    private InvoiceStateEnum state;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="idClient", referencedColumnName="id"),
            @JoinColumn(name="typeIdClient", referencedColumnName="typeId")
    })
    private ClientDto client;

    @OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY)
    private List<InvoiceDetailDto> invoiceDetailList;
}
