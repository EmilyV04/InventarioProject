package com.inventario.core.infraestructure.repository;

import com.inventario.core.infraestructure.dto.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductDto,Integer> {
    @Query(nativeQuery = true, value = "update inventario.producto set stock = :stock where id = :id")
    @Modifying
    void updateStock(@Param("stock") Integer stock, @Param("id") Integer idProduct);
}
