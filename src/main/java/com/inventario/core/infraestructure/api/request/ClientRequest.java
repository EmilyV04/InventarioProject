package com.inventario.core.infraestructure.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientRequest {
    private Integer id;
    private String typeId;
    private String names;
    private String lastNames;
    private Integer phoneNumber;
    private Integer cellphoneNumber;
    private String typeIdStore;
    private Integer idStore;
}
