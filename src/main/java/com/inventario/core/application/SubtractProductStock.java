package com.inventario.core.application;

import com.inventario.core.domain.servicie.SubtractProductStockService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SubtractProductStock {
    private final SubtractProductStockService subtractProductStockService;
    public void subtractProductStock(Integer invoiceNumber){
        subtractProductStockService.subtractProductStock(invoiceNumber);
    }
}
