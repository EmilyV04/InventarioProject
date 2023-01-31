package com.inventario.core.infraestructure.dto;

import com.inventario.core.infraestructure.dto.compositekeys.KeyClientDto;
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
@Table(name = "cliente",schema = "inventario")
@IdClass(KeyClientDto.class)
public class ClientDto {
    @Id
    private Integer id;
    @Id
    private String typeId;
    private String names;
    private String lastNames;
    private Integer phoneNumber;
    private Integer cellphoneNumber;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="idStore", referencedColumnName="id"),
            @JoinColumn(name="typeIdStore", referencedColumnName="typeId")
    })
    private StoreDto store;

    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    private List<InvoiceDto> invoiceList;
}
