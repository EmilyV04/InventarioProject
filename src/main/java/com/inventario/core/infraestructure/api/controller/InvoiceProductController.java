package com.inventario.core.infraestructure.api.controller;

import com.inventario.core.application.InvoiceProduct;
import com.inventario.core.infraestructure.api.mapper.InvoiceDetailRequestMapper;
import com.inventario.core.infraestructure.api.request.InvoiceDetailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class InvoiceProductController {
    private final InvoiceProduct invoiceProduct;
    private final InvoiceDetailRequestMapper invoiceDetailRequestMapper;
    @PostMapping(value = "/invoiceProduct")
    public void InvoiceProduct(@RequestBody List<InvoiceDetailRequest> invoiceDetailRequest){
        invoiceProduct.invoiceProduct(invoiceDetailRequestMapper.toEntity(invoiceDetailRequest));
    }
}
