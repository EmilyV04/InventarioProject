package com.inventario.core.infraestructure.dto.compositekeys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class KeyClientDto implements Serializable {
    private Integer id;
    private String typeId;
}
