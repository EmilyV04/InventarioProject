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
@Table(name = "categoria",schema = "inventario")
public class CategoryDto {
    @Id
    private Integer id;
    private String name;
    private String sizeUnit;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<ProductDto> productList;
}
