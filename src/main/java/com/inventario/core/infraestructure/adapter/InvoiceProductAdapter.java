package com.inventario.core.infraestructure.adapter;

import com.inventario.core.domain.entities.Invoice;
import com.inventario.core.domain.entities.InvoiceDetail;
import com.inventario.core.domain.entities.InvoiceStateEnum;
import com.inventario.core.domain.servicie.InvoiceProductService;
import com.inventario.core.infraestructure.mapper.InvoiceDetailMapper;
import com.inventario.core.infraestructure.repository.InvoiceDetailRepository;
import com.inventario.core.infraestructure.repository.InvoiceRepository;
import com.inventario.core.infraestructure.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class InvoiceProductAdapter implements InvoiceProductService {
    private final InvoiceDetailRepository invoiceDetailRepository;
    private final InvoiceDetailMapper invoiceDetailMapper;
    private final InvoiceRepository invoiceRepository;
    private final ProductRepository productRepository;
    private final VerifyStockProductAdapter verifyStockProductAdapter;
    public InvoiceDetail invoiceProduct(InvoiceDetail invoiceDetail){

        var stateInvoice = invoiceRepository.getReferenceById(invoiceDetail.getInvoiceNumber()).getState();
        var existsInvoice = invoiceRepository.findById(invoiceDetail.getInvoiceNumber());
        var existsProduct = productRepository.findById(invoiceDetail.getIdProduct());
        var productStock = verifyStockProductAdapter.verifyStockProduct(invoiceDetail.getIdProduct(),invoiceDetail.getAmount());

        if(existsInvoice.isEmpty()){
            log.info("Factura no existente! Cree una nueva factura...");
            throw new RuntimeException();
        }

        if(!stateInvoice.equals(InvoiceStateEnum.GENERATED)){
            log.info("Factura no disponible!");
            throw new RuntimeException();
        }

        if(existsProduct.isEmpty()){
            log.info("Producto no existente!");
            throw new RuntimeException();
        }

        if(!productStock){
            log.info("Producto sin stock suficiente!");
            throw new RuntimeException();
        }

        log.info("Agregando un producto a la factura...");
        var product = productRepository.findById(invoiceDetail.getIdProduct());
        var invoice = invoiceRepository.findById(invoiceDetail.getInvoiceNumber());

        var productItems = productRepository.getById(invoiceDetail.getIdProduct());
        var iva = invoiceDetail.getIva() / 100;
        var total = invoiceDetail.getAmount() * productItems.getSellPrice();
        var totalWithIva = total + (total * iva);

        var invoiceDetailEntity = invoiceDetailMapper.toDto(invoiceDetail);
        invoiceDetailEntity.setProduct(product.get());
        invoiceDetailEntity.setInvoice(invoice.get());
        invoiceDetailEntity.setTotal(total);
        invoiceDetailEntity.setTotalWithIva(totalWithIva);

        return invoiceDetailMapper.toEntity(invoiceDetailRepository.save(invoiceDetailEntity));
    }
}
