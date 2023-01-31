package com.inventario.core.application;

import com.inventario.core.domain.entities.Invoice;
import com.inventario.core.domain.entities.InvoiceDetail;
import com.inventario.core.domain.servicie.EditInvoiceService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EditInvoice {
    private final EditInvoiceService editInvoiceService;
    public void editInvoice(Invoice invoice){
        editInvoiceService.editInvoice(invoice);
    }
}
