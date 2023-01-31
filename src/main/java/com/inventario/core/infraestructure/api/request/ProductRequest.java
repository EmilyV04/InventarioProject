package com.inventario.core.infraestructure.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductRequest {
    private Integer id;
    private String name;
    private Double purchaseCost;
    private Double sellPrice;
    private Integer stock;
    private Integer size;
    private String typeIdStore;
    private Integer idStore;
    private Integer idCategory;
}
