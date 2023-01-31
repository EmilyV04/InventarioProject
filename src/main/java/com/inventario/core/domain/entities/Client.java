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
public class Client {
    private Integer id;
    private String typeId;
    private String names;
    private String lastNames;
    private Integer phoneNumber;
    private Integer cellphoneNumber;
    private String typeIdStore;
    private Integer idStore;
    private Store store;
}
