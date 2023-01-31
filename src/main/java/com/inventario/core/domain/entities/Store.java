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
public class Store {
    private Integer id;
    private String typeId;
    private String name;
    private Integer idCountry;
    private Integer idMunicipality;
    private String address;
}
