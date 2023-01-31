package com.inventario.core.infraestructure.adapter;

import com.inventario.core.domain.servicie.SubtractProductStockService;
import com.inventario.core.infraestructure.dto.InvoiceDetailDto;
import com.inventario.core.infraestructure.repository.InvoiceDetailRepository;
import com.inventario.core.infraestructure.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
@Slf4j
public class SubtractProductStockAdapter implements SubtractProductStockService {
    private final InvoiceDetailRepository invoiceDetailRepository;
    private final ProductRepository productRepository;
    @Transactional
    public void subtractProductStock(Integer invoiceNumber){
        log.info("Descontando productos del inventario...");
        List<InvoiceDetailDto> invoiceDetails = invoiceDetailRepository.findByInvoiceNumber(invoiceNumber);

        invoiceDetails.forEach(invoiceDetail -> {
            var product = productRepository.getById(invoiceDetail.getProduct().getId());
            var newStock = product.getStock() - invoiceDetail.getAmount();
            productRepository.updateStock(newStock, product.getId());
        });
    }
}
