package com.inventario.core.infraestructure.repository;

import com.inventario.core.infraestructure.dto.InvoiceDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetailDto,Integer> {
    @Query(nativeQuery = true, value = "select * from inventario.detalle_factura where invoice_number = :invoiceNumber")
    List<InvoiceDetailDto> findByInvoiceNumber(@Param("invoiceNumber") Integer invoiceNumber);
}
