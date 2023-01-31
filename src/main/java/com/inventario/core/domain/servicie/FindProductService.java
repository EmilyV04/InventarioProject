package com.inventario.core.domain.servicie;

import com.inventario.core.domain.entities.Invoice;
import com.inventario.core.domain.entities.Product;

public interface FindProductService {
    Product findProduct(Integer idProduct);
}
