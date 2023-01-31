package com.inventario.core.infraestructure.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StoreRequest {
    private Integer id;
    private String typeId;
    private String name;
    private Integer idCountry;
    private Integer idMunicipality;
    private String address;
}
