package com.inventario.core.infraestructure.adapter;

import com.inventario.core.domain.entities.InvoiceStateEnum;
import com.inventario.core.domain.servicie.PayInvoiceService;
import com.inventario.core.infraestructure.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.transaction.Transactional;

@AllArgsConstructor
@Service
@Slf4j
public class PayInvoiceAdapter implements PayInvoiceService {
    public final InvoiceRepository invoiceRepository;
    @Transactional
    public void payInvoice(Integer invoiceNumber){
        log.info("Pagando factura...");
        invoiceRepository.updateState(InvoiceStateEnum.PAID.name(),invoiceNumber);
    }
}
