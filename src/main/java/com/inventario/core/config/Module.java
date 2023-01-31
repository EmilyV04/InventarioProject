package com.inventario.core.config;

import com.inventario.core.application.*;
import com.inventario.core.domain.servicie.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Module {
    @Bean
    public CreateProduct createProduct(CreateProductService createProductService){
        return new CreateProduct(createProductService);
    }
    @Bean
    public DeleteProduct deleteProduct(DeleteProductService deleteProductService){
        return new DeleteProduct(deleteProductService);
    }
    @Bean
    public CreateStore createStore(CreateStoreService createStoreService){
        return new CreateStore(createStoreService);
    }
    @Bean
    public InvoiceProduct invoiceProduct(InvoiceProductService invoiceProductService, EditInvoiceService editInvoiceService, FindInvoiceService findInvoiceService, FindProductService findProductService){
        return new InvoiceProduct(invoiceProductService, editInvoiceService, findInvoiceService, findProductService);
    }
    @Bean
    public CreateClient createClient(CreateClientService createClientService){
        return new CreateClient(createClientService);
    }
    @Bean
    public CreateCategory createCategory(CreateCategoryService createCategoryService){
        return new CreateCategory(createCategoryService);
    }
    @Bean
    public CreateInvoice createInvoice(CreateInvoiceService createInvoiceService){
        return new CreateInvoice(createInvoiceService);
    }
    @Bean
    public EditInvoice editInvoice(EditInvoiceService editInvoiceService){
        return new EditInvoice(editInvoiceService);
    }
    @Bean
    public PayInvoice payInvoice(PayInvoiceService payInvoiceService, SubtractProductStockService subtractProductStockService){
        return new PayInvoice(payInvoiceService, subtractProductStockService);
    }
    @Bean
    public VerifyStockProduct verifyStockProduct(VerifyStockProductService verifyStockProductService){
        return new VerifyStockProduct(verifyStockProductService);
    }
    @Bean
    public SubtractProductStock subtractProductStock(SubtractProductStockService subtractProductStockService){
        return new SubtractProductStock(subtractProductStockService);
    }
}
