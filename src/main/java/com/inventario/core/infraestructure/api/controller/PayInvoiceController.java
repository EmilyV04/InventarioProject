package com.inventario.core.infraestructure.api.controller;

import com.inventario.core.application.PayInvoice;
import com.inventario.core.infraestructure.api.mapper.InvoiceRequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("invoice")
@RequiredArgsConstructor
public class PayInvoiceController {
    private final PayInvoice payInvoice;
    private final InvoiceRequestMapper invoiceRequestMapper;
    @PutMapping(value = "/payInvoice/{invoiceNumber}")
    public void PayInvoice(@PathVariable("invoiceNumber") Integer invoiceNumber){
        payInvoice.payInvoice(invoiceNumber);
    }
}
