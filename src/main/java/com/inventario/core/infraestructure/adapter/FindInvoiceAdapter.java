package com.inventario.core.infraestructure.adapter;

import com.inventario.core.domain.entities.Invoice;
import com.inventario.core.domain.entities.InvoiceStateEnum;
import com.inventario.core.domain.servicie.CreateInvoiceService;
import com.inventario.core.domain.servicie.FindInvoiceService;
import com.inventario.core.infraestructure.dto.compositekeys.KeyClientDto;
import com.inventario.core.infraestructure.mapper.InvoiceMapper;
import com.inventario.core.infraestructure.repository.ClientRepository;
import com.inventario.core.infraestructure.repository.InvoiceRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class FindInvoiceAdapter implements FindInvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;
    @Override
    public Invoice findInvoice(Integer idInvoice) {
        var invoice = invoiceRepository.findById(idInvoice);
        if (invoice.isEmpty()){
            throw new RuntimeException();
        }
        return invoiceMapper.toEntity(invoice.get());
    }
}
