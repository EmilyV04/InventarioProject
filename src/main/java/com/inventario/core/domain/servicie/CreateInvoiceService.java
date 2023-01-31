package com.inventario.core.domain.servicie;

import com.inventario.core.domain.entities.Invoice;

public interface CreateInvoiceService {
    Invoice createInvoice(Invoice invoice);
}
