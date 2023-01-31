package com.inventario.core.domain.entities;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    private Integer id;
    private String name;
    private Double purchaseCost;
    private Double sellPrice;
    private Integer stock;
    private Integer size;
    private String typeIdStore;
    private Integer idStore;
    private Integer idCategory;
    private Store store;
    private Category category;
}
