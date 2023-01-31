package com.inventario.core.infraestructure.dto;

import com.inventario.core.infraestructure.dto.compositekeys.KeyStoreDto;
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
@Table(name = "tienda",schema = "inventario")
@IdClass(KeyStoreDto.class)
public class StoreDto {
    @Id
    private Integer id;
    @Id
    private String typeId;
    private String name;
    private Integer idCountry;
    private Integer idMunicipality;
    private String address;

    @OneToMany(mappedBy = "store",fetch = FetchType.LAZY)
    private List<ProductDto> productList;

    @OneToMany(mappedBy = "store",fetch = FetchType.LAZY)
    private List<ClientDto> clientList;
}
