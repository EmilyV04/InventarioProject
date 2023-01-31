package com.inventario.core.infraestructure.api.controller;

import com.inventario.core.application.CreateInvoice;
import com.inventario.core.infraestructure.api.mapper.InvoiceRequestMapper;
import com.inventario.core.infraestructure.api.request.InvoiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("invoice")
@RequiredArgsConstructor
public class CreateInvoiceController {
    private final CreateInvoice createInvoice;
    private final InvoiceRequestMapper invoiceRequestMapper;
    @PostMapping(value = "/createInvoice")
    public void CreateInvoice(@RequestBody InvoiceRequest invoiceRequest){
        createInvoice.createInvoice(invoiceRequestMapper.toEntity(invoiceRequest));
    }
}
