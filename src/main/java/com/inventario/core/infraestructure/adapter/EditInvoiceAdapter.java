package com.inventario.core.infraestructure.adapter;

import com.inventario.core.domain.entities.Invoice;
import com.inventario.core.domain.entities.InvoiceDetail;
import com.inventario.core.domain.servicie.EditInvoiceService;
import com.inventario.core.infraestructure.dto.InvoiceDto;
import com.inventario.core.infraestructure.dto.compositekeys.KeyClientDto;
import com.inventario.core.infraestructure.mapper.InvoiceMapper;
import com.inventario.core.infraestructure.repository.ClientRepository;
import com.inventario.core.infraestructure.repository.InvoiceRepository;
import com.inventario.core.infraestructure.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
@Slf4j
public class EditInvoiceAdapter implements EditInvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final ProductRepository productRepository;
    @Transactional
    public void editInvoice(Invoice invoice){
        log.info("Editando factura...");

        invoiceRepository.updateTotalAndTotalWithIvaAndIvaAndProductsAmount(invoice.getTotal(),
                                                                            invoice.getTotalWithIva(),
                                                                            invoice.getIva(),
                                                                            invoice.getProductsAmount(),
                                                                            invoice.getInvoiceNumber());
    }
}
