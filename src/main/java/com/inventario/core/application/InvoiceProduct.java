package com.inventario.core.application;

import com.inventario.core.domain.entities.Invoice;
import com.inventario.core.domain.entities.InvoiceDetail;
import com.inventario.core.domain.servicie.EditInvoiceService;
import com.inventario.core.domain.servicie.FindInvoiceService;
import com.inventario.core.domain.servicie.FindProductService;
import com.inventario.core.domain.servicie.InvoiceProductService;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class InvoiceProduct {
    private final InvoiceProductService invoiceProductService;
    private final EditInvoiceService editInvoiceService;
    private final FindInvoiceService findInvoiceService;
    private final FindProductService findProductService;
    public void invoiceProduct(List<InvoiceDetail> invoiceDetails){
        Invoice invoiceUpdate = findInvoiceService.findInvoice(invoiceDetails.get(0).getInvoiceNumber());
        invoiceDetails.stream().forEach(invoiceDetail -> buildInvoice(invoiceDetail,invoiceUpdate));
        editInvoiceService.editInvoice(invoiceUpdate);
    }

    private void buildInvoice(InvoiceDetail invoiceDetail, Invoice invoiceUpdate) {
        invoiceProductService.invoiceProduct(invoiceDetail);


        var product = findProductService.findProduct(invoiceDetail.getIdProduct());

        var subtotalProduct = invoiceDetail.getAmount() * product.getSellPrice();
        var iva = invoiceDetail.getIva() / 100;

        var amount = invoiceUpdate.getProductsAmount() + invoiceDetail.getAmount();
        var total = invoiceUpdate.getTotal() + subtotalProduct;
        var totalWithIva = invoiceUpdate.getTotalWithIva() + (subtotalProduct + (subtotalProduct * iva));
        var ivaInvoice = totalWithIva - total;

        invoiceUpdate.setProductsAmount(amount);
        invoiceUpdate.setTotal(total);
        invoiceUpdate.setTotalWithIva(totalWithIva);
        invoiceUpdate.setIva(ivaInvoice);

    }
}
