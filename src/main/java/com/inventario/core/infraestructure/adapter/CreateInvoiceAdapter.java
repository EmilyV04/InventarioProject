package com.inventario.core.infraestructure.adapter;

import com.inventario.core.domain.entities.Invoice;
import com.inventario.core.domain.entities.InvoiceStateEnum;
import com.inventario.core.domain.servicie.CreateInvoiceService;
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
public class CreateInvoiceAdapter implements CreateInvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;
    private final ClientRepository clientRepository;
    @Override
    public Invoice createInvoice(Invoice invoice) {
        log.info("Creando factura...");
        var keyClient = KeyClientDto.builder().id(invoice.getIdClient()).typeId(invoice.getTypeIdClient()).build();
        var client = clientRepository.findById(keyClient);
        var invoiceEntity = invoiceMapper.toDto(invoice);

        invoiceEntity.setClient(client.get());
        invoiceEntity.setTotal(0.0);
        invoiceEntity.setIva(0.0);
        invoiceEntity.setTotalWithIva(0.0);
        invoiceEntity.setProductsAmount(0);
        invoiceEntity.setState(InvoiceStateEnum.GENERATED);

        return invoiceMapper.toEntity(invoiceRepository.save(invoiceEntity));
    }
}
