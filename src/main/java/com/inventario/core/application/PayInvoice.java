package com.inventario.core.application;

import com.inventario.core.domain.entities.Invoice;
import com.inventario.core.domain.servicie.PayInvoiceService;
import com.inventario.core.domain.servicie.SubtractProductStockService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PayInvoice {
    private final PayInvoiceService payInvoiceService;
    private final SubtractProductStockService subtractProductStockService;
    public void payInvoice(Integer invoiceNumber){
        subtractProductStockService.subtractProductStock(invoiceNumber);
        payInvoiceService.payInvoice(invoiceNumber);
    }
}
