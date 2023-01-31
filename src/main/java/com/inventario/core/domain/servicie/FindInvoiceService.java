package com.inventario.core.domain.servicie;

import com.inventario.core.domain.entities.Invoice;

public interface FindInvoiceService {
    Invoice findInvoice(Integer idInvoice);
}
