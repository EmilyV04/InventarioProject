package com.inventario.core.domain.servicie;

import com.inventario.core.domain.entities.Invoice;
import com.inventario.core.domain.entities.InvoiceDetail;

public interface EditInvoiceService {
    void editInvoice(Invoice invoice);
}
