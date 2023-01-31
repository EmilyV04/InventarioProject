package com.inventario.core.infraestructure.repository;

import com.inventario.core.infraestructure.dto.CategoryDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryDto,Integer> {
}
