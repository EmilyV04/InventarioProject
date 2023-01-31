package com.inventario.core.infraestructure.dto;

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
@Table(name = "producto",schema = "inventario")
public class ProductDto {
    @Id
    private Integer id;
    private String name;
    private Double purchaseCost;
    private Double sellPrice;
    private Integer stock;
    private Integer size;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="idStore", referencedColumnName="id"),
            @JoinColumn(name="typeIdStore", referencedColumnName="typeId")
    })
    private StoreDto store;

    @ManyToOne
    @JoinColumn(name="idCategory", referencedColumnName = "id")
    private CategoryDto category;


}
