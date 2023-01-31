package com.inventario.core.infraestructure.repository;

import com.inventario.core.domain.entities.InvoiceStateEnum;
import com.inventario.core.infraestructure.dto.InvoiceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceDto,Integer> {
    @Query(nativeQuery = true, value = "update inventario.factura set total = :total, total_with_iva = :totalWithIva, iva = :iva, products_amount = :productsAmount where invoice_number = :invoiceNumber")
    @Modifying
    void updateTotalAndTotalWithIvaAndIvaAndProductsAmount(@Param("total") Double total,
                                                           @Param("totalWithIva") Double totalWthIva,
                                                           @Param("iva") Double iva,
                                                           @Param("productsAmount") Integer productsAmount,
                                                           @Param("invoiceNumber") Integer invoiceNumber);

    @Query(nativeQuery = true, value = "update inventario.factura set state = :state where invoice_number = :invoiceNumber")
    @Modifying
    void updateState(@Param("state") String state, @Param("invoiceNumber") Integer invoiceNumber);
    @Query(nativeQuery = true, value = "select * from inventario.factura where invoice_number = :invoiceNumber")
    InvoiceDto findByInvoiceNumber(@Param("invoiceNumber") Integer invoiceNumber);
}
