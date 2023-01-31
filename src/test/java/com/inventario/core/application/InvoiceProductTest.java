package com.inventario.core.application;

import com.inventario.core.domain.entities.Invoice;
import com.inventario.core.domain.entities.InvoiceDetail;
import com.inventario.core.domain.entities.Product;
import com.inventario.core.domain.servicie.EditInvoiceService;
import com.inventario.core.domain.servicie.FindInvoiceService;
import com.inventario.core.domain.servicie.FindProductService;
import com.inventario.core.domain.servicie.InvoiceProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class InvoiceProductTest {
    @InjectMocks
    private InvoiceProduct invoiceProduct;
    @Mock
    private InvoiceProductService invoiceProductService;
    @Mock
    private EditInvoiceService editInvoiceService;
    @Mock
    private FindInvoiceService findInvoiceService;
    @Mock
    private FindProductService findProductService;

    @Test
    void invoiceProduct() {
        var buildList = buildInvoiceDetails();
        var build = buildInvoiceDetail();
        var invoice = buildInvoice();

        Mockito.when(findInvoiceService.findInvoice(buildList.get(0).getInvoiceNumber())).thenReturn(invoice);
        Mockito.when(findProductService.findProduct(1)).thenReturn(buildProduct());

        invoice.setProductsAmount(10);
        invoice.setTotal(50000.0);
        invoice.setTotalWithIva(59500.0);
        invoice.setIva(9500.0);

        invoiceProduct.invoiceProduct(buildList);
        Mockito.verify(invoiceProductService, Mockito.times(1)).invoiceProduct(build);
        Mockito.verify(findInvoiceService, Mockito.times(1)).findInvoice(1);
        Mockito.verify(findProductService, Mockito.times(1)).findProduct(1);
        Mockito.verify(editInvoiceService, Mockito.times(1)).editInvoice(invoice);
    }

    private Product buildProduct() {
        return Product.builder().id(4)
                .name("Ropa")
                .sellPrice(5000.0)
                .purchaseCost(4000.0)
                .stock(20)
                .idCategory(1)
                .idStore(1)
                .typeIdStore("NIT")
                .size(50).build();
    }

    private Invoice buildInvoice(){
        return Invoice.builder().invoiceNumber(1)
                .description("Factura 001")
                .idClient(1)
                .typeIdClient("CC").build();
    }

    private List<InvoiceDetail> buildInvoiceDetails(){
        return List.of(buildInvoiceDetail());
    }

    private InvoiceDetail buildInvoiceDetail(){
        return InvoiceDetail.builder().id(4)
                .amount(10)
                .iva(19.0)
                .idProduct(1)
                .invoiceNumber(1).build();
    }
}